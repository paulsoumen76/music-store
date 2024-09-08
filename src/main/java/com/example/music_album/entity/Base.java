package com.example.music_album.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Base {
    private Long id;
    private String albumTitle;
    private String username;
    private String email;

    public Base(Long id, String username, String albumTitle){
        this.id = id;
        this.username = username;
        this.albumTitle = albumTitle;
    }
}
