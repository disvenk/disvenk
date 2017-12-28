package cn.itcast.bos.web.action.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
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

import cn.itcast.bos.domain.base.Area;
import cn.itcast.bos.service.base.AreaService;
import cn.itcast.bos.utils.PinYin4jUtils;
import cn.itcast.bos.web.action.common.BaseAction;

@ParentPackage("json-default")
@Namespace("/")
@Controller
@Scope("prototye")
public class AreaAction extends BaseAction<Area>{

	// 注入业务层对象
	@Autowired
	private AreaService areaService;

	// 接收上传文件
	private File file;

	public void setFile(File file) {
		this.file = file;
	}

	//单独区域数据的添加
	@Action(value="area_addSignle",results={@Result(name="success",location = "./pages/base/area.html", type = "redirect")})
	public String areaSginleAdd(){
		areaService.saveBatch(model);
		return SUCCESS;
	}
	
	// 批量区域数据导入
	@Action(value = "area_batchImport")
	public String batchImport() throws IOException {
		//先定义一个集合，用作批量保存，因为dao层的save方法同时集成了批量保存的方法
		List<Area> areas = new ArrayList<Area>();
		// 编写解析代码逻辑
		// 基于.xls 格式解析 HSSF
		// 1、 加载Excel文件对象，将前端上传的文件解析
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(file));
		// 2、 读取第一个sheet，一个Excel文件下面有多个sheet
		HSSFSheet sheet = hssfWorkbook.getSheetAt(0);
		// 3、 读取sheet中每一行
		for (Row row : sheet) {
			// 一行数据 对应 一个区域对象
			if (row.getRowNum() == 0) {
				// 第一行 跳过，第一行是列表还ABCDEFG这些
				continue;
			}
			// 跳过空行，读取到空行的时候就相当于结束了,这里要用isBlank
			if (row.getCell(0) == null
					|| StringUtils.isBlank(row.getCell(0).getStringCellValue())) {
				continue;
			}
			Area area = new Area();
			//getCell(index)定位到每一行的对应索引的单元格，getStringCellValue()定位到后获取该索引处的元素值
			area.setId(row.getCell(0).getStringCellValue());
			area.setProvince(row.getCell(1).getStringCellValue());
			area.setCity(row.getCell(2).getStringCellValue());
			area.setDistrict(row.getCell(3).getStringCellValue());
			area.setPostcode(row.getCell(4).getStringCellValue());
			
			//下面是额外的不要下面的也能运行
			// 基于pinyin4j生成城市编码和简码
			String province = area.getProvince();//获取省份
			String city = area.getCity();//获取城市
			String district = area.getDistrict();//获取区域
			
			//截取省份的前面，去掉省字
			province = province.substring(0, province.length() - 1);
			//去掉市字
			city = city.substring(0, city.length() - 1);
			//胡场镇的镇字去掉
			district = district.substring(0, district.length() - 1);
			
			// 简码，生成HBXTHC
			String[] headArray = PinYin4jUtils.getHeadByString(province + city
					+ district);
			StringBuffer buffer = new StringBuffer();
			for (String headStr : headArray) {
				buffer.append(headStr);
			}
			String shortcode = buffer.toString();
			area.setShortcode(shortcode);
			
			// 城市编码，生成xiantao
			String citycode = PinYin4jUtils.hanziToPinyin(city, "");
			area.setCitycode(citycode);
			
			//将对象添加进数组
			areas.add(area);
		}
		// 调用业务层
		areaService.saveBatch(areas);

		return NONE;
	}

	// 分页查询
	@Action(value = "area_pageQuery", results = { @Result(name = "success", type = "json") })
	public String pageQuery() {
		// 构造分页查询对象
		Pageable pageable = new PageRequest(page - 1, rows);
		
		// 构造条件查询对象
		Specification<Area> specification = new Specification<Area>() {
			@Override
			public Predicate toPredicate(Root<Area> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();
				if (StringUtils.isNotBlank(model.getProvince())) {
					Predicate p1 = cb.like(root.get("province")
							.as(String.class), "%" + model.getProvince() + "%");
					list.add(p1);
				}
				if (StringUtils.isNotBlank(model.getCity())) {
					Predicate p2 = cb.like(root.get("city").as(String.class),
							"%" + model.getCity() + "%");
					list.add(p2);
				}
				if (StringUtils.isNotBlank(model.getDistrict())) {
					Predicate p3 = cb.like(root.get("district")
							.as(String.class), "%" + model.getDistrict() + "%");
					list.add(p3);
				}
				
				return cb.and(list.toArray(new Predicate[0]));
			}
		};
		// 调用业务层完成查询
		Page<Area> pageData = areaService.findPageData(specification, pageable);
		// 压入值栈
		pushPageDataToValueStack(pageData);

		return SUCCESS;
	}
}
