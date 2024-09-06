package com.example.music_album.entity.dto;

import com.example.music_album.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private String id;
    private String userName;
    private String password;
    private String email;
    //TODO: Implemeti list of role
    private Role role;
    public UserDTO(String userName, String password, String email){
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
}
