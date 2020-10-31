package com.InfApp.InfApp.entity;


import com.InfApp.InfApp.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserService {


    @Autowired
    UserRepository userRepository;


    @Autowired
    ObjectMapper objectMapper;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody User user)
    {
        Corona corona = new Corona();
        user.setCorona(corona);
        User savedUser =userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }
}
