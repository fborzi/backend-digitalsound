package com.digitalsound.paginaweb.security.services;

import com.digitalsound.paginaweb.security.models.AppUser;
import com.digitalsound.paginaweb.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<AppUser> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

//    public boolean existsByEmail(String email) {
//        return userRepository.existsByEmail(email);
//    }

    public void save(AppUser appUser) {
        userRepository.save(appUser);
    }

    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }
}
