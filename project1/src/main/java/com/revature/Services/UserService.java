//package com.revature.Services;
//
//
//import com.revature.Models.User;
//import com.revature.Repositories.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//    UserRepo ur;
//    @Autowired
//    public UserService(UserRepo ur) {
//        this.ur = ur;
//    }
//    public User addUser(User user) {
//        return ur.save(user);
//    }
//    public void removeUserById(int userId) {
//        User user = ur.findById(userId).get();
//        ur.delete(user);
//    }
//    public User findUserByEmailAndPassword(String email, String password) {
//        return ur.findByEmailAndPassword(email, password).get();
//    }
//}
