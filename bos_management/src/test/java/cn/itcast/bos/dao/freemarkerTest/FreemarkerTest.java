package cn.itcast.bos.dao.freemarkerTest;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerTest {
	@Test
	public void test() throws IOException, TemplateException{
		//新建一个ftl文件作为一个模板
		//创建配置对象
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_22);
		//得到模板所在的位置，并封装到配置对象中
		configuration.setDirectoryForTemplateLoading(new File("src/main/webapp/WEB-INF/temple"));
		
		//通过配置对象获取模板对象，参数是模板文件的全名
		Template template = configuration.getTemplate("hello.ftl");
		
		//动态数据对象，这里他必须一个map集合
		Map<String, Object> paramterpMap = new HashMap<String, Object>();
		paramterpMap.put("title", "java");
		paramterpMap.put("msg", "这是第一个freemarkerDemo");
		
		//合并输出
		template.process(paramterpMap, new PrintWriter(System.out));
	}
	
}
