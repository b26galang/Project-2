package com.revature.controller;

import com.revature.dto.LoginRequest;
import com.revature.entity.AppUser;
import com.revature.exceptions.InvalidLoginInfoException;
import com.revature.service.appUser.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    Logger logger1 = LoggerFactory.getLogger(AppUserController.class);

    @RequestMapping(method = RequestMethod.PATCH)
    public ResponseEntity<AppUser> getUser(@RequestBody LoginRequest loginRequest) throws InvalidLoginInfoException {
        logger1.info("User sign in success");
        return new ResponseEntity<>(appUserService.verifyUser(loginRequest), HttpStatus.OK);
    }
}

