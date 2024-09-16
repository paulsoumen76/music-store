package com.example.music_album.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@MappedSuperclass
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String albumTitle;
    private String username;
    private String email;

    public Base(String id, String username, String albumTitle){
        this.id = id;
        this.username = username;
        this.albumTitle = albumTitle;
    }
}
