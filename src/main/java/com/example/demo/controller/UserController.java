package com.example.demo.controller;

import com.example.demo.model.Adherent;
import com.example.demo.model.CustomUser;
import com.example.demo.model.Professeur;
import com.example.demo.repository.CustomUserRepository;
import com.example.demo.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private CustomUserRepository customUserRepository;
    private CustomUserDetailsService customUserDetailsService;
//    private ProfesseurController professeurController;
//    private AdherentController adherentController;

    @GetMapping("/user/{username}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public CustomUser getUserByUsername(@PathVariable String username) {
        CustomUser user = customUserRepository.findByUsername(username);
        return user;
    }
    @PostMapping("/user")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public CustomUser ajouterUser(@RequestBody CustomUser user) {
        return customUserRepository.save(user);
    }

}
