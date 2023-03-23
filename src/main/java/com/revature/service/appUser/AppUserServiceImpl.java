package com.revature.service.appUser;

import com.revature.dto.LoginRequest;
import com.revature.entity.AppUser;
import com.revature.exceptions.InvalidLoginInfoException;
import com.revature.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class AppUserServiceImpl implements AppUserService{

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public AppUser getByUsername(String username) {
        return appUserRepository.getByUsername(username);
    }

    @Override
    public AppUser verifyUser(LoginRequest loginRequest) {
        AppUser appUser = appUserRepository.getByUsername(loginRequest.getUsername());
        if (appUser != null && appUser.getPassword().equals(loginRequest.getPassword())) {
            return appUser;
        } else {
            return null;
        }
    }

}

