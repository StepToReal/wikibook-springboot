package com.springboot.relationship.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "provider")
public class Provider extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // mappedBy: 양방향 관계일때 주인이 아닌 객체에 지정 (주인은 JoinColumn) value 값은 상대 엔터티의 연관 필드명
    @OneToMany(mappedBy = "provider", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, orphanRemoval = true)
    @ToString.Exclude
    private List<Product> productList = new ArrayList<>();
}
