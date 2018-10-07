package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);

    public List<User> getAllUsers();

    public User getUser(int id);

    public boolean deleteUser(int id);

    public User updateUser(User user);
}
