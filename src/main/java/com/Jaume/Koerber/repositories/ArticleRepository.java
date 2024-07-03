package com.Jaume.Koerber.repositories;

import com.Jaume.Koerber.models.Article;
import java.util.List;
import java.util.Optional;

public interface ArticleRepository {
    Article save(Article article);
    Optional<Article> findById(Long id);
    void deleteById(Long id);
    List<Article> findAll();
}
