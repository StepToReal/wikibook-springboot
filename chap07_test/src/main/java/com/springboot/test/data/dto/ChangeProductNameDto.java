package com.springboot.test.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ChangeProductNameDto {

    private Long number;
    private String name;
}
