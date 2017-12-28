package cn.itcast.bos.web.action.report;

import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.bos.domain.take_delivery.WayBill;
import cn.itcast.bos.service.take_delivery.WayBillService;
import cn.itcast.bos.utils.FileUtils;
import cn.itcast.bos.web.action.common.BaseAction;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

@ParentPackage("json-default")
@Namespace("/")
@Controller
@Scope("prototype")
public class ReportAction extends BaseAction<WayBill>{
		
	@Autowired
	private WayBillService wayBillService;
	
	//导出Excel
	@Action(value="report_exportXls")
	public String exportXls() throws IOException{
		//查询出所有满足条件的数据
		List<WayBill> wayBills = wayBillService.findWayBills(model);
		
		// 生成Excel文件
				HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
				HSSFSheet sheet = hssfWorkbook.createSheet("运单数据");
				// 表头，就是第一排的信息字段
				HSSFRow headRow = sheet.createRow(0);
				headRow.createCell(0).setCellValue("运单号");
				headRow.createCell(1).setCellValue("寄件人");
				headRow.createCell(2).setCellValue("寄件人电话");
				headRow.createCell(3).setCellValue("寄件人地址");
				headRow.createCell(4).setCellValue("收件人");
				headRow.createCell(5).setCellValue("收件人电话");
				headRow.createCell(6).setCellValue("收件人地址");
				// 表格数据
				for (WayBill wayBill : wayBills) {
					//每次在已经有数据的行的后面加一，就是追加的效果
					HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
					dataRow.createCell(0).setCellValue(wayBill.getWayBillNum());
					dataRow.createCell(1).setCellValue(wayBill.getSendName());
					dataRow.createCell(2).setCellValue(wayBill.getSendMobile());
					dataRow.createCell(3).setCellValue(wayBill.getSendAddress());
					dataRow.createCell(4).setCellValue(wayBill.getRecName());
					dataRow.createCell(5).setCellValue(wayBill.getRecMobile());
					dataRow.createCell(6).setCellValue(wayBill.getRecAddress());
				}

				// 下载导出
				// 设置头信息
				//设置文件的minetype
				ServletActionContext.getResponse().setContentType(
						"application/vnd.ms-excel");
				String filename = "运单数据.xls";//文件的文件名
				String agent = ServletActionContext.getRequest()
						.getHeader("user-agent");//获取所使用的浏览器类型
				filename = FileUtils.encodeDownloadFilename(filename, agent);//按照指定的浏览器进行编码
				ServletActionContext.getResponse().setHeader("Content-Disposition",
						"attachment;filename=" + filename);//设置下载的文件叫什么名字

				ServletOutputStream outputStream = ServletActionContext.getResponse()
						.getOutputStream();//获取输入流
				hssfWorkbook.write(outputStream);//写入导出

				// 关闭
				hssfWorkbook.close();
		return NONE;
	}
	
	//导出PDF
	@Action("report_exportPdf")
	public String exportPdf() throws IOException, DocumentException {
		// 查询出 满足当前条件 结果数据
		List<WayBill> wayBills = wayBillService.findWayBills(model);

		// 下载导出
		// 设置头信息
		ServletActionContext.getResponse().setContentType("application/pdf");
		String filename = "运单数据.pdf";
		String agent = ServletActionContext.getRequest()
				.getHeader("user-agent");
		filename = FileUtils.encodeDownloadFilename(filename, agent);
		ServletActionContext.getResponse().setHeader("Content-Disposition",
				"attachment;filename=" + filename);

		// 生成PDF文件
		Document document = new Document();
		PdfWriter.getInstance(document, ServletActionContext.getResponse()
				.getOutputStream());
		document.open();
		// 写PDF数据
		// 向document 生成pdf表格
		Table table = new Table(7);
		table.setWidth(80); // 宽度
		table.setBorder(1); // 边框
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER); // 水平对齐方式
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_TOP); // 垂直对齐方式

		// 设置表格字体
		BaseFont cn = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H",
				false);
		Font font = new Font(cn, 10, Font.NORMAL, Color.BLUE);

		// 写表头
		table.addCell(buildCell("运单号", font));
		table.addCell(buildCell("寄件人", font));
		table.addCell(buildCell("寄件人电话", font));
		table.addCell(buildCell("寄件人地址", font));
		table.addCell(buildCell("收件人", font));
		table.addCell(buildCell("收件人电话", font));
		table.addCell(buildCell("收件人地址", font));
		// 写数据
		for (WayBill wayBill : wayBills) {
			table.addCell(buildCell(wayBill.getWayBillNum(), font));
			table.addCell(buildCell(wayBill.getSendName(), font));
			table.addCell(buildCell(wayBill.getSendMobile(), font));
			table.addCell(buildCell(wayBill.getSendAddress(), font));
			table.addCell(buildCell(wayBill.getRecName(), font));
			table.addCell(buildCell(wayBill.getRecMobile(), font));
			table.addCell(buildCell(wayBill.getRecAddress(), font));
		}
		// 将表格加入文档
		document.add(table);

		document.close();

		return NONE;
	}
	
	private Cell buildCell(String content, Font font)
			throws BadElementException {
		Phrase phrase = new Phrase(content, font);
		return new Cell(phrase);
	}
}
