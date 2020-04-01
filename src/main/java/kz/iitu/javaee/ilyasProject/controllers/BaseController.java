package kz.iitu.javaee.ilyasProject.controllers;

import kz.iitu.javaee.ilyasProject.entities.Users;
import kz.iitu.javaee.ilyasProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class BaseController {

    @Autowired
    private UserRepository userRepository;

    public Users getUserData(){
        Users userData = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            User secUser = (User)authentication.getPrincipal();
            userData = userRepository.findByDeletedAtNullAndEmail(secUser.getUsername());
        }
        return userData;
    }
}
