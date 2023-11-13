package com.example.thilan1.service;

import com.example.thilan1.entity.Product;
import com.example.thilan1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;



    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Page<Product> findAll(Pageable pageable, String searchName,String searchPrice,String searchType) {
        return productRepository.findAll(pageable,searchName,searchPrice,searchType);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        productRepository.delete(findById(id));
    }

}
