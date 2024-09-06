package com.example.music_album.service;

import com.example.music_album.entity.MusicAlbum;
import com.example.music_album.entity.dto.MusicAlbumResponse;
import com.example.music_album.repository.MusicAlbumRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MusicAlbumServiceTest {

    @Mock
    MusicAlbumRepository musicAlbumRepository;

    @InjectMocks
    MusicAlbumService musicAlbumService;


    @Test
    public void dotest(){
        assertThrows( Exception.class, ()->musicAlbumService.getAllMusicAlbum());
        MusicAlbum musicAlbum = new MusicAlbum();
        musicAlbum.setId("abc");
        ArrayList<MusicAlbum> list = new ArrayList<>();
        list.add(musicAlbum);
        Mockito.when(musicAlbumRepository.findAll()).thenReturn(list);

        MusicAlbumResponse allMusicAlbum = musicAlbumService.getAllMusicAlbum();

    }
}