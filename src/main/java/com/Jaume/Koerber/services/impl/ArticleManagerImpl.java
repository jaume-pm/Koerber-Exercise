package com.Jaume.Koerber.services.impl;

import com.Jaume.Koerber.models.Article;
import com.Jaume.Koerber.repositories.ArticleRepository;
import com.Jaume.Koerber.services.ArticleManager;
import com.Jaume.Koerber.services.ArticleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleManagerImpl implements ArticleManager {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleManagerImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long id) {
        if (articleRepository.findById(id).isEmpty()) {
            throw new ArticleNotFoundException("Article not found with id: " + id);
        }
        articleRepository.deleteById(id);
    }

    @Override
    public Article updateArticle(Long id, Article article) {
        if (articleRepository.findById(id).isEmpty()) {
            throw new ArticleNotFoundException("Article not found with id: " + id);
        }
        article.setId(id);
        return articleRepository.save(article);
    }

    @Override
    public Article getArticle(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException("Article not found with id: " + id));
    }

    @Override
    public List<Article> findAllArticles() {
        return articleRepository.findAll();
    }
}
