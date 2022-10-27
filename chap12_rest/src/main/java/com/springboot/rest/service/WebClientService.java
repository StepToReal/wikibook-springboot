package com.springboot.rest.service;

import com.springboot.rest.data.dto.MemberDto;
import org.apache.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebClientService {

    public String getName() {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:9090")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        // 여긴 Mono를 사용
        return webClient.get()
                .uri("/api/v1/crud-api")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getNameWithPathVariable() {
        WebClient webClient = WebClient.create("http://localhost:9090");

        // 여긴 toEntity를 사용하여 ResponseEntity 타입으로 응답을 받음.
        ResponseEntity<String> responseEntity = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/v1/crud-api/{name}").build("Flature"))
                .retrieve().toEntity(String.class).block();

        // 이렇게도 가능
        ResponseEntity<String> responseEntity1 = webClient.get()
                .uri("/api/v1/crud-api/{name}", "Flature")
                .retrieve()
                .toEntity(String.class)
                .block();

        return responseEntity.getBody();
    }

    public String getNameWithParameter() {
        WebClient webClient = WebClient.create("http://localhost:9090");

        // retrieve 가 아닌 exchange를 사용하면 응답 결과에 따라 다른 응답을 설정 할 수 있음.
        return webClient.get().uri(uriBuilder -> uriBuilder.path("/api/v1/crud-api")
                .queryParam("name", "Flature")
                .build())
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(String.class);
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                })
                .block();
    }

    public ResponseEntity<MemberDto> postWithParamAndBody() {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:9090")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        MemberDto memberDto = new MemberDto();
        memberDto.setName("flature!");
        memberDto.setEmail("jcob0920@gmail.com");
        memberDto.setOrganization("Around Hub Studio");

        return webClient.post().uri(uriBuilder -> uriBuilder.path("/api/v1/crud-api")
                .queryParam("name", "Flature")
                .queryParam("email", "jcob0920@gmail.com")
                .queryParam("organization", "wikibooks")
                .build())
                .bodyValue(memberDto)
                .retrieve()
                .toEntity(MemberDto.class)
                .block();
    }

    public ResponseEntity<MemberDto> getWithHeader() {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:9090")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        MemberDto memberDto = new MemberDto();
        memberDto.setName("flature!");
        memberDto.setEmail("jcob0920@gmail.com");
        memberDto.setOrganization("Around Hub Studio");

        return webClient.post()
                .uri(uriBuilder -> uriBuilder.path("/api/v1/crud-api/add-header")
                        .build())
                .bodyValue(memberDto)
                .header("my-header", "Wikibooks")
                .retrieve()
                .toEntity(MemberDto.class)
                .block();
    }
}
