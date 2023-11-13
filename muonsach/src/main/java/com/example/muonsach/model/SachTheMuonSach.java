package com.example.muonsach.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SachTheMuonSach {
    @Id
    private int idSachTheMuonSach;

    @OneToOne(mappedBy = "sachTheMuonSach")
    private Nguoi nguoi;

    @ManyToOne
    @JoinColumn(name = "idSach",referencedColumnName = "maSach")
    private Sach sach;

    @ManyToOne
    @JoinColumn(name = "idTheMuonSach",referencedColumnName = "idTheMuonSach")
    private TheMuonSach theMuonSach;

    public SachTheMuonSach() {}

    public SachTheMuonSach(int idSachTheMuonSach, Sach sach, TheMuonSach theMuonSach) {
        this.idSachTheMuonSach = idSachTheMuonSach;
        this.sach = sach;
        this.theMuonSach = theMuonSach;
    }

    public int getIdSachTheMuonSach() {
        return idSachTheMuonSach;
    }

    public void setIdSachTheMuonSach(int idSachTheMuonSach) {
        this.idSachTheMuonSach = idSachTheMuonSach;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public TheMuonSach getTheMuonSach() {
        return theMuonSach;
    }

    public void setTheMuonSach(TheMuonSach theMuonSach) {
        this.theMuonSach = theMuonSach;
    }
}
