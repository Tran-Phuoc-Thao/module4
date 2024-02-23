package com.example.validatebaihat.service;

import com.example.validatebaihat.entity.BaiHat;
import com.example.validatebaihat.repository.baiHatRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class baiHatService implements IbaiHatService{
    @Autowired
    private baiHatRepository repository;

    @Override
    public List<BaiHat> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(BaiHat baiHat) {
        repository.save(baiHat);

    }
}
