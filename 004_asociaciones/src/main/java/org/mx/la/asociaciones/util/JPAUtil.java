package org.mx.la.asociaciones.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {


    // Crea y almacena una única instancia de EntityManagerFactory
    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    // Método que construye y devuelve la instancia de EntityManagerFactory
    private static EntityManagerFactory buildEntityManagerFactory(){
        // Crea la EntityManagerFactory basada en la unidad de persistencia definida en persistence.xml
        return Persistence.createEntityManagerFactory("ejemploJPA");
    }

    // Método que proporciona una nueva instancia de EntityManager
    public static EntityManager getEntityManager() {
        // Crea y devuelve un nuevo EntityManager desde la EntityManagerFactory
        return entityManagerFactory.createEntityManager();
    }
}
