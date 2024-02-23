package com.example.khuyenmai.service;

import com.example.khuyenmai.entity.KhuyenMai;
import com.example.khuyenmai.entity.KhuyenMai;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface KhuyenMaiService {
    public List<KhuyenMai> findAll() ;


    public void save(@Valid KhuyenMai khuyenMai) ;

    Page<KhuyenMai> findAll(Pageable pageable, String mucGiamGia,String ngayBatDau,String ngayKetThuc);

    void delete(long id);
}
