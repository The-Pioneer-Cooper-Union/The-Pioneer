package com.pioneer.api.business;

import com.pioneer.api.data.User;
import com.pioneer.api.data.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }

    public void updateUserInfo(User user) {
        userRepository.save(user);
    }
    public Optional<User> findUserByUserId(Long userId) {
        return userRepository.findUserByUserId(userId);
    }
}
