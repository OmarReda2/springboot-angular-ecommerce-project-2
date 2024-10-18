package com.myapp.ecommerce.service;

import com.myapp.ecommerce.dto.ProductCategoryDTO;
import com.myapp.ecommerce.entity.ProductCategory;

import java.util.List;

public interface CategoryService {

    List<ProductCategoryDTO> getAllCategories();
}
