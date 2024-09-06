package com.example.music_album.entity.dto;

import lombok.Data;

@Data
public class MusicAlbumDTO {
    private String id;
    private String title;
    private String singerName;
    private String writtenBy;
    private int duration;
    private int size;
}
