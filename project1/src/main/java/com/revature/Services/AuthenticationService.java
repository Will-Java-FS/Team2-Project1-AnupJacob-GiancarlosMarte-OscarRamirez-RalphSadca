//package com.revature.Services;
//
//import com.revature.Auth.AuthenticationRequest;
//import com.revature.Auth.AuthenticationResponse;
//import com.revature.Auth.RegisterRequest;
//import com.revature.Models.Role;
//import com.revature.Models.User;
//import com.revature.Repositories.UserRepo;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//
//@Service
//@RequiredArgsConstructor
//public class AuthenticationService {
//
//    private final UserRepo repository;
//    private final PasswordEncoder passwordEncoder;
//    private final JwtService jwtService;
//    private final AuthenticationManager authenticationManager;
//
//    public AuthenticationResponse register(RegisterRequest request) {
//        var user = User.builder()
//                .username(request.getUsername())
//                .email(request.getEmail())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .firstName(request.getFirstname())
//                .lastName(request.getLastname())
//                .address(request.getAddress())
//                .role(Role.USER)
//                .created_at(LocalDateTime.now())
//                .updated_at(LocalDateTime.now())
//                .build();
//        repository.save(user);
//        var jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();
//    }
//
//    public AuthenticationResponse authenticate(AuthenticationRequest request) {
//        authenticationManager.authenticate(
//            new UsernamePasswordAuthenticationToken(
//                request.getEmail(),
//                request.getPassword()
//            )
//        );
//        var user = repository.findByEmail(request.getEmail())
//                .orElseThrow();
//        var jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();
//    }
//
//}
