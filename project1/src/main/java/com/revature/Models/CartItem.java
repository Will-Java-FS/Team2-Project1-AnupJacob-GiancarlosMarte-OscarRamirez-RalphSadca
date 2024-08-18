package com.revature.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cart_item")
public class CartItem{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int cart_item_id;

    @OneToOne
    @JoinColumn(name="product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable = false)
    private Cart cart;

    @Column(name="quantity")
    private int quantity;
}