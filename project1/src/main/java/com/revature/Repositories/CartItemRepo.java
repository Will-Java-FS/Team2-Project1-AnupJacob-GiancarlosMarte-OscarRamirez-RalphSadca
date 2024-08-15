package com.revature.Repositories;

import com.revature.Models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Integer> {


    List<CartItem> findByCartId(int cart_id);
}
