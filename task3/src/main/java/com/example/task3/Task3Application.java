package com.example.task3;

import com.example.task3.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Task3Application {

    public static void main(String[] args) {
        SpringApplication.run(Task3Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserService userService) {
        return args -> userService.runDemo();
    }
}