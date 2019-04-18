package com.example.newsapi.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.newsapi.exception.ResourceNotFoundException;
import com.example.newsapi.model.Article;
import com.example.newsapi.repository.ArticleRepository;


@RestController
public class ArticleController {
	
	 @Autowired
	    private ArticleRepository articleRepository;
	    
	    
	 @GetMapping("/articles")
	 public Page<Article> getAllArticles(Pageable pageable) {
	    return articleRepository.findAll(pageable);
	 }
	 
	 @GetMapping("/api/category/{category}")
	 public Page<Article> getAllByCategory(@PathVariable String category,Pageable pageable){
		 return articleRepository.findByCategory(category, pageable);
	 }
	 
	 @PostMapping("/api/article")
	 public Article createArticle(@Valid @RequestBody Article article) {
	     return articleRepository.save(article);
	 }
	 
	 
	 
	 @DeleteMapping("/api/articles/{articleId}")
	 public ResponseEntity<?> deleteArticle(@PathVariable Long articleId){
		return articleRepository.findById(articleId)
			.map(article -> {
				articleRepository.delete(article);
				return ResponseEntity.ok().build();
				})
		.orElseThrow(() -> new ResourceNotFoundException("ArticleId  " + articleId + " not found"));
	 }
	 
	 @PutMapping("/api/article/{articleId}")
	    public Article updateArticle(@PathVariable Long articleId, @Valid @RequestBody Article articleUpdate) {
	        return articleRepository.findById(articleId)
	        	.map(article -> {
	        		article.setHeadline(articleUpdate.getHeadline());
	        		article.setSnippet(articleUpdate.getSnippet());
	        		article.setCategory(articleUpdate.getCategory());
	        		return articleRepository.save(article);
	        	})
	      .orElseThrow(() -> new ResourceNotFoundException("ArticleId " + articleId + " not found"));
	  }
			
		 
	
	   

}
