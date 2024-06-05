package org.mx.la.asociaciones;

import jakarta.persistence.EntityManager;
import org.mx.la.asociaciones.entity.Cliente;
import org.mx.la.asociaciones.entity.Direcciones;
import org.mx.la.asociaciones.util.JPAUtil;

public class HibernateJPA003ManyToOneTablaIntermedia {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        try {

            /**
             * 1. OneToMany
             */
            /*
            em.getTransaction().begin();

            //1.1 Busqueda de un cliente
            Cliente cliente = em.find(Cliente.class, 8L);

            //1.2 Creacion de direcciones
            Direcciones d1 = new Direcciones("el vergel", 123);
            Direcciones d2 = new Direcciones("vasco de gama", 456);

            //1.3 Asignando direcciones
            cliente.getDirecciones().add(d1);
            cliente.getDirecciones().add(d2);

            //1.4 Persistencia
            em.merge(cliente);

            em.getTransaction().commit();
            System.out.println(cliente);
            */

            /**
             * 2. Encontrar direcciones y eliminar una
             */
            /*
            em.getTransaction().begin();
            //2.1 Encontrar una direccion
            d1 = em.find(Direcciones.class, 1L);
            //2.2 Elimina una direccion
            cliente.getDirecciones().remove(d1);
            em.getTransaction().commit();

            System.out.println(cliente);
            */

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

}
