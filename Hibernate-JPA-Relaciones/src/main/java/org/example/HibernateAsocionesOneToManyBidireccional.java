package org.example;

import jakarta.persistence.EntityManager;
import org.example.entity.Cliente;
import org.example.entity.Factura;
import org.example.util.JpaUtil;

public class HibernateAsocionesOneToManyBidireccional {

    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();

            //Bidirecional
            //1. Creamos el cliente
            Cliente cliente = new Cliente("Juan", "Perez", "Efectivo");
            cliente.setFormaPago("Efectivo");
            entityManager.persist(cliente);

            //2. Creamos la factura
            Factura factura = new Factura("Compra de celular", 1000L);
            Factura factura2 = new Factura("Compra de celular", 1000L);
            Factura factura3 = new Factura("Compra de celular", 1000L);

            cliente.getFacturas().add(factura);
            cliente.getFacturas().add(factura2);
            cliente.getFacturas().add(factura3);

            factura.setCliente(cliente);
            factura2.setCliente(cliente);
            factura3.setCliente(cliente);

            entityManager.persist(cliente);

            //3. Agregamos la factura al cliente
            cliente.getFacturas().add(factura);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
}
