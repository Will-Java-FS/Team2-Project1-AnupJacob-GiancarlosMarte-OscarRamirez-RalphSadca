package com.revature.Repositories;

import com.revature.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

    // Made before User model finished - might need renaming
    public List<Order> findOrdersByUser(int user);

    /* Stretch Goal: filter orders by date created is useful for the user front end

    // Retrieves all orders from that month - can keep calling to get orders from month x to month y
    public List<Order> findOrdersByMonth(Month month);

    // Retrieves an order from a specific day
    public Order findOrderByDate(Date date)
     */
}
