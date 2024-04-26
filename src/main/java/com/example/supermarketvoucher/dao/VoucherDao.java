package com.example.supermarketvoucher.dao;

import com.example.supermarketvoucher.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherDao extends JpaRepository<Voucher,Integer> {
}
