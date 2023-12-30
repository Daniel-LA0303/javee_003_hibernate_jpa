package org.example;

import jakarta.persistence.EntityManager;
import org.example.entity.Cliente;
import org.example.util.JpaUtil;

import java.util.List;

public class HibernateListar {

    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();
        //esto es para hacer una consulta a la base de datos donde c es el alias de la tabla clientes
        //Esto significa que las capas son las siguientes consulta -> entity manager -> entity -> base de datos
        List<Cliente> clientes = entityManager.createQuery("select c from Cliente c", Cliente.class).getResultList();
        clientes.forEach(System.out::println);
        entityManager.close();
    }
}
