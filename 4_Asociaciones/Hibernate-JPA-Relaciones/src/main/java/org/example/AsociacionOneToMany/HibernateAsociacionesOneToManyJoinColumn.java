package org.example.AsociacionOneToMany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entity.Cliente;
import org.example.entity.Direcciones;
import org.example.util.JpaUtil;

import java.util.List;

public class HibernateAsociacionesOneToManyJoinColumn {

    //Utilizando JoinTable
    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            System.out.println("****** Creando cliente ******");
            Cliente cliente = new Cliente("Juan", "Perez", "Efectivo");
            cliente.setFormaPago("Efectivo");
            entityManager.persist(cliente);

            System.out.println("****** Creando direcciones ******");
            Direcciones direccion1 = new Direcciones("Calle 1", 100);
            Direcciones direccion2 = new Direcciones("Calle 2", 200);
            Direcciones direccion3 = new Direcciones("Calle 3", 300);

            cliente.getDirecciones().add(direccion1);
            cliente.getDirecciones().add(direccion2);
            cliente.getDirecciones().add(direccion3);

            entityManager.persist(cliente);

            System.out.println("****** Obteniendo un cliente con sus direcciones ******");
            cliente = entityManager.find(Cliente.class, cliente.getId());
            System.out.println("Cliente: " + cliente);

            List<Direcciones> direcciones = cliente.getDirecciones();
            direcciones.forEach(direccion -> {
                System.out.println("Dirección: " + direccion.getCalle() + " " + direccion.getNumero());
            });

            System.out.println("****** Actualizando una direccion ******");
            cliente = entityManager.find(Cliente.class, cliente.getId());
            cliente.getDirecciones().get(0).setCalle("Calle 1 actualizada");
            cliente.getDirecciones().get(0).setNumero(1000);

            entityManager.merge(cliente);
            System.out.println("Cliente: " + cliente.toString());

            System.out.println("****** Actualizando un Cliente ******");
            cliente = entityManager.find(Cliente.class, cliente.getId());
            cliente.setNombre("Juan Carlos");
            cliente.setApellido("Perez");
            cliente.setFormaPago("Tarjeta");

            entityManager.merge(cliente);
            System.out.println("Cliente: " + cliente.toString());

            System.out.println("****** Eliminando un cliente ******");
            entityManager.remove(cliente);


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

    }
}
