package com.revature.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int product_id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private BigDecimal money;
    @OneToMany
    @JoinColumn(name = "category_id")
    private Category category;
    @Column
    private LocalDateTime time_created;

}
