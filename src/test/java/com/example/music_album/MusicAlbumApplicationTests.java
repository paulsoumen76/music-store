package com.example.music_album;

import com.example.music_album.entity.MusicAlbum;
import com.example.music_album.repository.MusicAlbumRepository;
import com.example.music_album.service.MusicAlbumService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class MusicAlbumApplicationTests {
	@InjectMocks
	private MusicAlbumService musicAlbumService;
	@Mock
    private MusicAlbumRepository musicAlbumRepository;

	@Captor
	ArgumentCaptor<String> idCapture;

	@Test
	void testQuality_musicAlbumService_valid() {
		MusicAlbum musicAlbum = new MusicAlbum();
		musicAlbum.setId("id");
		musicAlbum.setDuration(10);
		musicAlbum.setSize(8);
		musicAlbum.setTitle("Melodies of the Heart");
		when(musicAlbumRepository.findById("id")).thenReturn(Optional.of(musicAlbum));


//		verify(musicAlbumRepository,times(1)).findById(idCapture.capture());

//		assertNull(idCapture.getValue());
		assertEquals("best-quality", musicAlbumService.qualityCheck("id"), "Strings do not match exactly!");
		verify(musicAlbumRepository).findById(idCapture.capture());
		assertEquals("Soumen-id",idCapture.getValue());
	}

}
