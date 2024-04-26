package com.example.supermarketvoucher.dto;

import com.example.supermarketvoucher.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    private int id;
    private String name;
    private int price;
    private int quantity = 1;
    private int totalPrice = price * quantity;

    public CartItem(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
