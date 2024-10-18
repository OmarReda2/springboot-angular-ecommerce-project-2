package com.myapp.ecommerce.dao;

import com.myapp.ecommerce.entity.ProductCategory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO{

    EntityManager entityManager;
    CategoryDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }




    @Override
    public List<ProductCategory> getAllCategories() {

        TypedQuery<ProductCategory> query = entityManager.createQuery("From ProductCategory",ProductCategory.class);

        List<ProductCategory> categories = query.getResultList();

        return categories;
    }


}
