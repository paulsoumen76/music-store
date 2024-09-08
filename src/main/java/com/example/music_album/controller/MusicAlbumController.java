package com.example.music_album.controller;

import com.example.music_album.service.OrderService;
import com.example.music_album.entity.Order;
import com.example.music_album.entity.dto.MusicAlbumDTO;
import com.example.music_album.entity.dto.MusicAlbumResponse;
import com.example.music_album.service.MusicAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/music")
public class MusicAlbumController {
    @Autowired
    private  MusicAlbumService musicAlbumService;
    @Autowired
    private OrderService orderService;
    @GetMapping()
    public MusicAlbumResponse getMusicAlbum(){
        return musicAlbumService.getAllMusicAlbum();
    }

    @PostMapping()
    public void createMusicAlbum(@RequestBody MusicAlbumDTO musicAlbumDTO){
         musicAlbumService.postMusicAlbum(musicAlbumDTO);
    }

    @PostMapping("/bulk")
    public void createBulkMusicAlbum(@RequestBody List<MusicAlbumDTO> musicAlbumDTOs){
        musicAlbumService.postBulkMusicAlbum(musicAlbumDTOs);
    }

    @PostMapping("/order")
    public void orderAlbum(@RequestBody final Order order){
        orderService.createOrder(order);
    }
}
