package com.springboot.relationship.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product_detail")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProductDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @OneToOne
//    @OneToOne(optional = false) // optional = false를 주면 product가 null인 값을 허용하지 않는다.
    @JoinColumn(name = "product_number") //매핑할 컬럼 이름을 생성 명시 안해주면 자동으로 생성해 주긴 하는데 의도된 동작이 이루어 지는게 아니기 때문에 비추
    private Product product;
}
