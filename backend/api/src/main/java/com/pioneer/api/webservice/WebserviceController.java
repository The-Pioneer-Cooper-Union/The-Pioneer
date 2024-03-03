package com.pioneer.api.webservice;

import com.pioneer.api.business.UserService;
import com.pioneer.api.data.User;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class WebserviceController {

    private final UserService userService;

    @Autowired
    public WebserviceController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            User newUser = userService.addUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully. User ID: " + newUser.getUserId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating user: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete-user/{userId}")
    public ResponseEntity<String> removeUser(@PathVariable Long userId) {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error deleting User: " + e.getMessage());
        }
    }

    @PutMapping("/update-user/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody User user) {
        try {
            // Set the userId of the user object to ensure it updates the existing user
            user.setUserId(userId);
            userService.updateUserInfo(user);
            return ResponseEntity.status(HttpStatus.OK).body("User Info updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating User Info: " + e.getMessage());
        }
    }

    @GetMapping("/user-info/{userId}")
    public ResponseEntity<User> getUserInfo(@PathVariable Long userId) {
        try {
            Optional<User> user = userService.findUserByUserId(userId);

            return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
