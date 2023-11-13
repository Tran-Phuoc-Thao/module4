package com.example.muonsach.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Sach {
    @Id
    private String maSach;
    private String tenSach;
    private int soLuong;
    private String noiDung;

    @OneToMany(mappedBy = "sach")
    private Set<Sach> sachSet;

    public Sach() {

    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Set<Sach> getSachSet() {
        return sachSet;
    }

    public void setSachSet(Set<Sach> sachSet) {
        this.sachSet = sachSet;
    }

    public Sach(String maSach, String tenSach, int soLuong, String noiDung, Set<Sach> sachSet) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.noiDung = noiDung;
        this.sachSet = sachSet;
    }
}
