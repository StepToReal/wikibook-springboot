package com.springboot.advanced_jpa.data.dto;

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
