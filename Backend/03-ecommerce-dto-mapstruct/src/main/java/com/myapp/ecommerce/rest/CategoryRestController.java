package com.myapp.ecommerce.rest;

import com.myapp.ecommerce.dto.ProductCategoryDTO;
import com.myapp.ecommerce.dto.ProductDto;
import com.myapp.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryRestController {

    CategoryService categoryService;

    @Autowired
    CategoryRestController(CategoryService theCategoryService){
        categoryService = theCategoryService;
    }

    @GetMapping("/categories")
    public List<ProductCategoryDTO> getAllCategories(){

        return categoryService.getAllCategories();
    }
}
