package com.revature.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@Table(name = "Category")
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    int category_id;
    @Column(nullable = false)
    String name;
    @Column(name="image_url", nullable = false)
    private String image_url;

}
