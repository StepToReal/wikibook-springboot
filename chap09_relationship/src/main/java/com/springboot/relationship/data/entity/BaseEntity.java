package com.springboot.relationship.data.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@MappedSuperclass // JPA 엔티티 클래스가 상속을 받을때 자식 클래스에게 매핑정보를 전달
@EntityListeners(AuditingEntityListener.class) //엔티티를 데이터베이스에 적용하기 전후로 콜백을 요청할 수 있게 하는 어노테이션
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
