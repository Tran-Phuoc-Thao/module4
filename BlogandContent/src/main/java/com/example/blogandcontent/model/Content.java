package com.example.blogandcontent.model;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ghiChu;

    public Content(int id, String ghiChu, Set<Blog> blog) {
        this.id = id;
        this.ghiChu = ghiChu;
        this.blogs = blog;
    }

    public Content(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @OneToMany(mappedBy = "content")
    private Set<Blog> blogs;

    public Content() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blog) {
        this.blogs = blog;
    }
}
