package cn.itcast.bos.service.take_delivery;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.itcast.bos.domain.take_delivery.PageBean;
import cn.itcast.bos.domain.take_delivery.Promotion;

public interface PromotionService {
	//保存活动的对象
	public void save(Promotion promotion);

	//查找所有的活动列表
	public Page<Promotion> findPageData(Pageable pageable);
	
	//设置webservice的请求方法，在客户端显示
	@Path("/pageQuery")
	@GET
	@Produces({"application/xml","application/json"})
	PageBean<Promotion> findPageData(@QueryParam("page") int page,@QueryParam("rows") int rows);
		
	//根据id查询详情
	@Path("promotion/{id}")
	@GET
	@Produces({"application/xml","application/json"})
	public Promotion findById(@PathParam("id") Integer id);
	
	// 设置活动过期
		void updateStatus(Date date);
		
		void show();
}
