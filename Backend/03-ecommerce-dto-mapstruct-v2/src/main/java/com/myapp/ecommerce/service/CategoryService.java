package com.myapp.ecommerce.service;

import com.myapp.ecommerce.dto.CategoryDTO;
import com.myapp.ecommerce.entity.ProductCategory;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryById(int theId);

}
