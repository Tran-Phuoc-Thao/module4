package com.example.demo.entity;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class KhuyenMai implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    private String title;
    @NotEmpty
    @DateTimeFormat

    private String ngayBatDau;
    @NotEmpty
    @DateTimeFormat
    private String ngayKetThuc;
    @NumberFormat
    @Range(min=10000)
    @NotEmpty
    private String mucGiamGia;
    @NotEmpty

    private String chiTiet;

    public KhuyenMai() {
    }

    public KhuyenMai(long id, String title, String ngayBatDau, String ngayKetThuc, String mucGiamGia, String chiTiet) {
        this.id = id;
        this.title = title;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.mucGiamGia = mucGiamGia;
        this.chiTiet = chiTiet;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }

    public KhuyenMai(String title, String ngayBatDau, String ngayKetThuc, String mucGiamGia, String chiTiet) {
        this.title = title;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.mucGiamGia = mucGiamGia;
        this.chiTiet = chiTiet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMucGiamGia() {
        return mucGiamGia;
    }

    public void setMucGiamGia(String mucGiamGia) {
        this.mucGiamGia = mucGiamGia;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof KhuyenMai)) {
            return;
        }

        KhuyenMai khuyenMai = (KhuyenMai) target;




    }
}
//@NotNull – kiểm tra giá trị null
//@AssertTrue – kiểm tra giá trị thuộc tính là true
//@Size – kiểm tra độ dài min and max
//@Min – kiểm tra giá trị nhỏ nhất
//@Max – Kiểm tra giá trị lớn nhất
//@Email – kiểm tra email có hợp lệ
//@NotEmpty – kiểm tra không được trống và empty
//@NotBlank – kiểm tra giá trị không được null hoặc khoảng trắng
//@Positive and @PositiveOrZero – kiểm tra chỉ được phép là số nguyên dương từ 0 trở đi
//@Negative and @NegativeOrZero – kiểm tra số âm
//@Past and @PastOrPresent – kiểm tra ngày từ quá khứ đến hiện tại.
//@Future and @FutureOrPresent – kiểm tra ngày từ hiện tại đến tương lai