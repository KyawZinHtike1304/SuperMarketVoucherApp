package com.example.supermarketvoucher.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String remark;

    @OneToMany(mappedBy = "customer")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<Voucher> vouchers = new ArrayList<>();

    public void addProduct(Product product){
        product.setCustomer(this);
        products.add(product);
    }

    public void addVoucher(Voucher voucher){
        voucher.setCustomer(this);
        vouchers.add(voucher);
    }
}
