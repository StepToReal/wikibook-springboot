package com.springboot.actuator.config.actuactor;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomInfoContributor implements InfoContributor {

    // builder는 info 엔드포인트에서 보여줄 내용을 담는 역할을 함.
    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Object> content = new HashMap<>();

        content.put("code-info", "infoContributor 구현체에서 정의한 정보 입니다.");
        builder.withDetail("custom-info-contributor", content);
    }
}
