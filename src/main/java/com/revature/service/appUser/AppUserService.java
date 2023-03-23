package com.revature.service.appUser;

import com.revature.dto.LoginRequest;
import com.revature.entity.AppUser;
import com.revature.exceptions.IdDoesNotExistException;
import com.revature.exceptions.InvalidLoginInfoException;

public interface AppUserService {
    AppUser verifyUser(LoginRequest loginRequest) throws InvalidLoginInfoException;
    AppUser getByUsername(String username) throws IdDoesNotExistException;
}
