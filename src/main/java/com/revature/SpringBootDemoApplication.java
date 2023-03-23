package com.revature;

import com.revature.entity.AppUser;
import com.revature.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner {

    @Autowired
    AppUserRepository appUserRepository;
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        AppUser user = new AppUser(1, "council", "password", "COUNCIL");
        appUserRepository.save(user);
    }
}
