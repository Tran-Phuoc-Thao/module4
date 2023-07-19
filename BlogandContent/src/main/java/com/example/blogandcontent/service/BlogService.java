package com.example.blogandcontent.service;

import com.example.blogandcontent.model.Blog;
import com.example.blogandcontent.model.User;
import com.example.blogandcontent.repository.IBlogRepository;
import com.example.blogandcontent.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class BlogService implements IBlogService{

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void add(Blog blog) {
        blogRepository.save(blog);
    }
}
