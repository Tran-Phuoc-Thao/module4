package com.example.blog.controller;


import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.BeanUtils;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/Blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;


    @ModelAttribute("blog")
    public Blog blog(){
        return new Blog();
    }

    @ModelAttribute("categoryList")
    public List<Category> categoryList(){
        List<Category> list1 = categoryService.findAll();
        return list1;
    }
    @GetMapping("")
    public String showPage(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "")String searchName,
                           ModelMap model) {
        Pageable pageable = PageRequest.of(page,5,Sort.by("id"));
        Page<Blog> blogPage = blogService.findAll(pageable,"%"+searchName+"%");
        model.addAttribute("blogList", blogPage);
        model.addAttribute("searchName", searchName);
        return "list";
    }

    @GetMapping(value = "/createBlog")
    public String showForm(Model model) {
        return "create";
    }

    @PostMapping("/createBlog")
    public String saveBlog(@Valid @ModelAttribute Blog blog,BindingResult bindingResult){
        blog.validate(blog,bindingResult);
        if (bindingResult.hasErrors()){
            return "create";
        }
        blogService.saveBlog(blog);
        return "redirect:/Blog";
    }

    @GetMapping("/detail")
    public String showDetail(Model model, @RequestParam("id") int id){
        Blog blog = blogService.findById(id);
        model.addAttribute("blogDetail",blog);
        return "detail";
    }

    @GetMapping("/list")
    public String showList(Model model){
        List<Blog> list = blogService.findAll();
        model.addAttribute("blogList",list);
        return "listNormal";
    }
    @GetMapping("/search")
    public String search(@RequestParam("searchName") String searchName,
                       @RequestParam(defaultValue = "0") int page,ModelMap model){
        Pageable pageable = PageRequest.of(page,5,Sort.by("id"));
        Page<Blog> blogPage = blogService.findAll(pageable,"%"+searchName+"%");
        model.addAttribute("blogList", blogPage);
        model.addAttribute("searchName", searchName);
        return "list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id){
        return "redirect:/Blog";
    }
}
