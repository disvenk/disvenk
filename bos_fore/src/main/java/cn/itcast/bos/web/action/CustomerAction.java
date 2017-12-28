package cn.itcast.bos.web.action;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;

import cn.itcast.bos.domain.constants.Constants;
import cn.itcast.bos.utils.MailUtils;
import cn.itcast.crm.domain.Customer;
/*
 * 获取验证码
 * 提交注册
 * 验证码通过后，保存客户，邮箱和手机是一起保存的
 * 保存客户后，随即给客户的邮箱发送一封邮件
 * 打开邮件，点击链接进行激活
 * */
@ParentPackage("json-default")
@Namespace("/")
@Controller
@Scope("prototype")
public class CustomerAction extends BaseAction<Customer> {
	@Autowired
	@Qualifier("jmsQueueTemplate")
	private JmsTemplate jmsTemplate;//注入短信模板

	//angularjs的http验证码的请求地址
	@Action(value = "customer_sendSms")
	public String sendSms() {
		// 手机号保存在Customer对象
		// 生成短信验证码
		String randomCode = RandomStringUtils.randomNumeric(4);//内置的一个方法，参数表示生成几位数的验证码
		// 将短信验证码 保存到session
		ServletActionContext.getRequest().getSession()
				.setAttribute(model.getTelephone(), randomCode);

		System.out.println("生成手机验证码为：" + randomCode);
		// 编辑短信内容
	final String msg = "尊敬的用户您好，本次获取的验证码为：" + randomCode
				+ ",服务电话：4006184000";
	
		// 调用MQ服务，发送一条消息
		//send方法是一个生产者，它将消息发送到MQ的队列中，我们可以创建消费者去进行消费
		jmsTemplate.send("bos_sms"/*队列的名字*/, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				//有session对象得到一个MapMessage对象
				//使用mapMessage可以存储多个键值对的数据
				MapMessage mapMessage = session.createMapMessage();
				mapMessage.setString("telephone", model.getTelephone());
				mapMessage.setString("msg", msg);
				return mapMessage;
			}
		});
		return NONE;

	}

	//获取提交过来的验证码进行校验
	// 属性驱动
	private String checkcode;

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Action(value = "customer_regist", results = {
			@Result(name = "success", type = "redirect", location = "signup-success.html"),
			@Result(name = "input", type = "redirect", location = "signup.html") })
	public String regist() {
		// 先校验短信验证码，如果不通过，调回注册页面
		// 从session获取 之前生成验证码
		String checkcodeSession = (String) ServletActionContext.getRequest()
				.getSession().getAttribute(model.getTelephone());
		if (checkcodeSession == null || !checkcodeSession.equals(checkcode)) {
			System.out.println("短信验证码错误...");
			// 短信验证码错误
			return INPUT;
		}
		// 调用webService 连接CRM 保存客户信息
		WebClient
				.create("http://localhost:9002/crm_management/services"
						+ "/customerService/customer")
				.type(MediaType.APPLICATION_JSON).post(model);
		System.out.println("客户注册成功...");

		// 发送一封激活邮件
		// 生成激活码
		String activecode = RandomStringUtils.randomNumeric(32);

		// 将激活码保存到redis，设置24小时失效
		redisTemplate.opsForValue().set(model.getTelephone(), activecode, 24,
				TimeUnit.HOURS);

		// 调用MailUtils发送激活邮件
		String content = "尊敬的客户您好，请于24小时内，进行邮箱账户的绑定，点击下面地址完成绑定:<br/><a href='"
				+ MailUtils.activeUrl + "?telephone=" + model.getTelephone()
				+ "&activecode=" + activecode + "'>速运快递邮箱绑定地址</a>";
		MailUtils.sendMail("速运快递激活邮件", content, model.getEmail());

		return SUCCESS;
	}

	//收到点击上面的地址传过来的激活码
	// 属性驱动
	//同一个action内不同的方法之间可以相互请求和传值
	private String activecode;

	public void setActivecode(String activecode) {
		this.activecode = activecode;
	}

	//上面点击那个地址进行绑定，是请求的的这里
	@Action("customer_activeMail")
	public String activeMail() throws IOException {
		ServletActionContext.getResponse().setContentType(
				"text/html;charset=utf-8");
		// 判断激活码是否有效
		String activecodeRedis = redisTemplate.opsForValue().get(
				model.getTelephone());
		if (activecodeRedis == null || !activecodeRedis.equals(activecodeRedis)) {
			// 激活码无效
			//这里还没有添加重新绑定的功能
			ServletActionContext.getResponse().getWriter()
					.println("激活码无效，请登录系统，重新绑定邮箱！");
		} else {
			// 激活码有效
			// 防止重复绑定
			// 调用CRM webService 查询客户信息，判断是否已经绑定
			Customer customer = WebClient
					.create("http://localhost:9002/crm_management/services"
							+ "/customerService/customer/telephone/"
							+ model.getTelephone())
					.accept(MediaType.APPLICATION_JSON).get(Customer.class);
			if (customer.getType() == null || customer.getType() != 1) {
				// 没有绑定,进行绑定
				WebClient.create(
						"http://localhost:9002/crm_management/services"
								+ "/customerService/customer/updatetype/"
								+ model.getTelephone()).get();
				//只要查询手机号码是否绑定即可，因为手机和邮箱是一起绑定了
				ServletActionContext.getResponse().getWriter()
						.println("邮箱绑定成功！");
			} else {
				// 已经绑定过
				ServletActionContext.getResponse().getWriter()
						.println("邮箱已经绑定过，无需重复绑定！");
			}

			// 删除redis的激活码
			redisTemplate.delete(model.getTelephone());
		}
		return NONE;
	}
	
	//用户登录
	@Action(value="customer_login",results={
			@Result(name="login",location="login.html",type="redirect"),
			@Result(name="success",location="index.html#/myhome",type="redirect")
			})
	public String login(){
		Customer customer = WebClient.create(Constants.CRM_MANAGEMENT_URL
				+"/crm_management/services/customerService/customer/login?telephone="
				+model.getTelephone()+"&password="
				+model.getPassword()).accept(MediaType.APPLICATION_JSON).get(Customer.class);
		
		if(customer==null){
			//登录失败
			return LOGIN;
		}else {
			//登录成功
			ServletActionContext.getRequest().getSession().setAttribute("customer", customer);
			return SUCCESS;
		}
		
	}
	}