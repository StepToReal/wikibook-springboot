package com.springboot.valid_exception.data.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ProductDto {
    private String name;
    private int price;
    private int stock;
}
