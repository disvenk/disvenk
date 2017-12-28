package cn.itcast.bos.web.action;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.bos.domain.base.Area;
import cn.itcast.bos.domain.constants.Constants;
import cn.itcast.bos.domain.take_delivery.Order;
import cn.itcast.crm.domain.Customer;

//前端系统订单数据处理
@ParentPackage("json-default")
@Namespace("/")
@Controller
@Scope("prototype")
public class OrderAction extends BaseAction<Order> {
	
	private String sendAreaInfo;//发件人省市区信息
	private String recAreaInfo;//收件人省市区信息
	
	public void setSendAreaInfo(String sendAreaInfo) {
		this.sendAreaInfo = sendAreaInfo;
	}

	public void setRecAreaInfo(String recAreaInfo) {
		this.recAreaInfo = recAreaInfo;
	}

	@Action(value="order_add",results={@Result(name="success",type="redirect",location="index.html")})
	public String add() {
		//手动封装Area关联
		Area sendArea = new Area();
		//将省市区按照“/”分割成数组
		String[] sendAreaData = sendAreaInfo.split("/");
		//将数组里面的省市区添加进sendArea对象
		sendArea.setProvince(sendAreaData[0]);
		sendArea.setCity(sendAreaData[1]);
		sendArea.setDistrict(sendAreaData[2]);
		
		Area recArea = new Area();
		String[] recAreaData = recAreaInfo.split("/");
		recArea.setProvince(recAreaData[0]);
		recArea.setCity(recAreaData[1]);
		recArea.setDistrict(recAreaData[2]);
		
		model.setSendArea(sendArea);
		model.setRecArea(recArea);
		
		//将当前登录的客户关联到这个订单中，设置客户编号
		Customer customer =  (Customer) ServletActionContext.getRequest().getSession().getAttribute("customer");
		model.setCustomer_id(customer.getId());
		
		//调用webservice将数据传递到bos_management系统
		WebClient.create(Constants.BOS_MANAGEMENT_URL
				+"/bos_management/services/orderService/order").type(MediaType.APPLICATION_JSON).post(model);
		
		return SUCCESS;
	}
	
}
