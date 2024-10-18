package com.myapp.ecommerce.service;

import com.myapp.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();

    Product findProductById(int theId);

    void addProduct(Product theProduct);

    void deleteProduct(Product theProduct);

    void updateProduct(Product theProduct);
}
