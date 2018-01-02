package cn.itcast.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.itcast.domain.Article;

public interface ArticleService {
	public void save(Article article);
	public void delete(Article article);
	public Article findOne(Integer id);
	public Iterable<Article> findAll();
	public Page<Article> findPage(Pageable pageable);
}
