package com.example.validatebaihat.service;

import com.example.validatebaihat.entity.BaiHat;
import jakarta.validation.Valid;

import java.util.List;

public interface IbaiHatService {

    List<BaiHat> findAll();
    void save(BaiHat baiHat);
}
