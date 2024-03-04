package com.pioneer.api.business;

import com.pioneer.api.data.Article;
import com.pioneer.api.data.ArticleRepository;

import com.pioneer.api.data.User;
import com.pioneer.api.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }


    public Optional<Article> findArticleByArticleId (Long articleId){
        return articleRepository.findArticleByArticleId(articleId);
    }

    public Article addArticle(Article article) {
        User user = userRepository.findById(article.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + article.getUserId()));
        article.setUser(user);
        return articleRepository.save(article);
    }

    public List<Article> findArticlesByUsername(String username) {
        return articleRepository.findByUsername(username);
    }
    public List<Article> searchArticlesByTitle(String title) {
        return articleRepository.findByTitleContainingIgnoreCase(title);
    }

    public void updateArticleInfo(Article article){
        User user = userRepository.findById(article.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + article.getUserId()));
        article.setUser(user);
        articleRepository.save(article);
    }

    public void deleteArticle(Long articleId) {
        articleRepository.deleteById(articleId);
    }
}