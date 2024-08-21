/*package com.revature.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;
@Data
@Entity
@Table(name = "order_item")
public class Order_Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private int order_item_id;

    @Column(name="quantity")
    private int quantity;

    @Column(name="created_at",columnDefinition = "TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created_at;

    @OneToOne
    @JoinColumn(name="order_id", nullable = false)
    private Order order;

    @OneToMany
    @JoinColumn(name="product_id", nullable = false)
    private Product product;

    public Order_Item(int order_item_id, int quantity, LocalDateTime created_at, Order order, Product product) {
        this.order_item_id = order_item_id;
        this.quantity = quantity;
        this.created_at = created_at;
        this.order = order;
        this.product = product;
    }

    public int getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(int order_item_id) {
        this.order_item_id = order_item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order_Item{" +
                "order_item_id=" + order_item_id +
                ", quantity=" + quantity +
                ", created_at=" + created_at +
                ", order=" + order +
                ", product=" + product +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order_Item orderItem = (Order_Item) o;
        return getOrder_item_id() == orderItem.getOrder_item_id() && getQuantity() == orderItem.getQuantity() && Objects.equals(getCreated_at(), orderItem.getCreated_at()) && Objects.equals(getOrder(), orderItem.getOrder()) && Objects.equals(getProduct(), orderItem.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrder_item_id(), getQuantity(), getCreated_at(), getOrder(), getProduct());
    }
}
*/