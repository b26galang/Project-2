package com.revature.service.appUser;

import com.revature.entity.AppUser;
import com.revature.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class AppUserServiceImpl implements AppUserService{

    @Autowired
    AppUserRepository appUserRepository;

    public AppUser verifyUser(String username, String password) {
        // Retrieve the user with the given username from the database
        AppUser user = appUserRepository.findByUsername(username);

        // Check if the user exists and if the password matches
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }
}

