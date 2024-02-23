package com.example.khuyenmai.controller;

import com.example.khuyenmai.entity.KhuyenMai;
import com.example.khuyenmai.service.KhuyenMaiService;
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
        Pageable pageable = PageRequest.of(page,3, Sort.by("title"));
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

    @PostMapping("/delete")
    public String deleteProduct(@ModelAttribute("id")int id){
        service.delete(id);
        return "redirect:/khuyenMai";
    }

    @PostMapping("/deleteCheckBox")
    public String delete(@RequestParam("idChecked") List<String> idDeletes){

        if(idDeletes != null){
            for(String idDeleteStr : idDeletes){
                int idDelete = Integer.parseInt(idDeleteStr);
                service.delete(idDelete);
            }
        }
        return "redirect:/khuyenMai";
    }

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "0") int page,
                         @RequestParam(defaultValue = "")String mucGiamGia,
                         @RequestParam(defaultValue = "")String ngayBatDau,
                         @RequestParam(defaultValue = "")String ngayKetThuc,
                         ModelMap model){
        Pageable pageable = PageRequest.of(page,3, Sort.by("title"));
        Page<KhuyenMai> khuyenMaiList = service.findAll(pageable,"%"+mucGiamGia+"%","%"+ngayBatDau+"%","%"+ngayKetThuc+"%");
        model.addAttribute("khuyenMaiList", khuyenMaiList);
        model.addAttribute("mucGiamGia", mucGiamGia);
        model.addAttribute("ngayBatDau", ngayBatDau);
        model.addAttribute("ngayKetThuc", ngayKetThuc);
        return "list";
    }
}
