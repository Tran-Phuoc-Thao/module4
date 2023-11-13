package com.example.demo.service;

import com.example.demo.entity.KhuyenMai;
import com.example.demo.repository.KhuyenMaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhuyenMaiServiceImp implements KhuyenMaiService{

    @Autowired
    private KhuyenMaiRepository repository;


    @Override
    public List<KhuyenMai> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(KhuyenMai khuyenMai) {
        repository.save(khuyenMai);
    }

    @Override
    public Page<KhuyenMai> findAll(Pageable pageable, String mucGiamGia,String ngayBatDau,String ngayKetThuc) {
        return repository.findAll(pageable,mucGiamGia,ngayBatDau,ngayKetThuc);
    }


    public KhuyenMai findById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(long id) {
        repository.delete(findById(id));
    }

}
