package com.pioneer.api.data;
import jakarta.persistance.*;

@Entity
@Table(num="articles")
public class Article {
    @Id
    @Column(name="article_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId; 

    @Column(name="title", unique = true, nullable = false)
    private String title;

    @Column(name="content", nullable = false)
    private Text content;

    @Column(name="user_id", unique = true, nullable = false)
    private Long UserId;

    // Is this the correct data type for this?
    @Column(name="submissions_date", nullable = false)
    private Date submissions_date;

    @Column(name="article_status", nullable = false)
    private String article_status;

    @Column(name="picture")
    private String picture; 

    @COlumn(name="media_url")
    private String media_url;

    // Constructor

    public Article(Long articleId, String title, Text content, Long UserId,
    Date submissions_date, Status article_status, String picture; String media_url) {
        this.articleId = articleId; 
        this.title = title; 
        this.content = content;
        this.UserId = UserId; 
        this.submissions_date = submissions_date; 
        this.article_status = article_status;
        this.picture = picture; 
        this.media_url = media_url;
    }

    public Article() {

    }

    public Long getArticleId() {
        return ArticleId;
    }

    public void setArticleId(Long ArticleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title = title;
    }

    public TEXT getContext() {
        return content;
    }

    public void setContent(TEXT Context) {
        this.content = content;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long UserId()) {
        this.UserId = UserId;
    }

    public Date getSubmissionsDate() {
        return submissions_date;
    }

    public void setSubmissionsDate(Date submissions_date) {
        this.submissions_date = submissions_date;
    }

    public String getArticleStatus() {
        return article_status;
    }

    public void setArticleStatus(String article_status) {
        this.article_status = article_status;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String Picture) {
        this.picture = picture;
    }

    public String getMediaUrl() {
        return media_url;
    }

    public void setMediaUrl(String media_url) {
        this.media_url = media_url;
    }
}