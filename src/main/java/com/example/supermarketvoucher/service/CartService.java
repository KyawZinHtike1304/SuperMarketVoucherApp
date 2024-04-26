package com.example.supermarketvoucher.service;

import com.example.supermarketvoucher.dto.CartItem;
import com.example.supermarketvoucher.entity.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class CartService {

    private List<CartItem> cartItems = new ArrayList<>();

public void addToCart(Product product) {
    if (cartItems.isEmpty()) {
        cartItems.add(toCartItem(product));
        return;
    }

    for (CartItem c : cartItems) {
        if (c.getId() != product.getId()) {
            continue;
        } else {
            c.setQuantity(c.getQuantity() + 1);
            return;
        }
    }
    // If loop completes, product not found in cart, add new item
    cartItems.add(toCartItem(product));
}


    public CartItem toCartItem(Product product){
        return new CartItem(product.getId(), product.getName(), product.getPrice());
    }

    public void clearCart() {
        cartItems.clear();
    }

    public void deleteCartItem(int id) {
        cartItems.removeIf(cartItem -> cartItem.getId() == id);
    }
}