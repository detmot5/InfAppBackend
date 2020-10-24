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

        //Dodawanie użytkownioka w przyszlosci w controllerze
        User user = new User();
        user.setName("Konrad");
        user.setEmail("konrad@gmail.com");

        Corona corona = new Corona();
        corona.setLink1("1");
        corona.setLink2("2");
        corona.setLink3("3");
        corona.setLink4("4");

        user.setCorona(corona);
        corona.setUser(user);

        userRepository.save(user);

    }
}
