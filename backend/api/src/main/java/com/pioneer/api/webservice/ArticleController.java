package com.pioneer.api.webservice;

import com.pioneer.api.business.ArticleService;
import com.pioneer.api.business.CommentService;
import com.pioneer.api.data.Article;
import com.pioneer.api.data.Donation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;
    private final CommentService commentService;

    @Autowired
    public ArticleController(ArticleService articleService, CommentService commentService) {
        this.articleService = articleService;
        this.commentService = commentService;
    }


    @GetMapping("/search")
    public ResponseEntity<List<Article>> searchArticles(@RequestParam String title) {
        List<Article> articles = articleService.searchArticlesByTitle(title);
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<Article>> getArticlesByUsername(@PathVariable String username) {
        List<Article> articles = articleService.findArticlesByUsername(username);
        return ResponseEntity.ok(articles);
    }

    @PostMapping("/create-article")
    public ResponseEntity<String> createArticle(@RequestBody Article article) {
        try {
            Article newArticle = articleService.addArticle(article);
            return ResponseEntity.status(HttpStatus.CREATED).body("Article made successfully. Article ID: " + newArticle.getArticleId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error making Article: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete-article/{articleId}")
    public ResponseEntity<String> removeArticle(@PathVariable Long articleId) {
        try {
            articleService.deleteArticle(articleId);
            return ResponseEntity.status(HttpStatus.OK).body("Article deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error deleting Article: " + e.getMessage());
        }
    }

    @PutMapping("/update-article/{articleId}")
    public ResponseEntity<String> updateArticle(@PathVariable Long articleId, @RequestBody Article article) {
        try {
            // Set the userId of the user object to ensure it updates the existing user
            article.setArticleId(articleId);
            articleService.updateArticleInfo(article);
            return ResponseEntity.status(HttpStatus.OK).body("Article Info updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating Article Info: " + e.getMessage());
        }
    }

    @GetMapping("/article-info/{articleId}")
    public ResponseEntity<Article> getArticleInfo(@PathVariable Long articleId) {
        try {
            Optional<Article> article = articleService.findArticleByArticleId(articleId);

            return article.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{articleId}/comment-count")
    public ResponseEntity<Long> getCommentCountByArticleId(@PathVariable Long articleId) {
        Long commentCount = commentService.countCommentsByArticleId(articleId);
        return ResponseEntity.ok(commentCount);
    }

}
