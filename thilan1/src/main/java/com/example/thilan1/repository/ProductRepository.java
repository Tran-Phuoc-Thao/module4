package com.example.thilan1.repository;

import com.example.thilan1.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(value = "select * from product where name like :searchName and price like :searchPrice and id_product_type like :searchType",nativeQuery = true)
    Page<Product> findAll(Pageable pageable, @Param("searchName") String searchName, @Param("searchPrice") String searchPrice,@Param("searchType") String searchType);

    @Query(value = "select * from product where name like :searchName and price like :searchPrice and id_product_type like :searchType",nativeQuery = true)
    void update();




}
