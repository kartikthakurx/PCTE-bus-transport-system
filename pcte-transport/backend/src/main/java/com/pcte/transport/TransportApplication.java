package com.pcte.transport;

import com.pcte.transport.entity.User;
import com.pcte.transport.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransportApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransportApplication.class, args);
    }

    // Seed an admin user on first run (only if not present)
    @Bean
    CommandLineRunner initUsers(UserRepo userRepo){
        return args -> {
            userRepo.findByEmail("admin@pcte.edu.in").orElseGet(() -> {
                User admin = new User(null, "Admin", "admin@pcte.edu.in", "admin123", "ADMIN");
                return userRepo.save(admin);
            });
        };
    }
}
