package com.revature.service.appUser;

import com.revature.entity.AppUser;

public interface AppUserService {
    AppUser verifyUser(String username, String password);
}
