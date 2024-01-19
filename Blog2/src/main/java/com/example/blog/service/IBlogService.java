package com.example.blog.service;

import com.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService   {
    List<Blog> findAll();

    void saveBlog(Blog blog);

    Blog findById(int id);
    Page<Blog> findAll(Pageable pageable, String searchName);

    List<Blog> findByAuthor(String author);

    List<Blog> findAllByAuthorContaining(String author);

    Page<Blog> findAllByAuthor(Pageable pageable, String searchName);
}
