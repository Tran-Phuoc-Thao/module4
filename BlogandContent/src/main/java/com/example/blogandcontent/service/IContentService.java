package com.example.blogandcontent.service;

import com.example.blogandcontent.model.Blog;
import com.example.blogandcontent.model.Content;

import java.util.List;

public interface IContentService {
    List<Content> findAll();
    void add(Content content);
}
