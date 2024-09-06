package com.example.music_album.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user from database or any other source
        Optional<com.example.music_album.entity.User> optionalUser = userService.getUser(username);
        if(optionalUser.isPresent()){
            com.example.music_album.entity.User user = optionalUser.get();
            GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().toString());
            return new User(user.getUserName(), user.getPassword(), List.of(authority));
        }
        throw new UsernameNotFoundException("user not found");
    }
}
