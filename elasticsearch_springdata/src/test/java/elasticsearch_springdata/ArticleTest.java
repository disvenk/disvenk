package elasticsearch_springdata;

import org.elasticsearch.client.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.dao.ArticleRespository;
import cn.itcast.domain.Article;
import cn.itcast.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ArticleTest {
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private Client client;//使用客户端就是在使用原生的API
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	@Test
	public void test(){
		elasticsearchTemplate.createIndex(Article.class);//添加索引
		elasticsearchTemplate.putMapping(Article.class);//添加映射
	}
}
