package com.myapp.ecommerce.service;

import com.myapp.ecommerce.dao.CategoryDAO;
import com.myapp.ecommerce.dao.ProductDAO;
import com.myapp.ecommerce.dto.ProductDTO;
import com.myapp.ecommerce.dto.ProductMapper;
import com.myapp.ecommerce.entity.Product;
import com.myapp.ecommerce.handler.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;
    private ProductMapper mapper;

    @Autowired
    public ProductServiceImpl(ProductDAO theProductDAO,
                              CategoryDAO CategoryDAO,
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





    @Override
    @Transactional
    public List<ProductDTO> findProductByName(String theName){

        try{
            List<Product> products = productDAO.findProductByName(theName);
            return products.stream()
                            .map(p -> mapper.toProductDto(p))
                            .collect(Collectors.toList());

        }catch (RuntimeException exc){
            throw new ProductNotFoundException("Products Not Found with the Given Name: " + theName);
        }
    }



    @Override
    public List<ProductDTO> findSelectedProductsForPagination(int theId, int size , int start){

        start = (start-1) * size + 1;

        List<Product> selectedProducts = productDAO.getRangedProductsWithCategoryId(theId, size, start);

        return selectedProducts.stream()
                                .map(p -> mapper.toProductDto(p))
                                .collect(Collectors.toList());
    }



    @Override
    public HashMap<String, Integer> paginationInfo(int theId, int theSize, int number){

        int totalElements = Math.toIntExact(productDAO.countProductsForCategory(theId));
        int totalPages = (int) Math.ceil(totalElements / (double)theSize);
//        int start = (theStart-1) * size + 1;

        HashMap<String, Integer> map = new HashMap<>();
        map.put("totalElements", totalElements);
        map.put("totalPages", totalPages);
        map.put("size", theSize);
        map.put("number", number);

        return map;
    }






}
