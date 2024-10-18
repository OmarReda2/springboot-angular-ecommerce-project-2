package com.myapp.ecommerce.dto;

import com.myapp.ecommerce.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "sku", target = "sku")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "unitPrice", target = "unitPrice")
    @Mapping(source = "unitsInStock", target = "unitsInStock")
//    @Mapping(source = "category", target = "category")  // Nested mapping
    ProductDto toProductDto(Product product);


}
