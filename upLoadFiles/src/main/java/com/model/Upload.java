package com.model;

import org.springframework.web.multipart.MultipartFile;

public class Upload {
    private String ten;
    private String ngheSi;
    private String theLoai;
    private MultipartFile multipartFile;

    public Upload(String ten, String ngheSi, String theLoai, MultipartFile multipartFile) {
        this.ten = ten;
        this.ngheSi = ngheSi;
        this.theLoai = theLoai;
        this.multipartFile = multipartFile;
    }

    public Upload() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgheSi() {
        return ngheSi;
    }

    public void setNgheSi(String ngheSi) {
        this.ngheSi = ngheSi;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
