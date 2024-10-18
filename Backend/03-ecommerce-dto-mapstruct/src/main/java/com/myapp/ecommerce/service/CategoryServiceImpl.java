package com.myapp.ecommerce.service;

import com.myapp.ecommerce.dao.CategoryDAO;
import com.myapp.ecommerce.dto.CategoryMapper;
import com.myapp.ecommerce.dto.ProductCategoryDTO;
import com.myapp.ecommerce.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    CategoryDAO categoryDAO;
    CategoryMapper mapper;

    @Autowired
    CategoryServiceImpl(CategoryDAO theCategoryDAO,
                        CategoryMapper theMapper){

        categoryDAO = theCategoryDAO;
        mapper = theMapper;
    }


    @Override
    public List<ProductCategoryDTO> getAllCategories() {
        List<ProductCategory> categories = categoryDAO.getAllCategories();

        List<ProductCategoryDTO> categoryDTOS = new ArrayList<>();

        for (ProductCategory tempCat: categories){
            categoryDTOS.add(mapper.toCategoryDTO(tempCat));
        }

        return categoryDTOS;
    }
}
