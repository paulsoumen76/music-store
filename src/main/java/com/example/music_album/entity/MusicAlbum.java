package com.example.music_album.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name = "musicalbum")
public class MusicAlbum {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private String id;
   @NotBlank(message = "title is mandatory")
   @Size(min = 4, max = 30, message = "title must be between 3 and 20 characters")
   private String title;
   private String singerName;
   private String writtenBy;
   private int duration;
   @NotNull(message = "Value is mandatory")
   @Max(value = 10, message = "Value must not exceed 10")
   @Min(value = 0, message = "Value must not be less than 0")
   private int size;
}
