package com.springboot.security.data.dto;

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
