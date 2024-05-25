package com.ijse.hellospring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderProductDto {
    private Long productId;
    private int quantity;
}
