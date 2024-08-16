//package com.revature.Models;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name="cart_item")
//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
//public class CartItem{
//
//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private int cart_item_id;
//
//    @OneToOne
//    @JoinColumn(name="product_id", nullable = false)
//    private Product product;
//
//    @Column(name="cart_id", nullable = false)
//    private int cart_id;
//
//    @Column(name="quantity")
//    private int quantity;
//
//    @Column(name="created_at",columnDefinition = "TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP")
//    private LocalDateTime created_at;
//
//    @Column(name="modified_at",columnDefinition = "TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP")
//    private LocalDateTime modified_at;
//}