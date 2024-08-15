package com.revature.Controllers;

import com.revature.Models.Order;
import com.revature.Models.Product;
import com.revature.Models.User;
import com.revature.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    UserService us;
    @Autowired
    public UserController(UserService us) {
        this.us = us;
    }
    @PutMapping("user")
    public ResponseEntity<User> postOrder(@RequestBody User user){
        User savedUser = us.addUser(user);
        return savedUser==null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) : new ResponseEntity<>(savedUser, HttpStatus.OK);
    }
    @DeleteMapping("user/{user_id}")
    public ResponseEntity<Order> deleteUserById(@PathVariable int user_id){
        us.removeUserById(user_id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    // Probably not going to use because not secure
    @GetMapping("user/{email}/{password}")
    public ResponseEntity<User> getUserByEmailAndPassword(@PathVariable String email, @PathVariable String password){
        User retrievedUser =  us.findUserByEmailAndPassword(email, password);
        return retrievedUser==null ? new ResponseEntity<>(null, HttpStatus.BAD_REQUEST) : new ResponseEntity<>(retrievedUser, HttpStatus.OK);
    }
}
