package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public boolean deleteUser(int id) {
        userRepository.delete(userRepository.findById(id).get());
        return true;
    }

    @Override
    public User updateUser(User user) {
        int id = user.getId();
        User userToUpdate = userRepository.findById(id).get();
//        userToUpdate.setFirstName(user.getFirstName());
//        userToUpdate.setLastName(user.getLastName());
//        userToUpdate.setAge(user.getAge());
        if(userRepository.existsById(id)) {
            userToUpdate = userRepository.save(user);
            return userToUpdate;
        }
        else
            return null;
    }
}
