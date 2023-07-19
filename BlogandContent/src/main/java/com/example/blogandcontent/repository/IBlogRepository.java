package com.example.blogandcontent.repository;

import com.example.blogandcontent.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
}
