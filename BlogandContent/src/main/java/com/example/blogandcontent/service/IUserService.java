package com.example.blogandcontent.service;

import com.example.blogandcontent.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IUserService {
    List<User> findAll();
    Page<User> findAll(Pageable pageable, String lastName);

    boolean add(User user);
}
