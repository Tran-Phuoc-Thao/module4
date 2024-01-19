package com.example.blog.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Blog implements Validator {

    //    @Pattern(regexp = "B[d]{4}", message = "BookId phải có dạng Bxxxx")
//    @Pattern(regexp = "B[d]{4}", message = "{Book.bookID}")
//    @Size(min = 5, max = 5, message = "{Book.bookID.length}")


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @NotEmpty
    private String title;
    @Size(min=2,max=10)
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;

    public Blog(int id, String title, String author, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public Blog(String title, String author, Category category) {
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public Blog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Blog)) {
            return;
        }

        Blog blog = (Blog) target;

        if (blog.getTitle().isEmpty()) {
            errors.rejectValue("title", null, "title khong duoc de trong");}
//        } else if (!bookId.matches("B[0-9]{3}")) {
//            errors.rejectValue("bookId", "Book.bookID",
//                    null, "Book ID phải đúng định dạng");
//        } else if (bookService.findById(bookId) != null) {
//            errors.rejectValue("bookId", "Book.exist",
//                    null, "Book ID đã tồn tại");
//        }
    }
}
