package com.controller;

import com.model.File;
import com.service.FileUploadService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileReader;
import java.io.IOException;

@Controller
@RequestMapping("/Upload")
public class FileController {
    @Autowired
    FileUploadService fileUploadService;
    @ModelAttribute("typeList")
    public String[] typeList(){
        return new String[]{"Pop","Rock","đồng quê","EDM","Jazz","Blues"};
    }
    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("song",new File());
        return "index";
    }

    @PostMapping("")
    public ModelAndView upload(@ModelAttribute File song) throws IOException {
        ModelAndView modelAndView = new ModelAndView("view");
        fileUploadService.uploadFile(song.getMultipartFile());
        modelAndView.addObject("result",song);

        ClassLoader classLoader = getClass().getClassLoader();
        String path  = classLoader.getResource(song.getMultipartFile().getOriginalFilename()).getPath();
        modelAndView.addObject("duongDan",path);

        return modelAndView;
    }

}
