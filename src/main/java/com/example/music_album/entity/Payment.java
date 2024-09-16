package com.example.music_album.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
public class Payment extends Base{
    private String orderId;
    private Double amount;
    public Payment(String id, String orderId, Double amount, String username, String albumTitle){
        super(id, username, albumTitle);
        this.orderId = orderId;
        this.amount = amount;
    }
}
