package com.myapp.ecommerce.rest;

import com.myapp.ecommerce.dto.ProductDTO;
import com.myapp.ecommerce.handler.ResponseHandler;
import com.myapp.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
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

        List<ProductDTO> data = productService.findAllProducts();
        return ResponseHandler.generateNamedResponse(HttpStatus.OK, data, data.size(), "products");
    }


    @GetMapping("/products/{theId}")
    public  ResponseEntity<Object> getProductById(@PathVariable int theId){

        ProductDTO data = productService.findProductById(theId);

        Object products = new Object();

        return ResponseHandler.generateResponse(HttpStatus.OK, data, 1);
    }

}
