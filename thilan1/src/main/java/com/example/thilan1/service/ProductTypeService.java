package com.example.thilan1.service;

import com.example.thilan1.entity.ProductType;

import java.util.List;

public interface ProductTypeService {
    public List<ProductType> findAll();

    public ProductType findById(int id);
}
