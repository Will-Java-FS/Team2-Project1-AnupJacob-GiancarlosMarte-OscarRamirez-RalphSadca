package com.revature.Controllers;

import com.revature.Models.Cart;
import com.revature.Services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    CartService cs;

    @Autowired
    public CartController(CartService cs) {
        this.cs = cs;
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<Cart> findCartById(@PathVariable int id) {
        Cart cart = cs.getCartById(id);
        return cart == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                : ResponseEntity.status(HttpStatus.OK).body(cart);
    }

    @GetMapping("/cart/user/{id}")
    public ResponseEntity<Cart> findCartByUserId(@PathVariable int id) {
        Cart cart = cs.getCartById(id);
        return cart == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                : ResponseEntity.status(HttpStatus.OK).body(cart);
    }

    @DeleteMapping("/cart/{id}")
    public ResponseEntity<Cart> deleteCartById(@PathVariable int id) {
        cs.deleteCartById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
