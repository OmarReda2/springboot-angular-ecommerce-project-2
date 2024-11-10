package com.myapp.ecommerce.dao;

import com.myapp.ecommerce.entity.Product;
import com.myapp.ecommerce.entity.ProductCategory;
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


    public Long countProducts(){

        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT COUNT(*) " +
                   "FROM Product", Long.class);

        return query.getSingleResult();
    }



    @Override
    public List<Product> getRangedProductsWithCategoryId(int theId, int size , int start){
        TypedQuery<Product> query = entityManager.createQuery(
                "FROM Product WHERE category.id =: theData",
                Product.class);

        query.setFirstResult(start);
        query.setMaxResults(size);
        query.setParameter("theData", theId);

        return query.getResultList();
    }
}
