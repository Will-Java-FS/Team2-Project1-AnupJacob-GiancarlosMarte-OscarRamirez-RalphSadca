package com.revature.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@Table(name="Product")
@AllArgsConstructor
@NoArgsConstructor
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

}
