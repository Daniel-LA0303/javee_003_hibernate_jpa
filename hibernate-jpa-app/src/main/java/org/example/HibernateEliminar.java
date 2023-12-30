package org.example;

import jakarta.persistence.EntityManager;
import org.example.entity.Cliente;
import org.example.util.JpaUtil;

import java.util.Scanner;

public class HibernateEliminar {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese id");

        Long id = s.nextLong();

        EntityManager entityManager = JpaUtil.getEntityManager();

        try{
            Cliente cliente = entityManager.find(Cliente.class, id);
            entityManager.getTransaction().begin();
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
            System.out.println("Cliente eliminado" + cliente.toString());
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }
}
