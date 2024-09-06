package com.example.music_album;

import com.example.music_album.entity.MusicAlbum;
import com.example.music_album.repository.MusicAlbumRepository;
import com.example.music_album.service.MusicAlbumService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class MusicAlbumApplicationTests {
	@Autowired
	private MusicAlbumService musicAlbumService;
	@Mock
    private MusicAlbumRepository musicAlbumRepository;
	@Test
	void testQuality_musicAlbumService_valid() {
		MusicAlbum musicAlbum = new MusicAlbum();
		musicAlbum.setId("id");
		musicAlbum.setDuration(10);
		musicAlbum.setSize(8);
		musicAlbum.setTitle("Melodies of the Heart");
		when(musicAlbumRepository.findById("id")).thenReturn(Optional.of(new MusicAlbum()));
		assertEquals("best-quality", musicAlbumService.qualityCheck("id"), "Strings do not match exactly!");
	}

}
