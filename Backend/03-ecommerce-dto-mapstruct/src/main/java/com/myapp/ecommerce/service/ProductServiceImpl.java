package com.myapp.ecommerce.service;

import com.myapp.ecommerce.dao.ProductDAO;
import com.myapp.ecommerce.dto.ProductDto;
import com.myapp.ecommerce.dto.ProductMapper;
import com.myapp.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public List<ProductDto> findAllProducts() {

        List<Product> products = productDAO.findAllProducts();
        System.out.println(products.getFirst());
        return products.stream()
                .map(p -> mapper.toProductDto(p))
                .collect(Collectors.toList());
    }







//    @Override
//    public Product findProductById(int theId) {
//        return  productDAO.findProductById(theId);
//    }
//
//    @Override
//    @Transactional
//    public void addProduct(Product theProduct) {
//        productDAO.addProduct(theProduct);
//    }
//
//    @Override
//    @Transactional
//    public void deleteProduct(Product theProduct) {
//        productDAO.deleteProduct(theProduct);
//    }
//
//    @Override
//    @Transactional
//    public void updateProduct(Product theProduct) {
//        productDAO.updateProduct(theProduct);
//    }
}
