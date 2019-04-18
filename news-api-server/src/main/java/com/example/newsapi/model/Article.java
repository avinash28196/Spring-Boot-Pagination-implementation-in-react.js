package com.example.newsapi.model;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name="articles")
public class Article {

		
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="ARTICLEID")
	    private Long id;
		
		@Column(name="ARTICLEWORDCOUNT")
		private Long articleWordCount;
		
		
	    @Size(max = 1000)
	    private String headline;
		
		private String category;
		
		@Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "PUBDATE",  updatable = false)
	    @CreatedDate
	    private Date pubDate;
		
		@Lob
		private String snippet;
		
		@Lob
		private String webURL;

		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getArticleWordCount() {
			return articleWordCount;
		}

		public void setArticleWordCount(Long articleWordCount) {
			this.articleWordCount = articleWordCount;
		}

		public String getHeadline() {
			return headline;
		}

		public void setHeadline(String headline) {
			this.headline = headline;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String catagory) {
			this.category = catagory;
		}

		public Date getPubDate() {
			return pubDate;
		}

		public void setPubDate(Date pubDate) {
			this.pubDate = pubDate;
		}

		public String getSnippet() {
			return snippet;
		}

		public void setSnippet(String snippet) {
			this.snippet = snippet;
		}

		public String getWebURL() {
			return webURL;
		}

		public void setWebURL(String webURL) {
			this.webURL = webURL;
		}

}
