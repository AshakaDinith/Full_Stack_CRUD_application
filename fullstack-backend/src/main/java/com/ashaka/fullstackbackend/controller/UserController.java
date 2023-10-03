package com.ashaka.fullstackbackend.controller;


import com.ashaka.fullstackbackend.exception.UserNotFoundException;
import com.ashaka.fullstackbackend.model.User;
import com.ashaka.fullstackbackend.repositary.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepositary userRepositary;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepositary.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepositary.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        return userRepositary.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long id){
        return userRepositary.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setUsername(newUser.getUsername());
                    user.setEmail(newUser.getEmail());
                    return userRepositary.save(user);

                }).orElseThrow(()->new UserNotFoundException(id));
    }


    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepositary.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepositary.deleteById(id);
        return "User with id "+id+" has been deleted success.";
    }

}

