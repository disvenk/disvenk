package cn.itcast.bos.web.action.take_delivery;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import cn.itcast.bos.domain.take_delivery.Promotion;
import cn.itcast.bos.service.take_delivery.PromotionService;
import cn.itcast.bos.web.action.common.BaseAction;

@ParentPackage("json-default")
@Namespace("/")
@Controller
@Scope("prototype")
public class PromotionAction extends BaseAction<Promotion> {
	
		private File titleImgFile;//宣传图文件
		private String titleImgFileFileName;//宣传图文件名
		
		public void setTitleImgFile(File titleImgFile) {
			this.titleImgFile = titleImgFile;
		}
		public void setTitleImgFileFileName(String titleImgFileFileName) {
			this.titleImgFileFileName = titleImgFileFileName;
		}
		
		@Autowired
		private PromotionService promotionService;
		
		@Action(value="promotion_save",results={@Result(name="success",
				type="redirect",
				location="/pages/take_delivery/promotion.html")})
		public String save() throws IOException{
			//得到宣传图上传后保存的路径
			String savePath = ServletActionContext.getServletContext().getRealPath("/upload/");
			//得到图片展示的相对路径
			String saveUrl = ServletActionContext.getRequest().getContextPath()+"/upload/";
			
			//生成随机图片名
			UUID uuid = UUID.randomUUID();
			//得到文件的扩展名
			String exName = titleImgFileFileName.substring(titleImgFileFileName.lastIndexOf("."));
			//拼接成新的文件名
			String randomFileName = uuid+exName;
			
			//得到一个file对象封装的保存路径
			File destFile = new File(savePath+"/"+randomFileName);
			FileUtils.copyFile(titleImgFile, destFile);
			
			//将相对路径保存在model中
			model.setTitleImg(saveUrl+randomFileName);
			
			//调用service层保存promotion对象
			promotionService.save(model);
			return SUCCESS;
		}
		
		
		//分页查询显示promotion
		@Action(value="promotion_pageQuery",results={@Result(name="success",type="json")})
		public String pageQuery(){
			//构造分页查询对象
			Pageable pageable = new PageRequest(page-1,rows);
			//调用业务层，完成查询
			Page<Promotion> pageData = promotionService.findPageData(pageable);
			//压入值栈
			pushPageDataToValueStack(pageData);
			return SUCCESS;
		}
}
