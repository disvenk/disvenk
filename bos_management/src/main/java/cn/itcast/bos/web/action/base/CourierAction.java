package cn.itcast.bos.web.action.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;

import cn.itcast.bos.domain.base.Courier;
import cn.itcast.bos.domain.base.Standard;
import cn.itcast.bos.service.base.CourierService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("json-default")
@Namespace("/")
@Controller
@Scope("prototype")
public class CourierAction extends ActionSupport implements
		ModelDriven<Courier> {

	// 模型驱动
	private Courier courier = new Courier();

	@Override
	public Courier getModel() {
		return courier;
	}

	// 注入Service
	@Autowired
	private CourierService courierService;

	// 添加快递员方法和修改的是共用一个action
	@Action(value = "courier_save", results = { @Result(name = "success", location = "./pages/base/courier.html", type = "redirect") })
	public String save() {
		courierService.save(courier);
		return SUCCESS;
	}

	// 属性驱动接收客户端分页参数
	private int page;
	private int rows;

	public void setPage(int page) {
		this.page = page;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	// 分页查询方法
	@Action(value = "courier_pageQuery", results = { @Result(name = "success", type = "json") })
	public String pageQuery() {
		// 封装分页查询Pageable对象
		Pageable pageable = new PageRequest(page - 1, rows);
		// 封装条件查询对象 Specification
		Specification<Courier> specification = new Specification<Courier>() {
			@Override
			// Root 用于获取属性字段，CriteriaQuery可以用于简单条件查询，CriteriaBuilder 用于构造复杂条件查询
			public Predicate toPredicate(Root<Courier> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();

				// 简单单表查询
				//前端封装了查询表达的json数据注入到表格中自动的请求到这里，那么courier里面封装的就是那个json里面的数据
				if (StringUtils.isNotBlank(courier.getCourierNum())) {
					//root先获取传进来的模型对象所携带的属性字段，predicate用来把这些字段设定成查询的参数
					Predicate p1 = cb.equal(
							root.get("courierNum").as(String.class),
							courier.getCourierNum());
					list.add(p1);
				}
				
				if (StringUtils.isNotBlank(courier.getCompany())) {
					Predicate p2 = cb.like(
							root.get("company").as(String.class),
							"%" + courier.getCompany() + "%");
					list.add(p2);
				}
				
				if (StringUtils.isNotBlank(courier.getType())) {
					Predicate p3 = cb.equal(root.get("type").as(String.class),
							courier.getType());
					list.add(p3);
				}
				
				// 多表查询
				//如果本表中有其他表的外键，就要使用到多表查询，这里的额外加了一个join对象里面的泛型就是用来使用多表查询的
				Join<Courier, Standard> standardJoin = root.join("standard",/*这里是外键standard类*/
						JoinType.INNER);
				if (courier.getStandard() != null
						&& StringUtils.isNotBlank(courier.getStandard()
								.getName())) {
					Predicate p4 = cb.like(
							standardJoin.get("name"/*这是standard类里的标准名称*/).as(String.class), "%"
									+ courier.getStandard().getName() + "%");
					list.add(p4);
				}
				return cb.and(list.toArray(new Predicate[0]));
			}
		};

		// 调用业务层 ，返回 Page
		//这个里面的参数就是传进来上面已经封装好的查询条件，有简单的，有复杂的
		Page<Courier> pageData = courierService.findPageData(specification,
				pageable);
		// 将返回page对象 转换datagrid需要格式
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pageData.getTotalElements());
		result.put("rows", pageData.getContent());
		// 将结果对象 压入值栈顶部
		ActionContext.getContext().getValueStack().push(result);

		return SUCCESS;
	}

	// 属性驱动
	private String ids;

	public void setIds(String ids) {
		this.ids = ids;
	}

	// 作废快递员
	@Action(value = "courier_delBatch", results = { @Result(name = "success", location = "./pages/base/courier.html", type = "redirect") })
	public String delBatch() {
		// 按,分隔ids
		String[] idArray = ids.split(",");
		// 调用业务层，批量作废
		courierService.delBatch(idArray);
		System.out.println("已经执行了批量作废");
		return SUCCESS;
	}
	
	// 还原快递员
		@Action(value = "courier_delBatch2", results = { @Result(name = "success", location = "./pages/base/courier.html", type = "redirect") })
		public String exitBatch() {
			// 按,分隔ids
			String[] idArray = ids.split(",");
			// 调用业务层，批量作废
			courierService.exitBatch(idArray);
			System.out.println("已经执行了批量作废");
			return SUCCESS;
		}
		
		//查询未关联定区的快递员
		@Action(value = "courier_findnoassociation", 
				results = { @Result(name = "success", type = "json") })
		public String findnoassociation() {
			// 调用业务层，查询未关联定区的快递员 
			List<Courier> couriers = courierService.findNoAssociation();
			// 将查询快递员列表 压入值栈 
			ActionContext.getContext().getValueStack().push(couriers);
			return SUCCESS;
		}
}
