package com.example.music_album.service;

import com.example.music_album.entity.User;
import com.example.music_album.entity.dto.UserDTO;
import com.example.music_album.repository.UserRepository;
import com.example.music_album.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserRepository userRepository;
    public Optional<User> getUser(String userName){
        return userRepository.findByUserName(userName);
    }
    public String postUser(UserDTO userDTO){
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        userRepository.save(user);
        return "user created successfully";
    }

    public boolean isValid(String username, String password) {
        if(getUser(username).isPresent()){
            Optional<User> user1 = getUser(username);
            return getUser(username).get().getPassword().equals(password);
        }
        return false;
    }

    public User getUserByToken(HttpServletRequest request){
        String token = jwtUtil.getToken(request);
        if(!token.isEmpty()){
            String userName = jwtUtil.extractUsername(token);
            try{
                Optional<User> optionalUser = userRepository.findByUserName(userName);
                if(optionalUser.isPresent()){
                    return optionalUser.get();
                }
            }catch (Exception e){
                throw new UsernameNotFoundException("user not found by username: " + userName);
            }
        }
        throw new UsernameNotFoundException("invalid user");
    }
}
