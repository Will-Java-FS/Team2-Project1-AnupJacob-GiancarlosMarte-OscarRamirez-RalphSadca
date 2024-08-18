//package com.revature.Controllers;
//
//import com.revature.Models.Order;
//import com.revature.Services.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class OrderController {
//
//    OrderService os;
//
//    @Autowired
//    private OrderController(OrderService os){
//        this.os = os;
//    }
//
//    @RequestMapping(method= RequestMethod.POST, value="/order")
//    public Order postOrder(@RequestBody Order order){
//        return os.postOrder(order);
//    }
//
//    @RequestMapping(method=RequestMethod.GET, value="/order/{user_id}/{order_id}")
//    public ResponseEntity<Order> getOrderById(@PathVariable int user_id, int order_id){
//        Order retrievedOrder = os.getOrderById(user_id, order_id);
//        return retrievedOrder==null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) : new ResponseEntity<>(retrievedOrder, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/order/{user_id}")
//    public ResponseEntity<Order> deleteOrderByUserId(@PathVariable int user_id){
//        os.deleteOrderByUserId(user_id);
//        return new ResponseEntity<>(null, HttpStatus.OK);
//    }
//
//    @GetMapping("/order")
//    public ResponseEntity<List<Order>> getAllOrders() {
//        List<Order> orders = os.getAllOrders();
//        return orders == null ? new ResponseEntity<>(null, HttpStatus.BAD_REQUEST) : new ResponseEntity<>(orders, HttpStatus.OK);
//    }
//
//    @RequestMapping(method=RequestMethod.GET, value="orders/{user_id}")
//    public List<Order> getAllUserOrders(@PathVariable int user_id){
//        return os.getAllUserOrders(user_id);
//    }
//}
