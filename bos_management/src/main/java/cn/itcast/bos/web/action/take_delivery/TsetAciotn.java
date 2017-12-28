package cn.itcast.bos.web.action.take_delivery;

import java.util.Arrays;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.bos.domain.take_delivery.WayBill;
import cn.itcast.bos.web.action.common.BaseAction;

@ParentPackage("struts-default")
@Namespace("/")
@Controller
@Scope("prototype")
public class TsetAciotn extends BaseAction<WayBill> {
	@Action(value="test")
	public void test(){
		System.out.println(model.getWayBillNum()+"运单号");
		System.out.println(model.getOrder().getId()+"订单号");
	}
	
	private String[] hobby;
	
	
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}


	@Action(value="test1")
	public void test1(){
		System.out.println(Arrays.asList(hobby));
	}
}
