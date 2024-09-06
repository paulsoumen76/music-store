package com.example.music_album.controller;

import com.example.music_album.entity.dto.UserDTO;
import com.example.music_album.security.AuthenticationRequest;
import com.example.music_album.security.JwtBlacklistService;
import com.example.music_album.service.MyUserDetailsService;
import com.example.music_album.service.UserService;
import com.example.music_album.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtBlacklistService jwtBlacklistService;
    @Autowired
    private UserService userService;

    @PostMapping()
    public String createUser(@RequestBody final UserDTO userDTO){
        return userService.postUser(userDTO);
    }

    @PostMapping("/login")
    public String createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            // Authenticate the user
            if(!userService.isValid(authenticationRequest.getUserName(), authenticationRequest.getPassword())){
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());

        return jwtUtil.generateToken(userDetails);
    }

    @PostMapping("/logout")
    public String  removeAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletRequest request) throws Exception {
        final String jwt = jwtUtil.extractToken(request);
        jwtBlacklistService.addToBlacklist(jwt);
        return "logout successfully";
    }
}
