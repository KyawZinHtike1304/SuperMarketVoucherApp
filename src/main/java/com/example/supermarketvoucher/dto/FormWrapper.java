package com.example.supermarketvoucher.dto;

import com.example.supermarketvoucher.entity.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FormWrapper {
    private Customer customer;
    private List<CartItem> cartItem;
}
