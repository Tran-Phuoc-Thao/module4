package com.example.blog.service;

import com.example.blog.entity.Blog;
import com.example.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable, String searchName) {
        return blogRepository.findAllBlog(pageable,searchName);
    }

    @Override
    public List<Blog> findByAuthor(String author) {
        return blogRepository.findByAuthor(author) ;
    }

    @Override
    public List<Blog> findAllByAuthorContaining(String author) {
        return blogRepository.findAllByAuthorContainingIgnoreCase(author);
    }

    @Override
    public Page<Blog> findAllByAuthor(Pageable pageable, String searchName) {
        return blogRepository.findAllByAuthor(pageable,searchName);
    }


}
