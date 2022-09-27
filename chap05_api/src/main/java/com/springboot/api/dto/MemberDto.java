package com.springboot.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    /*
     필드 이름과 request 파라미터 명이 다를 때 JsonProperty annotation 사용,
     JsonNaming 사용하여 일괄 적용도 가능 (단 snake case -> kamel case 만 되는 듯, JsonNaming 사용에 관한 자세한 내용 확인 필요)
     */

    @JsonProperty("name")
    private String nameTest;
    private String email;
    private String organization;

    @Override
    public String toString() {
        return "MemberDto {name='" + nameTest + "', email='" + email + "', organization='" + organization + "'}";
    }
}
