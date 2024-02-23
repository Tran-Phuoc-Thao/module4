package com.example.validatebh.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class BaiHat  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max=800)
    @Pattern(regexp = "^[^@;,\\.\\-=\\+]*$", message = "Không được chứa các ký tự đặc biệt như @ ; , . = - +")
    @NotBlank(message = "Không được phép để trống")
    @NotEmpty(message = "Không được phép để trống")
    private String ten;
    @Max(value = 300,message = "khong vuot qua 300 ki tu")
    @Pattern(regexp = "^[^@;,\\.\\-=\\+]*$", message = "Không được chứa các ký tự đặc biệt như @ ; , . = - +")
    @NotBlank(message = "Không được phép để trống")
    @NotEmpty(message = "Không được phép để trống")
    private String ngheSiTheHien;
    @Pattern(regexp = "[^a-zA-Z0-9,\\s]"
            ,message = "ngoại trừ dấu phẩy các kí tự đặc biệt khác không được phép")
    @Max(value = 1000,message = "khong vuot qua 1000 ki tu")
    @NotEmpty(message = "Không được phép để trống")
    private String theLoai;

    public BaiHat(Long id, String ten, String ngheSiTheHien, String theLoai) {
        this.id = id;
        this.ten = ten;
        this.ngheSiTheHien = ngheSiTheHien;
        this.theLoai = theLoai;
    }

    public BaiHat(String ten, String ngheSiTheHien, String theLoai) {
        this.ten = ten;
        this.ngheSiTheHien = ngheSiTheHien;
        this.theLoai = theLoai;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgheSiTheHien() {
        return ngheSiTheHien;
    }

    public void setNgheSiTheHien(String ngheSiTheHien) {
        this.ngheSiTheHien = ngheSiTheHien;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public BaiHat() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
