package com.pioneer.api.business;

import com.pioneer.api.data.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, UserRepository userRepository, ArticleRepository articleRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }


    public List<Comment> findByArticleArticleId(Long articleId) {
        return commentRepository.findByArticleArticleId(articleId);
    }
    

    public Comment addComment(Comment comment) {
        User user = userRepository.findById(comment.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + comment.getUserId()));
        Article article = articleRepository.findById(comment.getArticleId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + comment.getArticleId()));
        comment.setUser(user);
        comment.setArticle(article);
        return commentRepository.save(comment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public void updateCommentInfo(Comment comment) {
        User user = userRepository.findById(comment.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + comment.getUserId()));
        Article article = articleRepository.findById(comment.getArticleId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + comment.getArticleId()));
        comment.setUser(user);
        comment.setArticle(article);
        commentRepository.save(comment);
    }

}