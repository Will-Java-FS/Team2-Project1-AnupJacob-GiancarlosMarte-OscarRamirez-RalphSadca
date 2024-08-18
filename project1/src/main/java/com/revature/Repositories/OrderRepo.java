package com.revature.Repositories;

import com.revature.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

    /* Stretch Goal: filter orders by date created is useful for the user front end

    // Retrieves all orders from that month - can keep calling to get orders from month x to month y
    public List<Order> findOrdersByMonth(Month month);

    // Retrieves an order from a specific day
    public Order findOrderByDate(Date date)
     */

    @Query(value = "SELECT o FROM Order o WHERE o.user_id = :user_id " +
            "AND order_id = :order_id",
            nativeQuery = true)
    Order findByUserIdAndOrderId(@Param("user_id") int user_id,
                                           @Param("order_id") int order_id);

    @Query(value = "SELECT Order o FROM order WHERE o.user_id = :user_id",
            nativeQuery = true)
    List<Order> findAllByUserId(@Param("user_id") int user_id);

}
