package com.myapp.ecommerce.service;

import com.myapp.ecommerce.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    List<CategoryDTO> getAllCategoriesWithProducts();

    CategoryDTO getCategoryWithProductsById(int theId);

//    CategoryDTO getCategoryWithProductsRangeById(int theId);

}
