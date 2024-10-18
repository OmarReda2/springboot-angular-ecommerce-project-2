package com.myapp.ecommerce.service;

import com.myapp.ecommerce.dao.ProductDAO;
import com.myapp.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO theProductDAO){
        productDAO = theProductDAO;
    }

    @Override
    public List<Product> findAllProducts() {

        return productDAO.findAllProducts();
    }

    @Override
    public Product findProductById(int theId) {
        return  productDAO.findProductById(theId);
    }

    @Override
    @Transactional
    public void addProduct(Product theProduct) {
        productDAO.addProduct(theProduct);
    }

    @Override
    @Transactional
    public void deleteProduct(Product theProduct) {
        productDAO.deleteProduct(theProduct);
    }

    @Override
    @Transactional
    public void updateProduct(Product theProduct) {
        productDAO.updateProduct(theProduct);
    }
}
