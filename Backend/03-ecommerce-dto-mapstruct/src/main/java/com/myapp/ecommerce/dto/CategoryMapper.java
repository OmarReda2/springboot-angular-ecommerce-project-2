package com.myapp.ecommerce.dto;

import com.myapp.ecommerce.entity.ProductCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "categoryName", target = "categoryName")
    @Mapping(source = "products", target = "products")
    ProductCategoryDTO toCategoryDTO(ProductCategory category);
}
