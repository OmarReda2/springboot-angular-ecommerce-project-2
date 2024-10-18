package com.myapp.ecommerce.dto;

import com.myapp.ecommerce.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDTO {
    private Long id;
    private String categoryName;
    private List<Product> products;

}
