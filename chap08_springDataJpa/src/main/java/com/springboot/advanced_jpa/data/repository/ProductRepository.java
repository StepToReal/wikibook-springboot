package com.springboot.advanced_jpa.data.repository;

import com.springboot.advanced_jpa.data.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByNumber(Long number);

    List<Product> findAllByName(String name);

    Product queryByNumber(Long number);

    boolean existsByNumber(Long number);

    long countByName(String name);

    void deleteByNumber(Long number);

    long removeByName(String name); // 삭제 로우 수 리턴

    List<Product> findFirst5ByName(String name);

    List<Product> findTop10ByName(String name); // 결과 개수 제한, findFirst ' findTop 둘다 같은 동작

    Product findByNumberIs(Long number);

    Product findByNumberEquals(Long number); // is, equals 모두 동일한지 비교 하는 것, 생략되는 경우가 많다.

    Product findByNumberIsNot(Long number);

    Product findByNumberNot(Long number); // 값의 불일치를 조건으로 사용, is 생략하고 not 만 사용가능

    List<Product> findByUpdatedAtNull();

    List<Product> findByUpdatedAtNotNull(); // null, not null 검색

    Product findByNumberAndName(Long number, String name);

    Product findByNumberOrName(Long number, String name);

    List<Product> findByPriceGreaterThan(Integer price);

    List<Product> findByPriceGreaterThanEqual(Integer price);

    List<Product> findByPriceLessThan(Integer price);

    List<Product> findByPriceLessThanEqual(Integer price);

    List<Product> findByPriceBetween(Integer lowPrice, Integer highPrice);

    List<Product> findByNameLike(String name);

    List<Product> findByNameContains(String name);

    List<Product> findByNameStartsWith(String name);

    List<Product> findByNameEndsWith(String name);

    List<Product> findByNameOrderByNumberAsc(String name);

    List<Product> findByNameOrderByNumberDesc(String name);

    List<Product> findByNameOrderByPriceAscStockDesc(String name); // order by에 조건을 여러개 달 때는 and, or 사용하지 않음.

    List<Product> findByName(String name, Sort sort); // 매개변수를 활용해 정렬할 수도 있다.

    Page<Product> findByName(String name, Pageable pageable);

    @Query("select p from Product as p where p.name = :name")
    List<Product> findByName(@Param("name") String name);

    @Query("select p.name, p.price, p.stock from Product p where p.name = :name")
    List<Object[]> findByNameParam2(@Param("name") String name);
}
