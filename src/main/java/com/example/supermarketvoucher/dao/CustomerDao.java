package com.example.supermarketvoucher.dao;

import com.example.supermarketvoucher.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Integer> {
}
