package cn.itcast.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.itcast.domain.Article;

public interface ArticleRespository extends ElasticsearchRepository<Article, Integer>,
					PagingAndSortingRepository<Article, Integer>{

}
