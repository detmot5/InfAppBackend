package com.InfApp.InfApp;

import com.InfApp.InfApp.entity.Corona;
import com.InfApp.InfApp.entity.User;
import com.InfApp.InfApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InfAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(InfAppApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

    }
}
