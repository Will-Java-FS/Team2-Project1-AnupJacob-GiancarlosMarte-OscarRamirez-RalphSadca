//package com.revature.Services;
//
//import com.revature.Models.CartItem;
//import com.revature.Repositories.CartItemRepo;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CartItemService {
//
//    private final CartItemRepo cir;
//
//    public CartItemService(CartItemRepo cir) {
//        this.cir = cir;
//    }
//
//    //R
//    public List<CartItem> findByCartId(int cartId) {
//        return cir.findByCartId(cartId);
//    }
//
//    public CartItem findById(int cartItemId) {
//        return cir.findById(cartItemId).get();
//    }
//
//    //C
//    public CartItem addCartItem(CartItem cartItem) {
//        return cir.save(cartItem);
//    }
//
//
//    //U
//    public CartItem updateCartItem(CartItem updatedCartItem) {
//        return cir.save(updatedCartItem);
//    }
//
//    //D
//    public CartItem deleteCartItemById(int cartItemId) {
//        Optional<CartItem> deletedItem = cir.findById(cartItemId);
//        if (deletedItem.isPresent()) {
//            cir.deleteById(cartItemId);
//            return deletedItem.get();
//        }
//        return null;
//    }
//}
