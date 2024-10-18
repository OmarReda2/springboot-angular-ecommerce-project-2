package com.myapp.ecommerce.dto;

import com.myapp.ecommerce.entity.Product;
import com.myapp.ecommerce.entity.ProductCategory;

public class ProductMapper {
    public static ProductDTO toProductDTO(Product product){
        ProductDTO dto = new ProductDTO();
        dto.setName(product.getName());

        return dto;
    }

    public static ProductCategoryDTO toProductCategoryDTO(ProductCategory category){
        ProductCategoryDTO CatDto = new ProductCategoryDTO();
        CatDto.setCategoryName(category.getCategoryName());

        return CatDto;
    }


}
