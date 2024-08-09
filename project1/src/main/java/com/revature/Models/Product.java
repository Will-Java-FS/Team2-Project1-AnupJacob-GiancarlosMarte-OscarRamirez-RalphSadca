package com.revature.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@Table(name="Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int product_id;
    @Column(nullable = false)
    private String title;
    @Column
    private String description;
    @Column(nullable = false)
    private BigDecimal money;
    @OneToMany
    @JoinColumn(name = "category_id")
    private Category category;
    @Column
    private LocalDateTime time_created;

    public Product() {
    }

    public Product(int product_id, String title, String description, BigDecimal money, Category category, LocalDateTime time_created) {
        this.product_id = product_id;
        this.title = title;
        this.description = description;
        this.money = money;
        this.category = category;
        this.time_created = time_created;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setTime_created(LocalDateTime time_created) {
        this.time_created = time_created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getProduct_id() == product.getProduct_id() && Objects.equals(getTitle(), product.getTitle()) && Objects.equals(getDescription(), product.getDescription()) && Objects.equals(getMoney(), product.getMoney()) && Objects.equals(getCategory(), product.getCategory()) && Objects.equals(getTime_created(), product.getTime_created());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct_id(), getTitle(), getDescription(), getMoney(), getCategory(), getTime_created());
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", money=" + money +
                ", category=" + category +
                ", time_created=" + time_created +
                '}';
    }
}
