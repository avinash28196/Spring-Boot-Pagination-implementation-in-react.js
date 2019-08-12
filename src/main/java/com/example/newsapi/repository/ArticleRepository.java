package com.example.newsapi.repository;

import com.example.newsapi.model.Article;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {
	
	Page<Article> findByCategory(String category,Pageable pageable);

}