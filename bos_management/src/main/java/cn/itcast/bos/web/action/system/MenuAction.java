package cn.itcast.bos.web.action.system;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.bos.domain.system.Menu;
import cn.itcast.bos.domain.system.User;
import cn.itcast.bos.service.system.MenuService;
import cn.itcast.bos.web.action.common.BaseAction;

import com.opensymphony.xwork2.ActionContext;

@ParentPackage("json-default")
@Namespace("/")
@Controller
@Scope("prototype")
public class MenuAction extends BaseAction<Menu> {

	@Autowired
	private MenuService menuService;

	//查询所有的查单
	@Action(value = "menu_list", results = { @Result(name = "success", type = "json") })
	public String list() {
		// 调用业务层，查询所有菜单数据
		List<Menu> menus = menuService.findAll();
		// 存入值栈
		ActionContext.getContext().getValueStack().push(menus);

		return SUCCESS;
	}

	//添加菜单后保存
	@Action(value = "menu_save", results = { @Result(name = "success", type = "redirect", location = "pages/system/menu.html") })
	public String save() {
		// 调用业务层 ，保存菜单数据
		menuService.save(model);
		return SUCCESS;
	}

	@Action(value = "menu_showmenu", results = { @Result(name = "success", type = "json") })
	public String showMenu() {
		// 调用业务层，查询当前用户具有菜单 列表
		Subject subject = SecurityUtils.getSubject();
		//得到当前的用户
		User user = (User) subject.getPrincipal();

		//根据当前用户的id查他具有哪些菜单
		List<Menu> menus = menuService.findByUser(user);
		ActionContext.getContext().getValueStack().push(menus);

		return SUCCESS;
	}
}
