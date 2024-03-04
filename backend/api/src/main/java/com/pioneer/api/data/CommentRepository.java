package com.pioneer.api.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByArticleArticleId(Long articleId);

    @Query("SELECT a FROM Comment a JOIN a.user u WHERE u.username = :username")
    List<Comment> findByUsername(String username);

    @Query("SELECT COUNT(c) FROM Comment c WHERE c.article.articleId = :articleId")
    Long countByArticleId(Long articleId);
}
