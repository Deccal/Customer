package com.ozgurozturk;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Ozgur on 6.06.2017.
 */

@Repository
//@ Transactional ile entityManager ile transation begin ve commit e gerek kalmaz
@Transactional
//Transaction lazım olmayan methodlar varsa buraya değil,transaction kullanılacak methodlara yazılır
public class CustomRepository {


//    @PersistenceUnit
//    private EntityManagerFactory entityManagerFactory;

    //Bu sekilde direkt entityManager' e ulasabiliriz.
    @PersistenceContext
    private EntityManager entityManager;


    public void insertEmployee(Customer customer) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
        entityManager.persist(customer);
//        entityManager.getTransaction().commit();

    }
}
