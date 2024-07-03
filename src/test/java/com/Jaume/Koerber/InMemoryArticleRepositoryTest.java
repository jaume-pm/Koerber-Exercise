package com.Jaume.Koerber;

import com.Jaume.Koerber.models.Article;
import com.Jaume.Koerber.repositories.ArticleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class InMemoryArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void testSaveAndGetArticle() {
        Optional<Article> article1 = articleRepository.findById(1L);
        Optional<Article> article2 = articleRepository.findById(2L);

        assertTrue(article1.isPresent());
        assertEquals("Description 1", article1.get().getDescription());

        assertTrue(article2.isPresent());
        assertEquals("Description 2", article2.get().getDescription());
    }

    @Test
    public void testUpdateArticle() {
        Article article = new Article(null, "Test Description", 5.0, 0.5, true);
        Article savedArticle = articleRepository.save(article);

        assertNotNull(savedArticle.getId());
        assertEquals(article.getDescription(), savedArticle.getDescription());

        savedArticle.setDescription("Updated Description");
        Article updatedArticle = articleRepository.save(savedArticle);

        assertEquals(savedArticle.getId(), updatedArticle.getId());
        assertEquals("Updated Description", updatedArticle.getDescription());
    }

    @Test
    public void testFindById() {
        Article article = new Article(null, "Test Description", 5.0, 0.5, true);
        Article savedArticle = articleRepository.save(article);

        Optional<Article> foundArticle = articleRepository.findById(savedArticle.getId());

        assertTrue(foundArticle.isPresent());
        assertEquals(savedArticle.getId(), foundArticle.get().getId());
    }

    @Test
    public void testFindByIdNotFound() {
        Optional<Article> foundArticle = articleRepository.findById(999L);
        assertTrue(foundArticle.isEmpty());
    }

    @Test
    public void testDeleteById() {
        Article article = new Article(null, "Test Description", 5.0, 0.5, true);
        Article savedArticle = articleRepository.save(article);

        articleRepository.deleteById(savedArticle.getId());
        Optional<Article> deletedArticle = articleRepository.findById(savedArticle.getId());

        assertTrue(deletedArticle.isEmpty());
    }

    @Test
    public void testFindAll() {
        List<Article> articles = articleRepository.findAll();

        assertNotNull(articles);
        assertEquals(2, articles.size()); // Assuming two articles are added in @PostConstruct
    }
}
