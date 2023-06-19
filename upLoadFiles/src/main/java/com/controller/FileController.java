package com.controller;

import com.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Upload")
public class FileController {
    @Autowired
    FileUploadService fileUploadService;

    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("typeList",new String[]{"Pop","Rock","đồng quê","EDM","Jazz","Blues"});
        return "index";
    }
}
