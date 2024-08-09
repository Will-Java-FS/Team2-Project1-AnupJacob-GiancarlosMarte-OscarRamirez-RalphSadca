package com.revature.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.text.DecimalFormat;
import java.util.Objects;

@Data
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cart_id;
    @Column
    private int quantity;
    @Column
    private  double total;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany
    @JoinColumn(name= "product_id")
    private Product product;

    public Cart(int cart_id, int quantity, double total, User user, Product product) {
        this.cart_id = cart_id;
        this.quantity = quantity;
        this.total = total;
        this.user = user;
        this.product = product;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return getCart_id() == cart.getCart_id() && getQuantity() == cart.getQuantity() && Double.compare(getTotal(), cart.getTotal()) == 0 && Objects.equals(getUser(), cart.getUser()) && Objects.equals(getProduct(), cart.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCart_id(), getQuantity(), getTotal(), getUser(), getProduct());
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cart_id=" + cart_id +
                ", quantity=" + quantity +
                ", total=" + total +
                ", user=" + user +
                ", product=" + product +
                '}';
    }
}
