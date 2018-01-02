package cn.itcast.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.itcast.dao.ArticleRespository;
import cn.itcast.domain.Article;
import cn.itcast.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRespository articleRespository;

	public void save(Article article) {
		articleRespository.save(article);
	}

	public void delete(Article article) {
		articleRespository.delete(article);
		
	}

	public Article findOne(Integer id) {
		return articleRespository.findOne(id);
	}

	public Iterable<Article> findAll() {
		return articleRespository.findAll();
	}

	public Page<Article> findPage(Pageable pageable) {
		return articleRespository.findAll(pageable);
	}


}
