package com.springboot.application.User;

import java.util.NoSuchElementException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class UserCommandLine {

    @Bean
    CommandLineRunner runner(UserRepository repository){
        return args -> {
            UserApplication user = new UserApplication();
            user.setName("Gaius");
            
            repository.save(user);
            UserApplication saved = repository.findById(user.getId()).orElseThrow(NoSuchElementException::new);
        };
    }
}
