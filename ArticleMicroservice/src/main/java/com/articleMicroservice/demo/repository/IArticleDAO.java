package com.articleMicroservice.demo.repository;
import java.util.List;

import com.articleMicroservice.demo.entity.Article;

public interface IArticleDAO {
    List<Article> getAllArticles();
    Article getArticleById(int articleId);
    void createArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(int articleId);
    boolean articleExists(String title, String category, String authorName, String tags, String dateTime1);
}
 