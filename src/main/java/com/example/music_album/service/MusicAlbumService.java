package com.example.music_album.service;

import com.example.music_album.entity.MusicAlbum;
import com.example.music_album.entity.dto.MusicAlbumDTO;
import com.example.music_album.entity.dto.MusicAlbumResponse;
import com.example.music_album.repository.MusicAlbumRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MusicAlbumService {
    private static final Logger log = LoggerFactory.getLogger(MusicAlbumService.class);
    @Autowired
    private  MusicAlbumRepository musicAlbumRepository;

    public void postMusicAlbum(MusicAlbumDTO musicAlbumDTO){
        MusicAlbum musicAlbum = new MusicAlbum();
        BeanUtils.copyProperties(musicAlbumDTO, musicAlbum);
        musicAlbumRepository.save(musicAlbum);
    }

    public MusicAlbumResponse getAllMusicAlbum(){
        List<MusicAlbum> musicAlbums =  musicAlbumRepository.findAll();
        if (musicAlbums.isEmpty()){
            throw new RuntimeException();
        }
        MusicAlbumResponse musicAlbumResponse = new MusicAlbumResponse();
        List<MusicAlbumDTO> musicAlbumDTOS = new ArrayList<>();
        for(MusicAlbum musicAlbum : musicAlbums){
            MusicAlbumDTO musicAlbumDTO = new MusicAlbumDTO();
            BeanUtils.copyProperties(musicAlbum, musicAlbumDTO);
            musicAlbumDTOS.add(musicAlbumDTO);
        }
        musicAlbumResponse.setMusicAlbums(musicAlbumDTOS);
        return musicAlbumResponse;
    }

    public void postBulkMusicAlbum(List<MusicAlbumDTO> musicAlbumDTOs){
        List<MusicAlbum> musicAlbums = new ArrayList<>();
        for(MusicAlbumDTO musicAlbumDTO : musicAlbumDTOs){
            MusicAlbum musicAlbum = new MusicAlbum();
            BeanUtils.copyProperties(musicAlbumDTO, musicAlbum);
            musicAlbums.add(musicAlbum);
        }
        try{
            musicAlbumRepository.saveAll(musicAlbums);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String qualityCheck(String id){
        Optional<MusicAlbum> musicAlbum = musicAlbumRepository.findById(id);
        if(musicAlbum.isPresent()){
           int size =  musicAlbum.get().getSize();
           if(size <= 5){
               return "low-quality";
           } else if (size <= 7) {
               return "good-quality";
           }
        }
        return "best-quality";
    }
}
