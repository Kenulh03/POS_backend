package com.ijse.hellospring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private Double price;
    private Integer qty;
    private Long categoryId;
}
