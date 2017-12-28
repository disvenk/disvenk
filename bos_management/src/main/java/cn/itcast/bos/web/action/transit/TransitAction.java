package cn.itcast.bos.web.action.transit;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import cn.itcast.bos.domain.transit.TransitInfo;
import cn.itcast.bos.service.transit.TransitInfoService;
import cn.itcast.bos.web.action.common.BaseAction;

import com.opensymphony.xwork2.ActionContext;

@ParentPackage("json-default")
@Namespace("/")
@Controller
@Scope("prototype")
public class TransitAction extends BaseAction<TransitInfo>{

	private String wayBillIds;
	
	public void setWayBillIds(String wayBillIds) {
		this.wayBillIds = wayBillIds;
	}

	@Autowired
	private TransitInfoService transitInfoService;
	
	//开启中转配送
	@Action(value="transit_create",results={@Result(name="success",type="json")})
	public String create(){
		//调用业务层，保存transitInfo信息
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			transitInfoService.createTransits(wayBillIds);
			//成功
			result.put("success",true);
			result.put("msg", "开启中转配送成功");
		}catch(Exception e){
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "开启中转配送失败，异常"+e.getMessage());
		}
		ActionContext.getContext().getValueStack().push(result);
		return SUCCESS;
	}
	
	//分页查询运输信息
	@Action(value="transit_pageQuery",results={@Result(name="success",type="json")})
	public String pageQuery(){
		//分页查询
		Pageable pageable = new PageRequest(page-1,rows);
		//调用业务层
		Page<TransitInfo> pageData = transitInfoService.findAll(pageable);
		
		//压入值栈
		ActionContext.getContext().getValueStack().push(pageData);
		return SUCCESS;
	}
}
