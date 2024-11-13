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
@RequestMapping("/api")
@CrossOrigin
public class CategoryRestController {

    CategoryService categoryService;

    @Autowired
    CategoryRestController(CategoryService theCategoryService){
        categoryService = theCategoryService;
    }





    // retrieve only categories
    @GetMapping("/findAllCategory")
    public ResponseEntity<Object> getAllCategories(){

        List<CategoryDTO> category = categoryService.getAllCategories();

//        return ResponseHandler.generateNamedResponse(HttpStatus.OK, category, category.size(),"categories");
        return ResponseHandler.generateNamedResponse(HttpStatus.OK, category, "categories");

    }






    // retrieve category and its associated products
    @GetMapping("/findAllCategoryWithProducts")
    public ResponseEntity<Object> getAllCategoriesWithProducts(){

        List<CategoryDTO> category = categoryService.getAllCategoriesWithProducts();

//        return ResponseHandler.generateNamedResponse(HttpStatus.OK, category, category.size(), "categories");
        return ResponseHandler.generateNamedResponse(HttpStatus.OK, category, "categories");
    }






//    @GetMapping("/findByCategoryId/{theId}")
//    public ResponseEntity<Object> getCategoryById(@PathVariable int theId){
    @GetMapping("/products/search/findByCategoryId")
    public ResponseEntity<Object> getCategoryById(@RequestParam("id") int theId){

        CategoryDTO category = categoryService.getCategoryWithProductsById(theId);

//        return ResponseHandler.generateResponse(HttpStatus.OK, category, 1);
        return ResponseHandler.generateResponse(HttpStatus.OK, category);

    }
}
