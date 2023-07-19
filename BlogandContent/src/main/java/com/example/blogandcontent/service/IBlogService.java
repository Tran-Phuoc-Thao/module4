package com.example.blogandcontent.service;

import com.example.blogandcontent.model.Blog;
import com.example.blogandcontent.model.User;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void add(Blog blog);
}
