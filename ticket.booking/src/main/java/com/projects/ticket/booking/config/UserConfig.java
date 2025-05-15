package com.projects.ticket.booking.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.projects.ticket.booking.model.User;
import com.projects.ticket.booking.repository.UserRepository;


@Configuration
public class UserConfig {


    @Bean
    public CommandLineRunner seedTestUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            userRepository.findByUsername("user")
                .switchIfEmpty(
                    userRepository.save(User.builder()
                        .username("user")
                        .password(passwordEncoder.encode("password"))
                        .roles(List.of("USER"))
                        .build())
                )
                .subscribe(user -> System.out.println("Test user ready: " + user.getUsername()));
        };
    }

}

