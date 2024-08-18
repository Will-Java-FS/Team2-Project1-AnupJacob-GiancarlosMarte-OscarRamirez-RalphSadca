package com.revature.Auth;

//import com.revature.Auth.AuthenticationRequest;
//import com.revature.Auth.AuthenticationResponse;
//import com.revature.Services.AuthenticationService;
//import com.revature.Auth.RegisterRequest;
import com.revature.Models.User;
import com.revature.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
//@RequiredArgsConstructor
public class AuthController {

//    private final AuthenticationService service;
//
//    @PostMapping("/register")
//    public ResponseEntity<AuthenticationResponse> register(
//            @RequestBody RegisterRequest request
//    ) {
//        return ResponseEntity.ok(service.register(request));
//    }
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<AuthenticationResponse> authenticate(
//            @RequestBody AuthenticationRequest request
//    ) {
//        return ResponseEntity.ok(service.authenticate(request));
//    }

    private final UserService us;

    @Autowired
    public AuthController(UserService userService) {
        this.us = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User newUser) {
        User user = us.findByUsername(newUser.getUsername());
        if (user != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        user = us.addUser(newUser);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User currUser) {
        User user = us.findByUsernameAndPassword(currUser.getUsername(), currUser.getPassword());
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(currUser);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
