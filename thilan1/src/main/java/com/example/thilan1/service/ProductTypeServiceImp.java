package com.example.thilan1.service;

import com.example.thilan1.entity.Product;
import com.example.thilan1.entity.ProductType;
import com.example.thilan1.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductTypeServiceImp implements ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Override
    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }
    @Override
    public ProductType findById(int id){
        return productTypeRepository.findById(id).get();
    }
}
