package com.projects.ticket.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.ticket.booking.dto.AuthRequest;
import com.projects.ticket.booking.dto.AuthResponse;
import com.projects.ticket.booking.model.User;
import com.projects.ticket.booking.repository.UserRepository;
import com.projects.ticket.booking.util.JwtUtil;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private ReactiveAuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public Mono<ResponseEntity<AuthResponse>> login(@RequestBody AuthRequest request) {
        return authManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()))
                .map(authentication -> {
                    String token = jwtUtil.generateToken(authentication);
                    return ResponseEntity.ok(new AuthResponse(token));
                });
    }

    @PostMapping("/register")
    public Mono<ResponseEntity<String>> register(@RequestBody AuthRequest request) {
        return userRepository.existsByUsername(request.getUsername())
            .flatMap(exists -> {
                if (Boolean.TRUE.equals(exists)) {
                    return Mono.just(ResponseEntity.badRequest().body("Username already exists."));
                }

                User user = User.builder()
                        .username(request.getUsername())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .roles(List.of("USER")) // default role
                        .build();

                return userRepository.save(user)
                        .thenReturn(ResponseEntity.ok("User registered successfully."));
            });
    }
}

