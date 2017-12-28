package cn.itcast.bos.web.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FileUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.bos.domain.constants.Constants;
import cn.itcast.bos.domain.take_delivery.PageBean;
import cn.itcast.bos.domain.take_delivery.Promotion;

import com.opensymphony.xwork2.ActionContext;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@ParentPackage("json-default")
@Namespace("/")
@Controller
@Scope("prototype")
@SuppressWarnings("all")
public class PromotionAction extends BaseAction<Promotion>{
	
	//分页查询活动数据
	@Action(value="promotion_pageQuery",results={@Result(name="success",type="json")})
	public String pageQuery(){
		//基于webservice来远程获取到bos_management中的活动列表的数据
		PageBean<Promotion> pageBean = WebClient.create(Constants.BOS_MANAGEMENT_URL
				+"/bos_management/services/promotionService/pageQuery?page="
				+page+"&rows="+rows).accept(MediaType.APPLICATION_JSON).get(PageBean.class);
		
		ActionContext.getContext().getValueStack().push(pageBean);;
			return SUCCESS;
		}
	
	//根据id查询详情页面
	@Action(value="promotion_showDetail")
	public String showDetail() throws IOException, TemplateException{
		//先判断id对应的html文件是否存在，如果存在就直接返回
		String htmlRealPath = ServletActionContext.getServletContext().getRealPath("/freemarker");
		File htmlFile = new File(htmlRealPath+"/"+model.getId()+".html");
		
		//如果html文件不存在，查询数据库，结合freemarker模板生成页面，并放在指定的freemarker文件夹里面
		if(!htmlFile.exists()){
			//创建配置对象
			Configuration configuration = new Configuration(Configuration.VERSION_2_3_22);
			//将模板装载进配置对象
			configuration.setDirectoryForTemplateLoading(
				new File("src/main/webapp/WEB-INF/freemarker_template"));
			
			//获得模板对象
			Template template = configuration.getTemplate("promotion_detail.ftl");
			
			//动态数据封装
			Promotion promotion = WebClient.create(Constants.BOS_MANAGEMENT_URL
					+"/bos_management/services/promotionService/promotion/"
					+model.getId()).accept(MediaType.APPLICATION_JSON).get(Promotion.class);
			if(promotion==null){
				return NONE;
			}
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("promotion", promotion);
			
			//这里要设置成utf-8输入，然后下面通过utf-8响应返回，就不胡出现乱码
			template.process(paramMap, new OutputStreamWriter(new FileOutputStream(htmlFile)));
		}
		
		
		
		//存在，直接将文件返回
		//设置响应的编码
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		FileUtils.copyFile(htmlFile, ServletActionContext.getResponse().getOutputStream());
				
		return NONE;
	}
}
