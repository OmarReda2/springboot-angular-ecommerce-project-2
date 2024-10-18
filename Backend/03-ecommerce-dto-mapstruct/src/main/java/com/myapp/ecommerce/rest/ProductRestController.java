package com.myapp.ecommerce.rest;

import com.myapp.ecommerce.dto.ProductDto;
import com.myapp.ecommerce.entity.Product;
import com.myapp.ecommerce.handler.ResponseHandler;
import com.myapp.ecommerce.service.ProductService;
import com.myapp.ecommerce.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public ProductRestController (ProductService theProductService){
        productService = theProductService;
    }


//    @GetMapping("/products")
//    public List<ProductDto> getAllProducts(){
//        return productService.findAllProducts();
//    }
//
    @GetMapping("/products")
    public ResponseEntity<Object> getAllProducts(){

        List<ProductDto> data = productService.findAllProducts();
        return ResponseHandler.generateResponse(HttpStatus.OK, data, data.size());
    }

}
