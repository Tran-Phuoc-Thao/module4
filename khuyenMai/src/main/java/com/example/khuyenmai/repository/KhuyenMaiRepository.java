package com.example.khuyenmai.repository;

import com.example.khuyenmai.entity.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai,Long> {

    @Query(value = "select * from khuyen_mai where muc_giam_gia like :mucGiamGia and ngay_bat_dau like :ngayBatDau and ngay_ket_thuc like :ngayKetThuc",nativeQuery = true)
    Page<KhuyenMai> findAll(Pageable pageable, @Param("mucGiamGia") String mucGiamGia, @Param("ngayBatDau") String ngayBatDau, @Param("ngayKetThuc") String ngayKetThuc);

}
