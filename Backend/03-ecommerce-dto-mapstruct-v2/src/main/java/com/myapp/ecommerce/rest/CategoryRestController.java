package com.myapp.ecommerce.rest;

import com.myapp.ecommerce.dto.CategoryDTO;
import com.myapp.ecommerce.handler.ResponseHandler;
import com.myapp.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/search")
@CrossOrigin
public class CategoryRestController {

    CategoryService categoryService;

    @Autowired
    CategoryRestController(CategoryService theCategoryService){
        categoryService = theCategoryService;
    }

    @GetMapping("/findAllCategory")
    public ResponseEntity<Object> getAllCategories(){

        List<CategoryDTO> category = categoryService.getAllCategories();

        return ResponseHandler.generateResponse(HttpStatus.OK, category, category.size());
    }

//    @GetMapping("/findByCategoryId/{theId}")
//    public ResponseEntity<Object> getCategoryById(@PathVariable int theId){
    @GetMapping("/findByCategoryId")
    public ResponseEntity<Object> getCategoryById(@RequestParam("id") int theId){


        CategoryDTO category = categoryService.getCategoryById(theId);

        return ResponseHandler.generateResponse(HttpStatus.OK, category, 1);
    }
}
