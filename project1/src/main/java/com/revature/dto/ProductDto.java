package com.revature.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@Data
public class ProductDto {
    private String title;
    private String description;
    private BigDecimal price;
    private int category_id;
}
