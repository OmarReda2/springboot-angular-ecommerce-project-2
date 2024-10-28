package com.myapp.ecommerce.dao;

import com.myapp.ecommerce.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{
    private EntityManager entityManager;


    @Autowired
    public ProductDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }





    @Override
    public Product findProductById(int theId) {
        TypedQuery<Product> query = entityManager.createQuery("FROM Product " +
                                                                 "WHERE id =: theData", Product.class);

        query.setParameter("theData", theId);
        return query.getSingleResult();
    }





    @Override
    public List<Product> findAllProducts() {

        TypedQuery<Product> query = entityManager.createQuery(
                                        "From Product", Product.class);

        List<Product> products = query.getResultList();

        return products;
    }


    @Override
    public List<Product> findProductByName(String theName){
        TypedQuery<Product> query = entityManager.createQuery("FROM Product " +
                                                                 "WHERE name " +
                                                                 "LIKE CONCAT('%', :theData, '%')"
                                                                , Product.class);

        query.setParameter("theData", theName);

        return query.getResultList();
    }


//    @Override
//    public Product findProductById(int theId) {
//        Product theProduct = entityManager.find(Product.class, theId);
//        return  theProduct;
//    }
//
//    @Override
//    public void addProduct(Product theProduct) {
//        entityManager.persist(theProduct);
//    }
//
//    @Override
//    public void deleteProduct(Product theProduct) {
//        entityManager.remove(theProduct);
//    }
//
//    @Override
//    public void updateProduct(Product theProduct) {
//        entityManager.merge(theProduct);
//    }
}
