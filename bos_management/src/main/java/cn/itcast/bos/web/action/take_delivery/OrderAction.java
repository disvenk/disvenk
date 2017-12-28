package cn.itcast.bos.web.action.take_delivery;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.bos.domain.take_delivery.Order;
import cn.itcast.bos.service.take_delivery.OrderService;
import cn.itcast.bos.web.action.common.BaseAction;

import com.opensymphony.xwork2.ActionContext;

@ParentPackage("json-default")
@Namespace("/")
@Controller
@Scope("prototype")
public class OrderAction extends BaseAction<Order> {
	
		@Autowired
		private OrderService orderService;
		
		//补录运单时的回显，在运单补录页面的ajax请求
		@Action(value="order_findByOrderNum",results={@Result(name="success",type="json")})
		public String findByOrderNum(){
			//调用service层
			Order order = orderService.findByOrderNum(model.getOrderNum());
			Map<String, Object> result = new HashMap<String, Object>();
			if(order==null){
				//订单号不存在
				result.put("success", false);
			}else{
				//订单号存在
				result.put("success", true);
				result.put("orderData", order);
			}
			ActionContext.getContext().getValueStack().push(result);
			return SUCCESS;
		}
}
