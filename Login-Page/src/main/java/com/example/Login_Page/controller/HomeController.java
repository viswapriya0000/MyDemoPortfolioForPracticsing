package com.example.Login_Page.controller;

import com.example.Login_Page.entity.Users;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/welcome")
    public String message(HttpServletRequest request){
        return "Welcome to login page of the application "+request.getSession().getId();
    }

    @PostMapping("/welcome")
    public Users getUser(@RequestBody Users user){
        return user;
    }

    @GetMapping("/csrf-token")
    public CsrfToken csrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }


}
