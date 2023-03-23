package com.revature.service;

import com.revature.dto.LoginRequest;
import com.revature.entity.AppUser;
import com.revature.exceptions.InvalidLoginInfoException;
import com.revature.repository.AppUserRepository;
import com.revature.service.appUser.AppUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class AppUserServiceTest {

    @MockBean(AppUserRepository.class)
    AppUserRepository appUserRepository;

    @Autowired
    AppUserService appUserService;

    @Test
    public void testVerifyUser() throws InvalidLoginInfoException {
        AppUser appUser = new AppUser(1, "councilUsername", "councilPassword", "COUNCIL");
        LoginRequest loginRequest = new LoginRequest("councilUsername", "councilPassword");
        Mockito.when(appUserRepository.getByUsername(loginRequest.getUsername())).thenReturn(appUser);
        AppUser result = appUserService.verifyUser(loginRequest);
        Assertions.assertEquals(appUser.getPassword(), result.getPassword());
    }
}
