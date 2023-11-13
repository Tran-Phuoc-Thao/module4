package com.example.thilan1.service;

import com.example.thilan1.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {



    void saveProduct(Product product);

    Page<Product> findAll(Pageable pageable, String searchName,String searchPrice,String searchType);

    public Product findById(int id);
    public void delete(int id);
}
