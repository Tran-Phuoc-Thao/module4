package com.example.blogandcontent.repository;

import com.example.blogandcontent.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IUserRepository extends JpaRepository<User,Integer> {
    @Query(value = "select * from user where last_name like :last_name",nativeQuery = true)
    Page<User> findStudent(@Param("last_name") String last_name,Pageable pageable);
}
