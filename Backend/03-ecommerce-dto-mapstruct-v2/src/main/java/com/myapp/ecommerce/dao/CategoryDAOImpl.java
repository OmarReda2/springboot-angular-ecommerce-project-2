package com.myapp.ecommerce.dao;

import com.myapp.ecommerce.entity.Product;
import com.myapp.ecommerce.entity.ProductCategory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    EntityManager entityManager;
    CategoryDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }




    @Override
    public List<ProductCategory> getAllCategoriesWithProducts() {

//        TypedQuery<ProductCategory> query = entityManager.createQuery("From ProductCategory",ProductCategory.class);

//        TypedQuery<ProductCategory> query = entityManager
//                .createQuery("SELECT new ProductCategory(c.id, c.categoryName) " +
//                                "FROM ProductCategory c " ,ProductCategory.class);

        TypedQuery<ProductCategory> query = entityManager.createQuery("SELECT c From ProductCategory c " +
                                                                         "JOIN FETCH c.products" ,ProductCategory.class);


        List<ProductCategory> categories = query.getResultList();

        return categories;
    }



    @Override
    public List<ProductCategory> getAllCategories() {

        TypedQuery<ProductCategory> query = entityManager
                .createQuery("SELECT new ProductCategory(c.id, c.categoryName) " +
                        "FROM ProductCategory c " ,ProductCategory.class);


        List<ProductCategory> categories = query.getResultList();


        return categories;
    }

    @Override
    public ProductCategory getCategoryWithProductsById(int theId) {
        TypedQuery<ProductCategory> query = entityManager.createQuery("FROM ProductCategory " +
                                                                         "WHERE id =: theData", ProductCategory.class);
        query.setParameter("theData", theId);

        return query.getSingleResult();
    }





}
