package com.pioneer.api.data;

import jakarta.persistence.*;

@Entity
@Table(name="comments")
public class Comment {
    @Id
    @Column(name="comment_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CommentId;

    @Column(name="article_id", nullable = false)
    private Long ArticleId;

    @Column(name="user_id", nullable = false)
    private Long UserId;

    @Column(name="comment_text", nullable = false)
    private String comment_text;

    @Column(name="comment_date", nullable = false)
    private Date comment_date;

    @Column(name="parent_comment_id")
    private Long ParentCommentId;

    // Constructor

    public Comment(Long CommentId, Long ArticleId, Long UserId, 
    String comment_text, Date comment_date, Long ParentCommentId) {
        this.CommentId = CommentId;
        this.ArticleId = ArticleId;
        this.UserId = UserId;
        this.comment_text = comment_text;
        this.comment_date = comment_date; 
        this.ParentCommentId = ParentCommentId; 
    }

    public Comment() {

    }

    public Long getCommentId() {
        return CommentId;
    }

    public void setCommentId(Long CommentId) {
        this.CommentId = CommentId;
    }

    public Long getArticleId() {
        return ArticleId;
    }

    public void setCommentId(Long ArticleId) {
        this.ArticleId = ArticleId;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long UserId) {
        this.UserId = UserId;
    }

    public String getCommentText() {
        return comment_text;
    }

    public void setCommentText(String comment_text) {
        this.comment_text = comment_text;
    }

    public Date getCommentDate() {
        return comment_date;
    }

    public void setCommentDate(Date comment_date) {
        this.comment_date = comment_date;
    }

    public Long getParentCommentId() {
        return ParentCommentId;
    }

    public void setParentCommentId(Long ParentCommentId) {
        this.ParentCommentId = ParentCommentId;
    }
}