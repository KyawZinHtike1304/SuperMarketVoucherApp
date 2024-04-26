package com.example.supermarketvoucher.dao;

import com.example.supermarketvoucher.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {
}
