package com.revature.Auth;

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

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService us;
//    private final AuthenticationService authService;



//
//    @PostMapping("/register")
//   public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
//      return ResponseEntity.ok(authService.register(request));
//   }
////
//    @PostMapping("/login")
//    public ResponseEntity<AuthenticationResponse> loginUser(@RequestBody AuthenticationRequest request) {
//        AuthenticationResponse ar = authService.authenticate(request);
//        if (ar != null) {
//            return ResponseEntity.status(HttpStatus.OK).build();
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    }

//
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
        User user = us.findUserByEmailAndPassword(currUser.getEmail(), currUser.getPassword());
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(currUser);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
