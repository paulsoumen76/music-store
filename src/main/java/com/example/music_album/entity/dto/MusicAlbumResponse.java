package com.example.music_album.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class MusicAlbumResponse {
    List<MusicAlbumDTO> musicAlbums;
}
