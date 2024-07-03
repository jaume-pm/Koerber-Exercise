package com.Jaume.Koerber.repositories.impl;

import com.Jaume.Koerber.models.Article;
import com.Jaume.Koerber.repositories.ArticleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryArticleRepository implements ArticleRepository {

    private final List<Article> articles = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Article save(Article article) {
        if (article.getId() == null) {
            article.setId(counter.incrementAndGet());
            articles.add(article);
        } else {
            deleteById(article.getId());
            articles.add(article);
        }
        return article;
    }

    @Override
    public Optional<Article> findById(Long id) {
        return articles.stream()
                .filter(article -> article.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deleteById(Long id) {
        articles.removeIf(article -> article.getId().equals(id));
    }

    @Override
    public List<Article> findAll() {
        return new ArrayList<>(articles);
    }

    @PostConstruct
    public void init() {
        // Add a couple of articles when the application starts
        save(new Article(null, "Description 1", 10.0, 1.0, true));
        save(new Article(null, "Description 2", 20.0, 2.0, true));
    }
}
