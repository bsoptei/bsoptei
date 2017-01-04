package com.greenfox.service;

import com.greenfox.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greenfox.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void addUser(String userName) {
        userRepo.save(new User(userName));
    }

    public User findByName(String userName) {
        return userRepo.findByUserName(userName);
    }
}
