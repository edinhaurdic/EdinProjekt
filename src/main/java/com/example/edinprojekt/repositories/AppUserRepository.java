package com.example.edinprojekt.repositories;

import com.example.edinprojekt.enitites.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    Optional<AppUser> findAppUserByUsername (String username);
}
