package com.example.blogandcontent.service;

import com.example.blogandcontent.model.Content;
import com.example.blogandcontent.repository.IBlogRepository;
import com.example.blogandcontent.repository.IContentRepositpry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContentService implements IContentService{

    @Autowired
    private IContentRepositpry contentRepositpry;
    @Override
    public List<Content> findAll() {
        return contentRepositpry.findAll();
    }

    @Override
    public void add(Content content) {
        contentRepositpry.save(content);
    }
}
