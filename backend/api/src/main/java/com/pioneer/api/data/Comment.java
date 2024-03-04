package com.pioneer.api.data;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", unique = true, nullable = false)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name="article_id", nullable = false)
    private Article article;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @Column(name="comment_text", nullable = false)
    private String commentText;

    @Column(name="comment_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDate;

    @Column(name="parent_comment_id")
    private Long parentCommentId;

    @Transient
    private Long userId;

    @Transient
    private Long articleId;


    public Comment(Long commentId, Article article, User user, String commentText, Date commentDate, Long parentCommentId) {
        this.commentId = commentId;
        this.article = article;
        this.user = user;
        this.commentText = commentText;
        this.commentDate = commentDate;
        this.parentCommentId = parentCommentId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Comment() {

    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }
}
