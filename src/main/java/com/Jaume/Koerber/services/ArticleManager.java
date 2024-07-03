package com.Jaume.Koerber.services;

import com.Jaume.Koerber.models.Article;

import java.util.List;

public interface ArticleManager {
    Article createArticle(Article article);
    void deleteArticle(Long id);
    Article updateArticle(Long id, Article article);
    Article getArticle(Long id);
    List<Article> findAllArticles();
}
