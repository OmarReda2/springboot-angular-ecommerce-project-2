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
    @Mapping(source = "id", target = "id")
    @Mapping(source = "imageUrl", target = "imageUrl")
    @Mapping(source = "active", target = "active")
    @Mapping(source = "dateCreated", target = "dateCreated")
    @Mapping(source = "lastUpdated", target = "lastUpdated")
    @Mapping(source = "category", target = "category") // Nested mapping
    @Mapping(target = "category.products", ignore = true) // Prevent accessing products during mapping
    ProductDTO toProductDto(Product product);


}
