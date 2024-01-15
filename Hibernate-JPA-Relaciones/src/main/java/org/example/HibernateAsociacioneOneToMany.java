package org.example;

import jakarta.persistence.EntityManager;
import org.example.entity.Cliente;
import org.example.entity.Direcciones;
import org.example.util.JpaUtil;

public class HibernateAsociacioneOneToMany {

    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();

            Cliente cliente = new Cliente("Juan", "Perez", "Efectivo");
            cliente.setFormaPago("Efectivo");
            entityManager.persist(cliente);

            Direcciones direccion1 = new Direcciones("Calle 1", 100);
            Direcciones direccion2 = new Direcciones("Calle 2", 200);
            Direcciones direccion3 = new Direcciones("Calle 3", 300);

            cliente.getDirecciones().add(direccion1);
            cliente.getDirecciones().add(direccion2);
            cliente.getDirecciones().add(direccion3);

            //eliminando ambas

            cliente = entityManager.find(Cliente.class, cliente.getId());
            cliente.getDirecciones().forEach(direccion -> System.out.println(direccion.getCalle()));
            cliente.getDirecciones().remove(direccion1);




            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

    }
}
