package com.example.blogandcontent.repository;

import com.example.blogandcontent.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContentRepositpry extends JpaRepository<Content,Integer> {

}
