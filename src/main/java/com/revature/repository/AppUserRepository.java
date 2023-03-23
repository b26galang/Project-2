package com.revature.repository;

import com.revature.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    @Query(value = "SELECT * FROM app_user WHERE username = :username", nativeQuery = true)
    AppUser getByUsername(@Param("username") String username);
}

