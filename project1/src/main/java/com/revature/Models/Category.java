package com.revature.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@Table(name = "Category")
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    int category_id;
    @Column(nullable = false)
    String name;
    @Column(name="image_url", nullable = false)
    private String image_url;

    public Category(int category_id, String name, String image_url) {
        this.category_id = category_id;
        this.name = name;
        this.image_url = image_url;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return getCategory_id() == category.getCategory_id() && Objects.equals(getName(), category.getName()) && Objects.equals(getImage_url(), category.getImage_url());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategory_id(), getName(), getImage_url());
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", name='" + name + '\'' +
                ", image_url=" + image_url +
                '}';
    }
}
