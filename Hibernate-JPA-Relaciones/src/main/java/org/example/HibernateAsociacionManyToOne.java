package org.example;

import jakarta.persistence.EntityManager;
import org.example.entity.Cliente;
import org.example.entity.Factura;
import org.example.util.JpaUtil;

public class HibernateAsociacionManyToOne {

    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            Cliente cliente = new Cliente("Juan", "Perez", "Efectivo");
            cliente.setFormaPago("Efectivo");
            entityManager.persist(cliente);

            Factura factura = new Factura("Compra de celular", 1000L);
            factura.setCliente(cliente);
            entityManager.persist(factura);


            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

    }
}
