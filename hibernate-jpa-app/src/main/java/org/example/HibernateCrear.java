package org.example;

import jakarta.persistence.EntityManager;
import org.example.entity.Cliente;
import org.example.util.JpaUtil;

import javax.swing.*;

public class HibernateCrear {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {

            String nombre = JOptionPane.showInputDialog("Ingrese nombre");
            String apellido = JOptionPane.showInputDialog("Ingrese apellido");
            String formaPago = JOptionPane.showInputDialog("Ingrese forma de pago");

            //para crear un cliente empezamos una transaccion
            entityManager.getTransaction().begin();
            Cliente cliente = new Cliente(nombre, apellido, formaPago);
            entityManager.persist(cliente); //esto guarda el cliente en la base de datos

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }
}
