package org.mx.la.asociaciones;

import jakarta.persistence.EntityManager;
import org.mx.la.asociaciones.entity.Cliente;
import org.mx.la.asociaciones.entity.Factura;
import org.mx.la.asociaciones.enums.FormaPago;
import org.mx.la.asociaciones.enums.TipoCompra;
import org.mx.la.asociaciones.util.JPAUtil;

public class HibernateJPA001ManyToOne {
    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        try {

            /**
             * De manera resumida podemos insertar valores de manera normal
             * y de manera bidirecional, es quiere decir que cuando insertamos valores de forma
             * normal, lo estamos haciendo de forma lineal, ya sea desde factura cliente o
             * viceversa.
             *
             */

            /**
             * 1. Asociacion ManyToOne
             * Inserccion de cliente con Factura
             */
            /*
            em.getTransaction().begin();

            //1.1 Creacion de cliente
            Cliente cliente = new Cliente("Gatsby2", "Edu");
            cliente.setFormaPago(FormaPago.TARJETA_CREDITO.getDescripcion());

            //1.2 Se persiste Cliente cliente
            em.persist(cliente);

            //1.3 Creacion de factura
            Factura factura = new Factura(TipoCompra.TALLER_AUTOMOTRIZ.getDescripcion(), 1000L);
            factura.setCliente(cliente); // -> asignacion de cliente a factura

            //1.4 Se persiste Factura
            em.persist(factura);
            System.out.println(factura.getCliente());
            em.getTransaction().commit();

            */

            /**
             * 2. Encontrar un cliente y asignar Factura
             */
            /*
            em.getTransaction().begin();
            //2.1 Busqueda de un cliente
            Cliente cliente = em.find(Cliente.class, 1L);

            //2.2 Creacion de una Factura
            Factura factura = new Factura("compras de oficina", 1000L);
            factura.setCliente(cliente); //-> se agrega la factura

            //2.3 Se persiste factura
            em.persist(factura);

            System.out.println(factura.getCliente());
            em.getTransaction().commit();
            */

            /**
             * 3. Eliminar Cliente
             */
            /*
            em.getTransaction().begin();
            //3.1 Busqueda de un cliente
            Cliente cliente = em.find(Cliente.class, 11L);

            //3.2
            em.remove(cliente);
            em.getTransaction().commit();
            */

            /**
             * Se encarga de insertar o consultar datos, pero a diferencia del primero
             * podemos hacerlo con multiples, es decir, tenemos unos metodos
             * que nos ayudan a agilizar los metodos CRUD
             */

            /**
             * 4. Asociacion OneToMany bidireccional
             * Insercion de Cliente con Facturas multiples
             */
            /*
            em.getTransaction().begin();
            //4.1 Creacion de Cliente
            Cliente cliente = new Cliente("Cata", "Edu");
            cliente.setFormaPago("paypal");

            //4.2 Creacion de Facturas
            Factura f1 = new Factura("compras de supermercado", 5000L);
            Factura f2 = new Factura("compras de tecnologia", 7000L);

            //4.3 Usamos el metodo addFactura
            cliente.addFactura(f1)
                    .addFactura(f2);

            //4.4 Se persiste cliente
            em.persist(cliente);
            em.getTransaction().commit();
            System.out.println(cliente);
            */

            /**
             * 5. Removiendo una factura forma 1
             */

            /*
            em.getTransaction().begin();

            //5.1 Encontrar Factura
            Factura f4 = em.find(Factura.class, 19L);

            //5.2 Ubicando Cliente
            Cliente c1 = f4.getCliente();

            //5.3 Removemos la factura
            c1.removeFactura(f4);

            //5.4 Se persiste cliente
            em.persist(c1);
            em.getTransaction().commit();
            */

            /**
             * 6. Removiendo una factura forma 2
             */
            /*
            em.getTransaction().begin();
            //6.1 Encontrar una Factura
            Factura f3 = em.find(Factura.class, 1L);
            //Factura f3 = new Factura("compras de supermercado", 5000L);
            f3.setId(1L);
            //6.2 Eliminando Factura
            em.remove(f3);

            em.getTransaction().commit();
            */


        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


}
