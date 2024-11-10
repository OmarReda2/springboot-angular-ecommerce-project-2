package com.myapp.ecommerce.service;

import com.myapp.ecommerce.dto.ProductDTO;
import com.myapp.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAllProducts();

    ProductDTO findProductById(int theId);

    public List<ProductDTO> findProductByName(String theName);

    public List<ProductDTO> findSelectedProductsForPagination(int theId, int size , int start);

//    List<ProductDTO> findSelectedProductsForPagination();




//    void addProduct(Product theProduct);
//
//    void deleteProduct(Product theProduct);
//
//    void updateProduct(Product theProduct);
}
