package com.revature.controller;

import com.revature.entity.AppUser;
import com.revature.service.appUser.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:3000")
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    Logger logger1 = LoggerFactory.getLogger(AppUserController.class);

    @PatchMapping
    public ResponseEntity<AppUser> getUser(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        AppUser user = appUserService.verifyUser(username, password);
        if (user == null) {
            logger1.info("User sign in failed");
            return ResponseEntity.notFound().build();
        }
        logger1.info("User sign in success");
        return ResponseEntity.ok(user);
    }
}

