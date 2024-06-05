package org.mx.la.asociaciones;

import jakarta.persistence.EntityManager;
import org.mx.la.asociaciones.entity.Cliente;
import org.mx.la.asociaciones.entity.ClienteDetalle;
import org.mx.la.asociaciones.enums.FormaPago;
import org.mx.la.asociaciones.util.JPAUtil;

public class HibernateJPA002OneToOne {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        try {

            /**
             * En esta asociacion hablamos de que cada Cliente tiene una direccion
             * esto significa que puede tener solo un detalle que hable del cliente
             * Cuando hablamos de bidireccionalidad, hablmos de que hacemos uso de
             * los metodos que esta en alguna de las dos entidades, en este caso
             * Cliente como addDetalle
             */

            /**
             * 1. Asociacion OneToOne
             * Inserccion de cliente con su respectivo detalle
             */
            /*
            em.getTransaction().begin();

            //1.1 Creamos el cliente
            Cliente cliente0 = new Cliente("Cata der", "Edu");
            cliente0.setFormaPago(FormaPago.TRANSFERENCIA_BANCARIA.getDescripcion());

            //1.2 Se persiste cliente
            em.persist(cliente0);

            //1.3 Creamos ClienteDetalle
            ClienteDetalle detalle = new ClienteDetalle(true, 5000L);
            detalle.setCliente(cliente0); // -> asignacion de cliente a detalle
            //1.4 Se persiste detalle
            em.persist(detalle);

            em.getTransaction().commit();

            System.out.println(detalle.getCliente());
            */

            /**
             * 2. Asociacion OneToOne bidireccional
             * Inserccion de cliente con su respectivo detalle
             */

            /*
            em.getTransaction().begin();

            //2.1 Creacion del Cliente
            Cliente cliente = new Cliente("Fredo", "Edu");
            cliente.setFormaPago(FormaPago.TARJETA_DEBITO.getDescripcion());

            //2.2 Creacion del detalle
            ClienteDetalle detalle = new ClienteDetalle(true, 8000L);

            //2.3 se agrega detalle a la instancia de cliente con ayuda de metodo
            cliente.addDetalle(detalle);

            //2.4 Se persiste cliente
            em.persist(cliente);
            em.getTransaction().commit();

            System.out.println(cliente);

            */
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


}
