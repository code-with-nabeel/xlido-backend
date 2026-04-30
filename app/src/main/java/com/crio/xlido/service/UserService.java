package com.crio.xlido.service;

import com.crio.xlido.model.User;
import com.crio.xlido.repository.UserRepository;

public class UserService {
    private UserRepository repo;
    private int counter = 1;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public int createUser(String email, String password) {
        User user = new User(counter++, email, password);
        repo.save(user);
    
        System.out.println("User ID: " + user.getId());
    
        return user.getId();   
    }

    public User getUser(int id) {
        return repo.findById(id);
    }
}