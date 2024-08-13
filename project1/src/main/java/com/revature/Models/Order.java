package com.revature.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;
@Data
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int order_id;
    @Column
    private  double total;
    @Column(nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created_at = LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name= "cart_id")
    private Cart cart;

    public Order(int order_id, double total, LocalDateTime created_at, User user, Cart cart) {
        this.order_id = order_id;
        this.total = total;
        this.created_at = created_at;
        this.user = user;
        this.cart = cart;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getOrder_id() == order.getOrder_id() && Double.compare(getTotal(), order.getTotal()) == 0 && Objects.equals(getCreated_at(), order.getCreated_at()) && Objects.equals(getUser(), order.getUser()) && Objects.equals(getCart(), order.getCart());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrder_id(), getTotal(), getCreated_at(), getUser(), getCart());
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", total=" + total +
                ", created_at=" + created_at +
                ", user=" + user +
                ", cart=" + cart +
                '}';
    }
}
