package com.example.supermarketvoucher.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Voucher {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime purchaseTime;
    private int totalPrice;

    @ManyToOne
    private Customer customer;

    public Voucher(LocalDateTime purchaseTime, int totalPrice, Customer customer) {
        this.purchaseTime = purchaseTime;
        this.totalPrice = totalPrice;
        this.customer = customer;
    }
}
