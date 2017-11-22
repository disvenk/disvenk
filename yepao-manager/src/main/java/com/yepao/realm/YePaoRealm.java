package com.yepao.realm;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.yepao.mapper.RoleMapper;
import com.yepao.mapper.UserMapper;
import com.yepao.mapper.UserRoleMapper;
import com.yepao.pojo.Permission;
import com.yepao.pojo.Role;
import com.yepao.pojo.User;
import com.yepao.pojo.UserExample;
import com.yepao.pojo.UserExample.Criteria;
import com.yepao.pojo.UserRole;
import com.yepao.pojo.UserRoleExample;
import com.yepao.pojo.UserExample.Criteria;




// 自定义Realm ，实现安全数据 连接
// @Service("bosRealm")
public class YePaoRealm extends AuthorizingRealm {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Override
	// 授权...
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		System.out.println("shiro 授权管理...");
		//创建授权对象
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// 根据当前登录用户 查询对应角色和权限
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		// 调用业务层，查询角色
		//根据登录的用户，查询它分配的角色
		UserRoleExample example = new UserRoleExample();
		com.yepao.pojo.UserRoleExample.Criteria criteria = example.createCriteria();
		 criteria.andUserNameEqualTo(user.getName());
		List<UserRole> userRoles = userRoleMapper.selectByExample(example);
		for (UserRole userRole : userRoles) {
			Role role = roleMapper.selectByPrimaryKey(userRole.getRoleId());
			authorizationInfo.addRole(role.getKeywords());
			
		}

		//我们将角色和权限添加到权限对象里面以后，安全管理对象就会自动的去判断当前用户是否含有指定的角色和指定的权限
		//程序只会关心授权对象里面有没有指定的角色或者权限，它不会去管是哪个对象在登录
		return authorizationInfo;
	}

	@Override
	// 认证...
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		System.out.println("shiro 认证管理... ");

		// 转换token
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

		// 根据用户名 查询 用户信息
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(usernamePasswordToken.getUsername());
		 List<User> users = userMapper.selectByExample(example);
		if (users.get(0) == null) {
			// 用户名不存在
			// 参数一： 期望登录后，保存在Subject中信息
			// 参数二： 如果返回为null 说明用户不存在，报用户名
			// 参数三 ：realm名称
			//当第一个参数user为null时会报错
			//return new SimpleAuthenticationInfo(user,null,getName()); 
			return null;
		} else {
			// 用户名存在
			// 当返回用户密码时，securityManager安全管理器，自动比较返回密码和用户输入密码是否一致
			// 如果密码一致 登录成功， 如果密码不一致 报密码错误异常
			return new SimpleAuthenticationInfo(users.get(0), users.get(0).getPassword(),
					getName());
		}

	}

}
