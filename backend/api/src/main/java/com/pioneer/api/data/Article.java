package com.pioneer.api.data;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id", unique = true, nullable = false)
    private Long articleId;

    @Column(name="title", unique = true, nullable = false)
    private String title;

    @Column(name="content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @Column(name="submission_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date submissionDate;

    @Column(name="article_status", nullable = false)
    private String articleStatus;

    @Column(name="picture")
    private String picture;

    @Column(name="media_url")
    private String mediaUrl;

    @Column(name="category", nullable = false)
    private String category;

    @Transient
    private Long userId;

    public Article(Long articleId, String title, String content, User user, Date submissionDate, String articleStatus, String picture, String mediaUrl, String category) {
        this.articleId = articleId;
        this.title = title;
        this.content = content;
        this.user = user;
        this.submissionDate = submissionDate;
        this.articleStatus = articleStatus;
        this.picture = picture;
        this.mediaUrl = mediaUrl;
        this.category = category;
    }

    public Article() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
