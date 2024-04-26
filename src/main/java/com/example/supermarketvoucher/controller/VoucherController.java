package com.example.supermarketvoucher.controller;

import com.example.supermarketvoucher.dao.VoucherDao;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/voucher")
public class VoucherController {

    private final VoucherDao voucherDao;

    @GetMapping("/info")
    public String info(Model model){
        model.addAttribute("vouchers",voucherDao.findAll());
        return "info";
    }

    @GetMapping("/details")
    public String details(@RequestParam("vId")int voucherId,Model model){
        model.addAttribute("voucher",voucherDao.findById(voucherId).orElseThrow(EntityNotFoundException::new));
        return "info-details";
    }

}
