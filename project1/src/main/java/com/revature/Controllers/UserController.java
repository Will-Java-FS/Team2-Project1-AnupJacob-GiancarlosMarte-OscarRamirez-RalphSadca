package com.revature.Controllers;


import com.revature.Models.Role;
import com.revature.Models.User;
import com.revature.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("users")
public class UserController {

    UserService us;

    @Autowired
    public UserController(UserService us) {
        this.us = us;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(User user) {
        if (user.getRole() == Role.USER) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(us.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User found = us.findById(id);
        if (found != null) {
            return ResponseEntity.status(HttpStatus.OK).body(found);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User found = us.findById(user.getUser_id());
        if (found != null) {
            found = us.updateUser(found);
            return ResponseEntity.status(HttpStatus.OK).body(found);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<User> deleteUserById(@PathVariable int id) {
//        us.deleteById(id);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User found = us.findByUsername(username);
        if (found != null) {
            return ResponseEntity.status(HttpStatus.OK).body(found);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


     @PutMapping("/register")
      public ResponseEntity<User> postOrder(@RequestBody User user){
        User savedUser = us.addUser(user);
        return savedUser==null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) : new ResponseEntity<>(savedUser, HttpStatus.OK); }

//    @DeleteMapping("user/{user_id}")
//    public ResponseEntity<Order> deleteUserById(@PathVariable int user_id){
//        us.removeUserById(user_id);
//        return new ResponseEntity<>(null, HttpStatus.OK);
//    }
//
//    // Probably not going to use because not secure
//    @GetMapping("user/{email}/{password}")
//    public ResponseEntity<User> getUserByEmailAndPassword(@PathVariable String email, @PathVariable String password){
//        User retrievedUser =  us.findUserByEmailAndPassword(email, password);
//        return retrievedUser==null ? new ResponseEntity<>(null, HttpStatus.BAD_REQUEST) : new ResponseEntity<>(retrievedUser, HttpStatus.OK);
//    }
}
