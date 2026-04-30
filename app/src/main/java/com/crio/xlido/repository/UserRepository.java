package com.crio.xlido.repository;

import com.crio.xlido.model.User;
import java.util.*;

public class UserRepository {
    private Map<Integer, User> users = new HashMap<>();

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public User findById(int id) {
        return users.get(id);
    }
}