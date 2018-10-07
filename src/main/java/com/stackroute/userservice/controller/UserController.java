package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class UserController {

    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        ResponseEntity responseEntity;
        try{
            userService.saveUser(user);
            responseEntity = new ResponseEntity<String>("Succesfully created", HttpStatus.CREATED);
        } catch(Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("user")
    public ResponseEntity<?> getAllUser(){
         return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<?> getUserId(@PathVariable int id){
        return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        return new ResponseEntity<Boolean>(userService.deleteUser(id), HttpStatus.OK);
    }

    @PutMapping("user")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.OK);
    }
}
