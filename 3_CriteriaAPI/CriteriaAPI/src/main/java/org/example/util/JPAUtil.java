package org.example.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    //metodo para crear el entity manager factory
    private static EntityManagerFactory buildEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("example-hibernate-jpa");
    }

    //este metodo retorna un entity manager el cual es el mismo para todas las operaciones
    //por lo que es un singleton
    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

}
