package cn.itcast.cxf.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import cn.itcast.cxf.domain.User;
/*
 * @path服务访问路径资源，如果要使用saveUser方法，那就是/userService/user就是用类的path加上方法的path
 * @Consumes用来指定能够处理客户端传递过来的数据
 * @produces指定能够生成哪种数据格式返回 给客户端
 * */
@Path("/userService")
@Produces("*/*")
public interface IUserService {

	@POST
	@Path("/user")
	@Consumes({ "application/xml", "application/json" })
	public void saveUser(User user);

	@PUT
	@Path("/user")
	@Consumes({ "application/xml", "application/json" })
	public void updateUser(User user);

	@GET
	@Path("/user")
	@Produces({ "application/xml", "application/json" })
	public List<User> findAllUsers();

	@GET
	@Path("/user/{id}")//如果要指定查询单独的某个数据的时候，可以在请求path后面这样子单独加一个参数
	@Consumes("application/xml")
	@Produces({ "application/xml", "application/json" })
	public User finUserById(@PathParam("id") Integer id);//在这里通过属性注入方法注入给形式参数

	@DELETE
	@Path("/user/{id}")
	@Consumes("application/xml")
	public void deleteUser(@PathParam("id") Integer id);
}
