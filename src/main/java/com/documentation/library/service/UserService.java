package com.documentation.library.service;

import com.documentation.library.domain.User;
import com.documentation.library.dto.UserDto;
import com.documentation.library.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDto userDto) {
        try {
            User user = new User(userDto);
            logger.info("User successfully registered");
            return userRepository.save(user);
        } catch (Exception e) {
            logger.error("Error creating user: " + e.getMessage());
            throw new RuntimeException("Error creating user", e);
        }
    }
}
