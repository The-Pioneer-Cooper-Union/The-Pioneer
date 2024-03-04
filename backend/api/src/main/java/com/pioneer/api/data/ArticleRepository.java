package com.pioneer.api.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>  {

    @Query("SELECT a FROM Article a WHERE LOWER(a.title) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Article> findByTitleContainingIgnoreCase(String searchTerm);

    Optional<Article> findArticleByArticleId(Long articleId);

    @Query("SELECT a FROM Article a JOIN a.user u WHERE u.username = :username")
    List<Article> findByUsername(String username);
}