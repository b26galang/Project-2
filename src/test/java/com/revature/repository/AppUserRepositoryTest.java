package com.revature.repository;

import com.revature.entity.AppUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
public class AppUserRepositoryTest {

    @Autowired
    AppUserRepository appUserRepository;

    @Test
    public void testGetByUsername() {
        AppUser appUser = new AppUser(1, "councilUsername", "councilPassword", "COUNCIL");
        appUserRepository.save(appUser);
        AppUser retrievedUser = appUserRepository.getByUsername("councilUsername");
        Assertions.assertEquals(appUser.getUsername(), retrievedUser.getUsername());
    }
}
