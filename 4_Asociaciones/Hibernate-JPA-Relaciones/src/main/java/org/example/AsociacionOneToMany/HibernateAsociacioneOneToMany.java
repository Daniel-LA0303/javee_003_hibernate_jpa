package org.example.AsociacionOneToMany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entity.Cliente;
import org.example.entity.Direcciones;
import org.example.util.JpaUtil;

public class HibernateAsociacioneOneToMany {

    //Usando joinColumn
    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Cliente cliente = new Cliente("Juan", "Perez", "Efectivo");
            cliente.setFormaPago("Efectivo");
            entityManager.persist(cliente);

            Direcciones direccion1 = new Direcciones("Calle 1", 100);
            Direcciones direccion2 = new Direcciones("Calle 2", 200);
            Direcciones direccion3 = new Direcciones("Calle 3", 300);

            cliente.getDirecciones().add(direccion1);
            cliente.getDirecciones().add(direccion2);
            cliente.getDirecciones().add(direccion3);

            transaction.commit();

            System.out.println("********** Obtener un cliente con sus direcciones **********");
            entityManager.clear(); // Limpiar el contexto de persistencia para obtener datos actualizados
            transaction.begin();

            cliente = entityManager.find(Cliente.class, cliente.getId());
            System.out.println(cliente.getNombre() + " " + cliente.getApellido());
            cliente.getDirecciones().forEach(direccion -> System.out.println(direccion.getCalle() +
                    " Numero: " + direccion.getNumero()));

            System.out.println("********** Actualizando una direccion en db **********");
            direccion1 = entityManager.find(Direcciones.class, direccion1.getId());
            direccion1.setCalle("Calle 4");
            direccion1.setNumero(400);

            System.out.println("********** Actualizando un cliente en la db **********");
            cliente = entityManager.find(Cliente.class, cliente.getId());
            cliente.setNombre("Juan Carlos");
            cliente.setApellido("Perez");
            cliente.setFormaPago("Tarjeta");

            entityManager.merge(cliente);

            System.out.println("********** Eliminando un cliente en la db **********");
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
