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

    public Order getOrderById(int user_id, int order_id){
        return or.findByUserIdAndOrderId(user_id, order_id).orElse(null);
    }

    public List<Order> getAllUserOrders(int user_id){
        return or.findAllByUserId(user_id);
    }
}
