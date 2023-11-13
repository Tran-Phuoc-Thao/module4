package com.example.demo.service;

import com.example.demo.entity.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface KhuyenMaiService {
    public List<KhuyenMai> findAll() ;


    public void save(KhuyenMai khuyenMai) ;

    Page<KhuyenMai> findAll(Pageable pageable, String mucGiamGia,String ngayBatDau,String ngayKetThuc);

    void delete(long id);
}
