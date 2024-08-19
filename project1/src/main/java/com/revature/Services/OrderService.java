package com.revature.Services;

import com.revature.Models.Order;
import com.revature.Repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    OrderRepo or;

    @Autowired
    private OrderService(OrderRepo or){
        this.or = or;
    }

    public Order postOrder(Order order){
        return or.save(order);
    }

    public List<Order> getAllOrders() {
        return or.findAll();
    }

    public void deleteById(int order_id) {
        or.deleteById(order_id);
    }

    public Order findById(int order_id){
        return or.findById(order_id).orElse(null);
    }

    public List<Order> getAllUserOrders(int user_id){
        return or.findAllByUserId(user_id);
    }
}
