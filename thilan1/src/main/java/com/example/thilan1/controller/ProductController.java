package com.example.thilan1.controller;

import com.example.thilan1.entity.Product;
import com.example.thilan1.entity.ProductType;
import com.example.thilan1.service.ProductService;
import com.example.thilan1.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTypeService productTypeService;

    @ModelAttribute("product")
    public Product product(){
        return new Product();
    }

    @ModelAttribute("productTypeList")
    public List<ProductType> categoryList(){
        List<ProductType> list1 = productTypeService.findAll();
        return list1;
    }

    @GetMapping("")
    public String showPage(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "")String searchName,
                           @RequestParam(defaultValue = "")String searchPrice,
                           @RequestParam(defaultValue = "")String searchType,
                           ModelMap model) {
        Pageable pageable = PageRequest.of(page,5, Sort.by("name"));
        Page<Product> productPage = productService.findAll(pageable,"%"+searchName+"%","%"+searchPrice+"%","%"+searchType+"%");
        model.addAttribute("productList", productPage);
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchPrice", searchPrice);
        model.addAttribute("searchType", searchType);
        return "list";
    }

    @GetMapping(value = "/createProduct")
    public String showForm(Model model) {
        return "create";
    }

    @PostMapping("/createProduct")
    public String saveProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult){
        productService.saveProduct(product);
        return "redirect:/product";
    }


    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "0") int page,
                         @RequestParam(defaultValue = "")String searchName,
                         @RequestParam(defaultValue = "")String searchPrice,
                         @RequestParam(defaultValue = "")String searchType,
                         ModelMap model){
        Pageable pageable = PageRequest.of(page,5, Sort.by("name"));
        Page<Product> productPage = productService.findAll(pageable,"%"+searchName+"%","%"+searchPrice+"%","%"+searchType+"%");
        model.addAttribute("productList", productPage);
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchPrice", searchPrice);
        model.addAttribute("searchType", searchType);
        return "list";
    }

    @GetMapping("/update")
    public String showDetail(Model model, @RequestParam("id") int id){
       Product product = productService.findById(id);
       model.addAttribute("productUpdate",product);
        return "update";
    }

    @PostMapping("/update")
    public String updateProduct(@RequestParam("id") int id,
                                @RequestParam("name") String name,
                                @RequestParam("price") float price,
                                @RequestParam("productType") int productType)
    {
        Product product = new Product(id,name,price,"chờ duyệt",productTypeService.findById(id));
        productService.saveProduct(product);
        return "redirect:/product";
    }

    @RequestMapping("/delete")
    public String deleteProduct(@RequestParam("id")int id){
        productService.delete(id);
        return "redirect:/product";
    }


}
