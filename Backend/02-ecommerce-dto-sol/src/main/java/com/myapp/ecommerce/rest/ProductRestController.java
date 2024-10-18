package com.myapp.ecommerce.rest;

import com.myapp.ecommerce.dto.ProductDTO;
import com.myapp.ecommerce.entity.Product;
import com.myapp.ecommerce.service.ProductService;
import com.myapp.ecommerce.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public ProductRestController (ProductService theProductService){
        productService = theProductService;
    }

    @GetMapping("/products")
    public List<ProductDTO> getAllProducts(){
        return productService.findAllProducts();
    }
}
