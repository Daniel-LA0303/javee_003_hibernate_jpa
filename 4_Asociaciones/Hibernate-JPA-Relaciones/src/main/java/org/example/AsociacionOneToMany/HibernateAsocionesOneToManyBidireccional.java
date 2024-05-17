package org.example.AsociacionOneToMany;

import jakarta.persistence.EntityManager;
import org.example.entity.Cliente;
import org.example.entity.Factura;
import org.example.util.JpaUtil;

import java.math.BigDecimal;

public class HibernateAsocionesOneToManyBidireccional {

    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();

            //Bidirecional
            //1. Creamos el cliente

            System.out.println("******* Crate Cliente *******"  );
            Cliente cliente = new Cliente("Juan", "Perez", "Efectivo");
            cliente.setFormaPago("Efectivo");
            entityManager.persist(cliente);

            //2. Creamos las factura
            Factura factura = new Factura("Compra de celular", 1000L);
            Factura factura2 = new Factura("Compra de celular", 1000L);
            Factura factura3 = new Factura("Compra de celular", 1000L);

            //3. Agregamos las facturas al cliente
            cliente.getFacturas().add(factura);
            cliente.getFacturas().add(factura2);
            cliente.getFacturas().add(factura3);

            //4. Agregamos el cliente a las facturas
            factura.setCliente(cliente);
            factura2.setCliente(cliente);
            factura3.setCliente(cliente);

            entityManager.persist(cliente);

            System.out.println("Obtener un Cliente y sus facturas");
            cliente = entityManager.find(Cliente.class, cliente.getId());
            System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido());
            cliente.getFacturas().forEach(factura4 -> System.out.println(factura4.getDescripcion()));

            System.out.println("Obtener una factura y su cliente");
            factura = entityManager.find(Factura.class, factura.getId());
            System.out.println("Factura: " + factura.getDescripcion());
            System.out.println("Cliente: " + factura.getCliente().getNombre() + " " + factura.getCliente().getApellido());


            System.out.println("******* Actualizar una factura  desde factura *******");
            factura = entityManager.find(Factura.class, factura.getId());
            factura.setDescripcion("Compra de celular y accesorios factura");
            factura.setTotal(new BigDecimal("2000"));
            entityManager.merge(factura);

            System.out.println("******* Actualizar una factura  desde cliente *******");
            cliente = entityManager.find(Cliente.class, cliente.getId());
            cliente.getFacturas().forEach(factura4 -> {
                if (factura4.getId() == factura2.getId()) {
                    factura4.setDescripcion("Compra de celular y accesorios cliente");
                    factura4.setTotal(new BigDecimal("2000"));
                    entityManager.merge(factura4);
                }
            });

            System.out.println("******* Actualizar cliente desde cliente*******");
            cliente = entityManager.find(Cliente.class, cliente.getId());
            cliente.setNombre("Juan Carlos");
            cliente.setApellido("Perez cliente");
            entityManager.merge(cliente);
            System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido());

            System.out.println("******* Actualizar cliente desde factura*******");
            factura = entityManager.find(Factura.class, factura.getId());
            factura.getCliente().setNombre("Juan Carlos");
            factura.getCliente().setApellido("Perez factura");
            entityManager.merge(factura.getCliente());
            System.out.println("Cliente: " + factura.getCliente().getNombre() + " " + factura.getCliente().getApellido());

            System.out.println("******* Eliminar una factura  desde factura *******");
            factura = entityManager.find(Factura.class, factura.getId());
            entityManager.remove(factura);

            System.out.println("******* Eliminar una factura  desde cliente *******");
            cliente = entityManager.find(Cliente.class, cliente.getId());
            cliente.getFacturas().forEach(factura4 -> {
                if (factura4.getId() == factura2.getId()) {
                    entityManager.remove(factura4);
                }
            });

            System.out.println("******* Eliminar cliente desde cliente*******");
            cliente = entityManager.find(Cliente.class, cliente.getId());
            entityManager.remove(cliente);

            /*System.out.println("******* Eliminar cliente desde factura*******");
            factura = entityManager.find(Factura.class, factura3.getId());
            entityManager.remove(factura.getCliente());*/

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
}
