package org.example;

import jakarta.persistence.EntityManager;
import org.example.entity.Cliente;
import org.example.entity.ClienteDetalle;
import org.example.util.JpaUtil;

public class HibernateAsociacionesOneToOne {

    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            //1. Creamos el cliente
            Cliente cliente = new Cliente("Sola", "Perez", "Efectivo");
            cliente.setFormaPago("Efectivo");
            entityManager.persist(cliente);

            //2. Creamos la cliente detalle
            ClienteDetalle clienteDetalle = new ClienteDetalle(true, 1222L);
            clienteDetalle.setCliente(cliente);
            entityManager.persist(clienteDetalle);



            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
}
