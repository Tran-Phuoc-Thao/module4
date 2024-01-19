package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Blog/api")

public class Rest {
    @Autowired
    private BlogService blogService;
    @GetMapping("/search")
    public ResponseEntity<List<Blog>> searchByName(@RequestParam("author") String author) {
        return new ResponseEntity<>(blogService.findAllByAuthorContaining(author), HttpStatus.OK);
    }

    @GetMapping("/search1")
    public ResponseEntity<Page<Blog>> searchByName(@RequestParam("searchName") String searchName,
                                                   @RequestParam(defaultValue = "0") int page,ModelMap model) {
        Pageable pageable = PageRequest.of(page,5,Sort.by("id"));
        Page<Blog> blogPage = blogService.findAll(pageable,"%"+searchName+"%");
        model.addAttribute("blogList", blogPage);
        model.addAttribute("searchName", searchName);
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

}
