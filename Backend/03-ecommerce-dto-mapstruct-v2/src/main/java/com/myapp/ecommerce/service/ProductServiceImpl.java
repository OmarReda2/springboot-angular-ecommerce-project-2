package com.myapp.ecommerce.service;

import com.myapp.ecommerce.dao.ProductDAO;
import com.myapp.ecommerce.dto.ProductDTO;
import com.myapp.ecommerce.dto.ProductMapper;
import com.myapp.ecommerce.entity.Product;
import com.myapp.ecommerce.handler.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;
    private ProductMapper mapper;

    @Autowired
    public ProductServiceImpl(ProductDAO theProductDAO,
                              ProductMapper theMapper){
        productDAO = theProductDAO;
        mapper = theMapper;
    }







//    @Override
//    public List<ProductDto> findAllProducts() {
//
//        List<Product> products = productDAO.findAllProducts();
//        List<ProductDto> productDto = new ArrayList<>();
//
//        for(Product tempProduct : products){
//            productDto.add(mapper.toProductDto(tempProduct));
//        }
//
//        return productDto;
//    }
    @Override
    public List<ProductDTO> findAllProducts() {

        List<Product> products = productDAO.findAllProducts();

        return products.stream()
                .map(p -> mapper.toProductDto(p))
                .collect(Collectors.toList());
    }




    @Override
    public ProductDTO findProductById(int theId) {

        try {

            Product theProduct = productDAO.findProductById(theId);
            return mapper.toProductDto(theProduct);

        }catch (RuntimeException exc){
            throw new ProductNotFoundException("Product Not Found with the Given ID: " + theId);

        }
    }







}
