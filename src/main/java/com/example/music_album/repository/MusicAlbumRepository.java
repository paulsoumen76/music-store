package com.example.music_album.repository;

import com.example.music_album.entity.MusicAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MusicAlbumRepository extends JpaRepository<MusicAlbum, String> {

    Optional<MusicAlbum> findById(String id);
}
