package com.example.muonsach.model;

import javax.persistence.*;
import java.util.Set;

//@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
@Entity
public class TheMuonSach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTheMuonSach;
    private String ngayMuon;
    private String ngayTra;

    @OneToOne(mappedBy = "theMuonSach")
    private Nguoi nguoi;

    @OneToMany(mappedBy = "theMuonSach")
    private Set<TheMuonSach> theMuonSachSet;

    public TheMuonSach(int idTheMuonSach, String ngayMuon, String ngayTra, Nguoi nguoi, Set<TheMuonSach> theMuonSachSet) {
        this.idTheMuonSach = idTheMuonSach;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.nguoi = nguoi;
        this.theMuonSachSet = theMuonSachSet;
    }

    public TheMuonSach() {

    }

    public int getIdTheMuonSach() {
        return idTheMuonSach;
    }

    public void setIdTheMuonSach(int idTheMuonSach) {
        this.idTheMuonSach = idTheMuonSach;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public Nguoi getNguoi() {
        return nguoi;
    }

    public void setNguoi(Nguoi nguoi) {
        this.nguoi = nguoi;
    }

    public Set<TheMuonSach> getTheMuonSachSet() {
        return theMuonSachSet;
    }

    public void setTheMuonSachSet(Set<TheMuonSach> theMuonSachSet) {
        this.theMuonSachSet = theMuonSachSet;
    }
}
