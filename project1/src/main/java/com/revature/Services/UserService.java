package com.revature.Services;


import com.revature.Models.Cart;
import com.revature.Models.User;
import com.revature.Repositories.CartRepo;
import com.revature.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    UserRepo ur;
    CartRepo cr;

    @Autowired
    public UserService(UserRepo ur, CartRepo cr) {
        this.ur = ur;
        this.cr = cr;
    }

    public List<User> findAll() {
        return ur.findAll();
    }

    public User findById(int user_id) {
        return ur.findById(user_id).orElse(null);
    }

    public User findByUsername(String username) {
        return ur.findByUsername(username).orElse(null);
    }

    public User findByEmail(String email) {
        return ur.findByEmail(email).orElse(null);
    }

    public User findByUsernameAndPassword(String username, String password) {
        return ur.findByUsernameAndPassword(username, password).orElse(null);
    }

    public User addUser(User user) {
        if (ur.findById(user.getUser_id()).isPresent()) {
            return null;
        }
        User userToAdd = ur.save(user);
        Cart cart = cr.save(userToAdd.getCart());
        userToAdd.setCart(cart);
        return userToAdd;
    }

    public User updateUser(User user) {
        return ur.findById(user.getUser_id()).isPresent()
                ? ur.save(user)
                : null;
    }


    public User findUserByEmailAndPassword(String email, String password) {
        return ur.findByEmailAndPassword(email, password).orElse(null);
    }

    public void deleteById(int userId) {
        User user = ur.findById(userId).orElse(null);
        if (user != null) {
            cr.deleteById(user.getCart().getCart_id());
            ur.deleteById(userId);
        }
    }



//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = ur.findByUsername(username);
//
//        if (user.isEmpty() || !user.get().isEnabled()) {
//            throw new UsernameNotFoundException(username + " not found");
//        }
//
//        return user.get();
//    }
}
