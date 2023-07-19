package com.example.blog.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tieuDe;
    private String ghiChu;
    private String tacGia;

//    @ManyToMany(mappedBy = "blogset")
//    private Set<Blog> blogSet;
//
//    public Set<Blog> getBlogSet() {
//        return blogSet;
//    }
//
//    public void setBlogSet(Set<Blog> blogSet) {
//        this.blogSet = blogSet;
//    }

    public Content(int id, String tieuDe, String ghiChu, String tacGia) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.ghiChu = ghiChu;
        this.tacGia = tacGia;
    }

    public Content() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }
}
