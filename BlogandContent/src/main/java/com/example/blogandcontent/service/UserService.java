package com.example.blogandcontent.service;

import com.example.blogandcontent.model.User;
import com.example.blogandcontent.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;


    @Override
    public List<User> findAll() {
        return  userRepository.findAll();
    }

    @Override
    public Page<User> findAll(Pageable pageable, String lastName) {
        return userRepository.findStudent(lastName,pageable);
    }


    @Override
    public boolean add(User user) {
        User user1 =userRepository.save(user);
        return user1!=null;
    }
}
