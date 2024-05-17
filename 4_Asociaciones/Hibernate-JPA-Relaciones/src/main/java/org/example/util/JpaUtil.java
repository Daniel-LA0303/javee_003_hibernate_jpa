package org.example.util;

/*
esta clase es para crear el entity manager factory
el cual es el encargado de crear los entity manager que son
los que se encargan de hacer las operaciones con la base de datos
*/

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

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