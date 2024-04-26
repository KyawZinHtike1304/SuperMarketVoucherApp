package com.example.supermarketvoucher.controller;

import com.example.supermarketvoucher.dao.CustomerDao;
import com.example.supermarketvoucher.dao.ProductDao;
import com.example.supermarketvoucher.dao.VoucherDao;
import com.example.supermarketvoucher.dto.CartItem;
import com.example.supermarketvoucher.dto.FormWrapper;
import com.example.supermarketvoucher.entity.Customer;
import com.example.supermarketvoucher.entity.Product;
import com.example.supermarketvoucher.entity.Voucher;
import com.example.supermarketvoucher.service.CartService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CustomerDao customerDao;
    private final ProductDao productDao;
    private final VoucherDao voucherDao;
    private final CartService cartService;

    @GetMapping("/add-cart")
    public String addToCart(@RequestParam("id") int id) {
        Product product = productDao.findById(id).orElseThrow(EntityNotFoundException::new);
        cartService.addToCart(product);
        return "redirect:/home";
    }

    @GetMapping("/view-cart")
    public String viewCart(Model model) {

        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("formWrapper", new FormWrapper());
        return "viewcart";
    }

    @PostMapping("/checkout")
    public String checkout(FormWrapper formWrapper) {

        List<CartItem> cart  = formWrapper.getCartItem();//2
        Customer customer = formWrapper.getCustomer();
        customerDao.save(customer);
        int totalPrice = 0;

//        List<CartItem> cartItems = cartService.getCartItems();

        for (CartItem c : cart) {
            Product p = productDao.findById(c.getId()).orElseThrow(EntityNotFoundException::new);
            p.setQuantity(c.getQuantity());
            totalPrice += c.getQuantity() * c.getPrice();

            customer.addProduct(p);
        }

        Voucher voucher = new Voucher(LocalDateTime.now(),totalPrice,customer);
        voucherDao.save(voucher);
        cartService.clearCart();
//        cartItems.clear();
//        cart.clear();
//        cart.addAll(cartItems);
        return "redirect:/voucher/info";
    }

    @GetMapping("/clear-cart")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart/view-cart";
    }


    @GetMapping("/delete")
    public String deleteCartItem(@RequestParam("id") int id) {
        cartService.deleteCartItem(id);
        return "redirect:/cart/view-cart";

    }
}
