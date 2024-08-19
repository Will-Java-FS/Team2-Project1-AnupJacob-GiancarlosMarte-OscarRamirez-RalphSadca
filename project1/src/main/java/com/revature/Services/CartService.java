package com.revature.Services;

import com.revature.Models.Cart;
import com.revature.Models.CartItem;
import com.revature.Repositories.CartRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    CartRepo cr;

    @Autowired
    public CartService(CartRepo cr) {
        this.cr = cr;
    }

    public Cart getCartById(int cartId) {
        return cr.findById(cartId).orElse(null);
    }

    public Cart getCartByUserId(int userId) {
        return cr.getCartByUserId(userId);
    }

    public void deleteCartById(int cartId) {
        cr.deleteById(cartId);
    }

}
