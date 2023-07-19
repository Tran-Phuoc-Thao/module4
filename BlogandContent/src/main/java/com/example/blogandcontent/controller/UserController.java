package com.example.blogandcontent.controller;

import com.example.blogandcontent.dto.UserDto;
import com.example.blogandcontent.model.Blog;
import com.example.blogandcontent.model.Content;
import com.example.blogandcontent.model.User;
import com.example.blogandcontent.service.IBlogService;
import com.example.blogandcontent.service.IContentService;
import com.example.blogandcontent.service.IUserService;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IBlogService blogService;
    @Autowired
    private IContentService contentService;

    @ModelAttribute("blogList")
    public List<Blog> showList(){
        List<Blog> list = blogService.findAll();
        return list;
    }
    @ModelAttribute("contentList")
    public List<Content> showList1(){
        List<Content> list1 = contentService.findAll();
        return list1;
    }
    @ModelAttribute("content")
    public Content show(){
        return new Content();
    }


    @GetMapping("")
    public String showPage(){
        return "home";
    }
    @GetMapping("/show")
    public String showPage(@RequestParam(defaultValue = "0") int page ,
                           @RequestParam(defaultValue = "")String searchName,
                           ModelMap model) {
        Pageable pageable = PageRequest.of(page,5,Sort.by("last_name"));
        Page<User> userList = userService.findAll(pageable,"%"+searchName+"%");
        model.addAttribute("userList", userList);
        model.addAttribute("searchName", searchName);
        return "home";
    }

    @GetMapping(value = "/createUser")
    public String showFormAdd(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "createUser";
    }

    @PostMapping("/createUser")
    public String saveUser(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        // copy studentDto => student
        new UserDto().validate(userDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "createUser";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userService.add(user);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/user";
    }

    @GetMapping(value = "/createBlog")
    public String showForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "createBlog";
    }
    @PostMapping("/createBlog")
    public String saveBlog(@ModelAttribute Blog blog,@ModelAttribute Content content) {
        blogService.add(blog);
        return "redirect:/user";
    }

    @GetMapping(value = "/createContent")
    public String showContent(Model model) {
//        model.addAttribute("content", new Content());
        return "blogs";
    }

    @PostMapping("/createContent")
    public String saveContent(@ModelAttribute Content content) {
        contentService.add(content);
        return "redirect:/user";
    }

}
