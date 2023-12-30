package org.example;

import jakarta.persistence.EntityManager;
import org.example.entity.Cliente;
import org.example.util.JpaUtil;

import javax.swing.*;

public class HibernateEditar {

    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();

        try{
            //primero buscamos el cliente por id
            Long id = Long.parseLong(JOptionPane.showInputDialog("Ingrese id"));
            Cliente c = entityManager.find(Cliente.class, id);
            //procedemos a editar
            String nombre = JOptionPane.showInputDialog("Ingrese nombre", c.getNombre());
            String apellido = JOptionPane.showInputDialog("Ingrese apellido", c.getApellido());
            String formaPago = JOptionPane.showInputDialog("Ingrese forma de pago", c.getFormaPago());
            entityManager.getTransaction().begin();
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setFormaPago(formaPago);
            entityManager.merge(c); //actualiza el cliente
            entityManager.getTransaction().commit();
            System.out.println("Cliente actualizado" + c.toString());
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }
}
