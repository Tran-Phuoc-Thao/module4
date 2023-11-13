package com.example.demo.controller;

import com.example.demo.entity.KhuyenMai;
import com.example.demo.service.KhuyenMaiService;
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

import javax.validation.Valid;

@Controller
@RequestMapping("/khuyenMai")
public class KhuyenMaiController {
    @Autowired
    private KhuyenMaiService service;

    @ModelAttribute("khuyenMai")
    public KhuyenMai product(){
        return new KhuyenMai();
    }

    @GetMapping("")
    public String showPage(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "")String mucGiamGia,
                           @RequestParam(defaultValue = "")String ngayBatDau,
                           @RequestParam(defaultValue = "")String ngayKetThuc,
                           ModelMap model) {
        Pageable pageable = PageRequest.of(page,5, Sort.by("title"));
        Page<KhuyenMai> khuyenMaiList = service.findAll(pageable,"%"+mucGiamGia+"%","%"+ngayBatDau+"%","%"+ngayKetThuc+"%");
        model.addAttribute("khuyenMaiList", khuyenMaiList);
        model.addAttribute("mucGiamGia", mucGiamGia);
        model.addAttribute("ngayBatDau", ngayBatDau);
        model.addAttribute("ngayKetThuc", ngayKetThuc);
        return "list";
    }

    @GetMapping(value = "/create")
    public String showForm(Model model) {
        return "create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute KhuyenMai khuyenMai, BindingResult bindingResult){
        khuyenMai.validate(khuyenMai,bindingResult);
        if (bindingResult.hasErrors()){
            return "create";
        }
        service.save(khuyenMai);
        return "redirect:/khuyenMai";
    }

    @RequestMapping("/delete")
    public String deleteProduct(@RequestParam("id")int id){
        service.delete(id);
        return "redirect:/khuyenMai";
    }

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "0") int page,
                         @RequestParam(defaultValue = "")String mucGiamGia,
                         @RequestParam(defaultValue = "")String ngayBatDau,
                         @RequestParam(defaultValue = "")String ngayKetThuc,
                         ModelMap model){
        Pageable pageable = PageRequest.of(page,5, Sort.by("title"));
        Page<KhuyenMai> khuyenMaiList = service.findAll(pageable,"%"+mucGiamGia+"%","%"+ngayBatDau+"%","%"+ngayKetThuc+"%");
        model.addAttribute("khuyenMaiList", khuyenMaiList);
        model.addAttribute("mucGiamGia", mucGiamGia);
        model.addAttribute("ngayBatDau", ngayBatDau);
        model.addAttribute("ngayKetThuc", ngayKetThuc);
        return "list";
    }
}
