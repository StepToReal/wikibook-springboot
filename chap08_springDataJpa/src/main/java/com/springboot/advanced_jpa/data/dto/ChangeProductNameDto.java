package com.springboot.advanced_jpa.data.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class ChangeProductNameDto {

    private Long number;
    private String name;
}
