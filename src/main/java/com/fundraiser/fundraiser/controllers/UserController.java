package com.fundraiser.fundraiser.controllers;

import com.fundraiser.fundraiser.models.data.DonationRepository;
import com.fundraiser.fundraiser.models.data.UserRepository;
import com.fundraiser.fundraiser.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DonationRepository donationRepository;

    private static final String userSessionKey = "user";

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser;
        savedUser = userRepository.save(user);
        return ok(savedUser);
    }

//    @GetMapping("/{userId}")
//    public ResponseEntity<Optional<User>> getUserById(@PathVariable int userId) {
//        Optional<User> user = UserRepository.getUserById(userId);
//        if (user.isPresent()){
//            return ok(user);
//        }
//        return not found().build();
    }





