package com.example.supermarketvoucher.controller;

import com.example.supermarketvoucher.dao.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProductDao productDao;

    @RequestMapping({"/","/home"})
    public String home(Model model){
        model.addAttribute("products",productDao.findAll());
        return "home";
    }
}
