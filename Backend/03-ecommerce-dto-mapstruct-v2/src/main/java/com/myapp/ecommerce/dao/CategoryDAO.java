package com.myapp.ecommerce.dao;

import com.myapp.ecommerce.entity.ProductCategory;

import java.util.List;

public interface CategoryDAO {
    List<ProductCategory> getAllCategories();

    List<ProductCategory> getAllCategoriesWithProducts();

    ProductCategory getCategoryWithProductsById(int theId);




}
