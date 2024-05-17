package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.entity.Cliente;
import org.example.util.JpaUtil;

import java.util.Scanner;

public class HibernateWhere {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        EntityManager entityManager = JpaUtil.getEntityManager();

        Query query =  entityManager.createQuery("select c from Cliente c where c.formaPago=?1", Cliente.class);
        String formaPago =  s.nextLine();
        query.setParameter(1, formaPago); //busca por el parametro formaPago
        Cliente cliente = (Cliente) query.getSingleResult();
        System.out.println(cliente.toString());



        //por id
        System.out.println("Ingrese id");
        Long id = s.nextLong();
        Cliente cliente1 = entityManager.find(Cliente.class, id);
        System.out.println(cliente1.toString());


        entityManager.close();
    }
}
