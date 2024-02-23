package com.example.validatebaihat.controller;

import com.example.validatebaihat.entity.BaiHat;
import com.example.validatebaihat.service.baiHatService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/baiHat")
@Controller
public class baiHatController {
    @Autowired
    private baiHatService service;
    @ModelAttribute("baiHat")
    public BaiHat product(){
        return new BaiHat();
    }
    @GetMapping("")
    public String showList(ModelMap model) {
        List<BaiHat> list = service.findAll();
        model.addAttribute("ListBH", list);
        return "list";
    }


    @GetMapping(value = "/create")
    public String showForm(Model model) {
        return "create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute BaiHat baiHat, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "create";
        }
        service.save(baiHat);
        return "redirect:/baiHat";
    }
}
