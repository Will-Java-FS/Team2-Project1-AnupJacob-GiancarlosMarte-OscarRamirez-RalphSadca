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
    private BigDecimal price;
    @OneToOne // changed from OneToMany; Spring message: Property 'com.revature.Models.Product.category' is not a collection and may not be a '@OneToMany', '@ManyToMany', or '@ElementCollection'
    @JoinColumn(name = "category_id")
    private Category category;
    @Column
    private String image_url;

    public Product() {
    }

    public Product(int product_id, String title, String description, BigDecimal price, Category category,
                   String image_url) {
        this.product_id = product_id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image_url = image_url;
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

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setImage_id(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getProduct_id() == product.getProduct_id()
                && Objects.equals(getTitle(), product.getTitle())
                && Objects.equals(getDescription(), product.getDescription())
                && Objects.equals(getPrice(), product.getPrice())
                && Objects.equals(getCategory(), product.getCategory())
                && Objects.equals(getImage_url(), product.getImage_url());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct_id(), getTitle(), getDescription(), getPrice(), getCategory(),
                getImage_url());
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", image_id=" + image_url +
                '}';
    }
}
