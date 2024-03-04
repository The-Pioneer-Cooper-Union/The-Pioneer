package com.pioneer.api.webservice;

import com.pioneer.api.business.CommentService;
import com.pioneer.api.data.Comment;
import com.pioneer.api.data.Donation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/create-comment")
    public ResponseEntity<String> createComment(@RequestBody Comment comment) {
        try {
            Comment newComment = commentService.addComment(comment);
            return ResponseEntity.status(HttpStatus.CREATED).body("Comment created successfully. Comment ID: " + newComment.getCommentId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating comment: " + e.getMessage());
        }
    }

    @GetMapping("/article-comments/{articleId}")
    public ResponseEntity<List<Comment>> getCommentsByArticleId(@PathVariable Long articleId) {
        try {
            List<Comment> comment = commentService.findByArticleArticleId(articleId);
            return ResponseEntity.status(HttpStatus.OK).body(comment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/delete-comment/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId) {
        try {
            commentService.deleteComment(commentId);
            return ResponseEntity.status(HttpStatus.OK).body("Comment deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error deleting comment: " + e.getMessage());
        }
    }

    @PutMapping("/update-comment/{commentId}")
    public ResponseEntity<String> updateComment(@PathVariable Long commentId, @RequestBody Comment comment) {
        try {
            // Set the userId of the user object to ensure it updates the existing user
            comment.setCommentId(commentId);
            commentService.updateCommentInfo(comment);
            return ResponseEntity.status(HttpStatus.OK).body("Comment Info updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating Comment Info: " + e.getMessage());
        }
    }

}
