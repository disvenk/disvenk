package cn.itcast.bos.web.action.system;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.bos.domain.system.User;
import cn.itcast.bos.service.system.UserService;
import cn.itcast.bos.web.action.common.BaseAction;

import com.opensymphony.xwork2.ActionContext;

@Namespace("/")
@ParentPackage("json-default")
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	@Action(value = "user_login", results = {
			@Result(name = "login", type = "redirect", location = "login.html"),
			@Result(name = "success", type = "redirect", location = "index.html") })
	public String login() {
		// 用户名和密码 都保存在model中
		// 基于shiro实现登录
		//subject 指的就是用户对象，这里的叫法不一样而已
		Subject subject = SecurityUtils.getSubject();

		// 用户名和密码信息MD5Util.md5(user.getPwd()
		//authenticationToken是一个认证对象，它用来存储用户登录进来的用户名和密码
		AuthenticationToken token = new UsernamePasswordToken(
				model.getUsername(), model.getPassword());
		try {
			//当subject调用login方法的时候，subject就会起调用安全管理器，然后安全管理器回去调用realm中的认证专用的方法
			//realm中的认证的方法里面有一个参数就是token,底层就把这个token传了过去
			subject.login(token);
			// 登录成功
			// 将用户信息 保存到 Session
			return SUCCESS;
		} catch (AuthenticationException e) {
			// 登录失败
			e.printStackTrace();
			return LOGIN;
		}
	}

	@Action(value = "user_logout", results = { @Result(name = "success", type = "redirect", location = "login.html") })
	public String logout() {
		// 基于shiro完成退出
		//整个登录认证的过程都是基于subject类完成的，
		Subject subject = SecurityUtils.getSubject();
		subject.logout();

		return SUCCESS;
	}

	@Autowired
	private UserService userService;

	@Action(value = "user_list", results = { @Result(name = "success", type = "json") })
	public String list() {
		// 调用业务层 ，返回 用户列表
		List<User> users = userService.findAll();
		ActionContext.getContext().getValueStack().push(users);
		return SUCCESS;
	}

	// 属性驱动
	private String[] roleIds;

	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}

	@Action(value = "user_save", results = { @Result(name = "success", type = "redirect", location = "pages/system/userlist.html") })
	public String save() {
		// 调用业务层
		userService.saveUser(model, roleIds);
		return SUCCESS;
	}
}
