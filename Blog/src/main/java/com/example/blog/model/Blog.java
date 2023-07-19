package com.example.blog.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String content;

//    public Set<Content> getContentSet() {
//        return contentSet;
//    }
//
//    public void setContentSet(Set<Content> contentSet) {
//        this.contentSet = contentSet;
//    }
//
//    @ManyToMany
//    @JoinTable(name = "Blog_content")
//    @JoinColumn(columnDefinition ="content_id",referencedColumnName = "content_id")
//    private Set<Content> contentSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    private String description;
    private String date;

    private String image;


    public Blog(BlogBuilder blogBuilder) {
        this.id = id;
        this.name = blogBuilder.name;
        this.content = content;
        this.description = blogBuilder.description;
        this.date = date;
        this.image = blogBuilder.image;
    }

    public Blog(){
    }

    public static class BlogBuilder {
        private String name;
        private String description;
        private String image;

        public BlogBuilder(String name) {
            this.name = name;
        }

        public BlogBuilder description(String description) {
            this.description = description;
            return this;
        }

        public BlogBuilder image(String image) {
            this.image = image;
            return this;
        }

        public Blog build() {
            return new Blog(this);
        }
    }


}
