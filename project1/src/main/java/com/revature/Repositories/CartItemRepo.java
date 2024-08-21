package com.revature.Repositories;

import com.revature.Models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Integer> {

    @Query("SELECT c FROM CartItem c WHERE c.cart.cart_id = :cart_id")
    List<CartItem> findAllByCartId(@Param("cart_id") int cart_id);

}
