package com.example.onlinestorebackend.controllers;

import com.example.onlinestorebackend.exceptions.UserNotFoundException;
import com.example.onlinestorebackend.models.User;
import com.example.onlinestorebackend.services.CartService;
import com.example.onlinestorebackend.services.OrderDetailService;
import com.example.onlinestorebackend.services.OrderLineService;
import com.example.onlinestorebackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.Access;
import java.security.Principal;

/**
 * @author Marko
 * @Date 11/04/2023
 */
@Controller
@RequestMapping("/checkout")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderLineService orderLineService;
    @Autowired
    private CartService cartService;
    @GetMapping
    public String showCheckoutPage(Model model, RedirectAttributes redirectAttributes, Principal principal) {
        try {
            User user = userService.findUserByFullName(principal.getName());
            model.addAttribute("orderLine", orderLineService.findActiveOrderLineByUser(user));
            model.addAttribute("cart", cartService.getCartByUser(user));
            return "cart/checkout";
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
