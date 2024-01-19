package com.example.blog.repository;

import com.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Integer> {

    @Query(value = "select * from blog where author like :searchName",nativeQuery = true)
    Page<Blog> findAllBlog(Pageable pageable,@Param("searchName") String searchName);

    @Query(value = "select * from blog where author like :author",nativeQuery = true)
    List<Blog> findByAuthor(@Param("author") String author);

    List<Blog> findAllByAuthorContainingIgnoreCase(String author);

    Page<Blog> findAllByAuthor(Pageable pageable,String author);
}
