package com.example.muonsach.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Nguoi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ten;

    @OneToOne()
    @JoinColumn(name = "theMuonSach_id", referencedColumnName = "idSachTheMuonSach",unique = true)
    private TheMuonSach theMuonSach;


    public Nguoi(int id, String ten, TheMuonSach theMuonSach) {
        this.id = id;
        this.ten = ten;
        this.theMuonSach = theMuonSach;
    }

    public Nguoi(String ten, TheMuonSach theMuonSach) {
        this.ten = ten;
        this.theMuonSach = theMuonSach;
    }

    public Nguoi() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public TheMuonSach getTheMuonSach() {
        return theMuonSach;
    }

    public void setTheMuonSach(TheMuonSach theMuonSach) {
        this.theMuonSach = theMuonSach;
    }
}
