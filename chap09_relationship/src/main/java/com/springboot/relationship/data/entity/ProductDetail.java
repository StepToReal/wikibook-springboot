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
    @JoinColumn(name = "product_number")
    private Product product;
}
