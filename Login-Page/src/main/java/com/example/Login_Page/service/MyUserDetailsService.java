package com.example.Login_Page.service;

import com.example.Login_Page.entity.UserPrincipal;
import com.example.Login_Page.entity.Users;
import com.example.Login_Page.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users user=userRepo.findByUsername(username);
       if(user==null){
           System.out.println("user not found");
           throw new UsernameNotFoundException("User not found");
       }

       return new UserPrincipal(user);
    }
}
