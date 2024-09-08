package com.example.music_album.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Payment extends Base{
    private Long orderId;
    private Double amount;
    public Payment(Long id, Long orderId, Double amount, String username, String albumTitle){
        super(id, username, albumTitle);
        this.orderId = orderId;
        this.amount = amount;
    }
}
