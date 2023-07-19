package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/Blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Value("${upload.path}")
    private String fileUpload;

    @GetMapping
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("index");
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        modelAndView.addObject("BlogList", blogs);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("Blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public RedirectView createProduct(@ModelAttribute BlogForm Blog){
        Blog product1 = new Blog.BlogBuilder(Blog.getName())
                .description(Blog.getDescription()).build();
        MultipartFile multipartFile = Blog.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(Blog.getImage().getBytes(), new File(this.fileUpload));
        } catch (IOException e) {
            e.printStackTrace();
        }
        product1.setImage(fileName);
        blogService.save(product1);
        return new RedirectView("");
    }

}
