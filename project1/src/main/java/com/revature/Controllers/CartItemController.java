package com.revature.Controllers;

import com.revature.Models.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.revature.Services.CartItemService;

import java.util.List;

@RestController
@CrossOrigin
public class CartItemController {

    CartItemService cis;

    @Autowired
    private CartItemController(CartItemService cis) {
        this.cis = cis;
    }

//    @RequestMapping(method= RequestMethod.GET, value="/cart-item")
//    public CartItem getCartItemById(){
//        return cis.getCartItemById();
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/add-cart-item")
    public CartItem addCartItem(@RequestBody CartItem cartItem) {
        return cis.addCartItem(cartItem);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-cart-items/{cart_id}")
    public List<CartItem> getAllCartItems(@PathVariable int cart_id) {
        return cis.getCartItems(cart_id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete-cart-item/{cart_item_id}")
    public void deleteCartItem(@PathVariable int cart_item_id) {
        cis.deleteCartItem(cart_item_id);
    }

}

