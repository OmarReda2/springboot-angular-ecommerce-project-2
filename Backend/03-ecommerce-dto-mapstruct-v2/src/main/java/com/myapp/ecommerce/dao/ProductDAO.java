package com.myapp.ecommerce.dao;

import com.myapp.ecommerce.entity.Product;
import com.myapp.ecommerce.entity.ProductCategory;

import java.util.List;

public interface ProductDAO {
    List<Product> findAllProducts();

    Product findProductById(int theId);

    List<Product> findProductByName(String theName);

    Long countProducts();

    List<Product> getRangedProductsWithCategoryId(int theId, int size, int start);


}
