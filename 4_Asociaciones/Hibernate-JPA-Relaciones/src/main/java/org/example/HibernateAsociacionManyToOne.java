package org.example;

import jakarta.persistence.EntityManager;
import org.example.entity.Cliente;
import org.example.entity.Factura;
import org.example.util.JpaUtil;

import java.util.List;

public class HibernateAsociacionManyToOne {

    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            System.out.println("******* Creando un cliente con su factura *******");
            //creando cliente con factura
            Cliente cliente = new Cliente("Juan", "Perez", "Efectivo");
            cliente.setFormaPago("Efectivo");
            entityManager.persist(cliente);

            Factura factura = new Factura("Compra de celular", 1000L);
            factura.setCliente(cliente); //asociando factura con cliente
            entityManager.persist(factura);


            //consultando cliente junto con factura
            System.out.println("******* Consultando cliente junto con factura *******");
            Factura facturaDB = entityManager.find(Factura.class, factura.getId());
            Cliente clienteAsociado = facturaDB.getCliente();
            System.out.println("Factura: " + facturaDB); //trae factura y cliente

            //editando cliente
            clienteAsociado.setNombre("Juan Carlos");
            entityManager.merge(clienteAsociado);

            //editando factura
            facturaDB.setDescripcion("Compra de celular y accesorios");
            entityManager.merge(facturaDB);

            System.out.println("******* Editando cliente y factura *******");
            Factura facturaDB2 = entityManager.find(Factura.class, factura.getId());
            Cliente clienteAsociado2 = facturaDB.getCliente();
            System.out.println("Factura: " + facturaDB2); //trae factura y cliente

            //eliminando factura
            entityManager.remove(facturaDB2);
            System.out.println("******* Eliminando factura *******");

            System.out.println("******* Consultando cliente junto con factura como lista *******");
            //creandoi varios para una consulta de una lista
            Cliente cliente2 = new Cliente("Juan", "Perez", "Efectivo");
            cliente2.setFormaPago("Efectivo");
            entityManager.persist(cliente2);

            Factura factura2 = new Factura("Compra de celular", 1000L);
            factura2.setCliente(cliente2); //asociando factura con cliente
            entityManager.persist(factura2);

            Cliente cliente3 = new Cliente("Juan", "Perez", "Efectivo");
            cliente3.setFormaPago("Efectivo");
            entityManager.persist(cliente3);

            Factura factura3 = new Factura("Compra de celular", 1000L);
            factura3.setCliente(cliente3); //asociando factura con cliente
            entityManager.persist(factura3);

            Cliente cliente4 = new Cliente("Juan", "Perez", "Efectivo");
            cliente4.setFormaPago("Efectivo");
            entityManager.persist(cliente4);

            Factura factura4 = new Factura("Compra de celular", 1000L);
            factura4.setCliente(cliente4); //asociando factura con cliente
            entityManager.persist(factura4);

            //ahora los obtenemos todos
            // Obtener todas las facturas
            List<Factura> facturas = entityManager.createQuery("FROM Factura", Factura.class)
                    .getResultList();

            // Iterar sobre las facturas y acceder al cliente asociado
            for (Factura fact : facturas) {
                System.out.println("Factura: " + fact);
            }



            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

    }
}
