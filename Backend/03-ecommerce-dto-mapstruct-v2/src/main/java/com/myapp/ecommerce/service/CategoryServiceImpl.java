package com.myapp.ecommerce.service;

import com.myapp.ecommerce.dao.CategoryDAO;
import com.myapp.ecommerce.dto.CategoryDTO;
import com.myapp.ecommerce.dto.CategoryMapper;
import com.myapp.ecommerce.entity.ProductCategory;
import com.myapp.ecommerce.handler.exception.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<CategoryDTO> getAllCategories() {

        List<ProductCategory> category = categoryDAO.getAllCategories();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();

        for (ProductCategory tempCat: category){
            categoryDTOS.add(mapper.toCategoryDTO(tempCat));
        }

        return categoryDTOS;



    }

    @Override
    public CategoryDTO getCategoryById(int theId) {

        try {
            ProductCategory category = categoryDAO.getCategoryById(theId);
            return mapper.toCategoryDTO(category);
        }
        catch (RuntimeException exc){
            throw new CategoryNotFoundException("Category Not Found with the Given ID: " + theId);
        }
    }
}
