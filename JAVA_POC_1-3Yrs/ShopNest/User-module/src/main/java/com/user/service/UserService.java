package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.repository.UserRepository;

@Service
public class UserService {
	
	    private final UserRepository userRepository;

	    @Autowired
	    public UserService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    public User registerUser(User user) {
	        return userRepository.save(user);
	    }

	    public User loginUser(String username, String password) {
	        // Implemented authentication logic here.
	        User user = userRepository.findByUsername(username).orElse(null);
	        if (user != null && user.getPassword().equals(password)) {
	            user.setLoggedIn(true);
	            userRepository.save(user);
	            return user;
	        }
	        return user;
	    }
	    
	    public User logoutUser(Long userId) {
	        // Finding the user by ID and setting loggedIn to false
	        return userRepository.findById(userId).map(user -> {
	            user.setLoggedIn(false);
	            userRepository.save(user);
	            return user;
	        }).orElse(null);
	    }
	}


