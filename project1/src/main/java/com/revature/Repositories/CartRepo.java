package com.revature.Repositories;

import com.revature.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{

    @Query(value = "SELECT c FROM cart c WHERE c.user_id = :user_id",
        nativeQuery = true)
    Cart getCartByUserId(@Param("user_id") int userId);

}