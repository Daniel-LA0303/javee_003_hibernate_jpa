package org.example.HibernateJPQL;

import jakarta.persistence.EntityManager;
import org.example.HibernateJPQL.DTO.ClienteDTO;
import org.example.entity.Cliente;
import org.example.util.JpaUtil;

import java.util.Arrays;
import java.util.List;

public class HibernateQL {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        System.out.println("================= Consultar Todos ====================");
        List<Cliente> clientes =
                em.createQuery("select c from Cliente c", Cliente.class).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("================= Consultar por Id ====================");
        Cliente cliente =
                em.createQuery("select c from Cliente c where c.id =:id", Cliente.class)
                        .setParameter("id", 2L).getSingleResult();
        System.out.println(cliente);

        System.out.println("Conulta solo el nombre por el id");
        String nombre =
                em.createQuery("select c.nombre from Cliente c where c.id =:id", String.class)
                        .setParameter("id", 2L).getSingleResult();
        System.out.println(nombre);

        System.out.println("============= Conultas por campos personalizados ====================");
        Object[] objettoCliente =
                em.createQuery("select c.id, c.nombre, c.apellido from Cliente c where c.id =:id", Object[].class)
                        .setParameter("id", 2L).getSingleResult();
        Long id = (Long) objettoCliente[0];
        String nombre2 = (String) objettoCliente[1];
        String apellido = (String) objettoCliente[2];
        System.out.println(id + " " + nombre2 + " " + apellido);


        System.out.println("============= Conultas por campos personalizados lista ====================");
        List<Object[]> listaObjetos =
                em.createQuery("select c.id, c.nombre, c.apellido from Cliente c", Object[].class)
                        .getResultList();
        listaObjetos.forEach(o -> {
            System.out.println(o[0] + " " + o[1] + " " + o[2]);
        });


        System.out.println("============= Conultas por cliente y forma de pago ====================");
        List<Object[]> registros =
                em.createQuery("select c, c.formaPago from Cliente c", Object[].class)
                        .getResultList();
        registros.forEach(reg -> {
            Cliente c = (Cliente) reg[0];
            String fp = (String) reg[1];
            System.out.println("Cliente: " + c);
            System.out.println("Forma de pago: " + fp);
        });

        System.out.println("============= Consulta que pobla y devulve objeto entity de una clase personalizada ====================");
        List<Cliente> clientes2 =
                em.createQuery("select new Cliente(c.nombre, c.apellido) from Cliente c", Cliente.class)
                        .getResultList();
        clientes2.forEach(System.out::println);


        System.out.println("============= Consulta que pobla y devulve objeto otro de una clase personalizada ====================");
        List<ClienteDTO> clientes3 =
                em.createQuery("select new org.example.HibernateJPQL.DTO.ClienteDTO(c.nombre, c.apellido) from Cliente c", ClienteDTO.class)
                        .getResultList();
        clientes3.forEach(System.out::println);

        System.out.println("============= Consulta con nombres de cleintes ====================");
        List<String> nombres =
                em.createQuery("select c.nombre from Cliente c", String.class)
                        .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("============= Consulta con nombres unicos de clientes  ====================");
        List<String> nombres2 =
                em.createQuery("select distinct c.nombre from Cliente c", String.class)
                        .getResultList();
        nombres2.forEach(System.out::println);

        System.out.println("============= Consulta con formas de pago unicas  ====================");
        List<String> clientes4 =
                em.createQuery("select distinct(c.formaPago) from Cliente c", String.class)
                        .getResultList();
        clientes4.forEach(System.out::println);

        System.out.println("============= Consulta con formas de pago unicas  ====================");
        Long clientes5 =
                em.createQuery("select count(distinct(c.formaPago)) from Cliente c", Long.class)
                        .getSingleResult();
        System.out.println("Numero de formas de pago: " + clientes5);

        System.out.println("============= Consulta con nombre y apellidos concatenado  ====================");
        List<String> clientes6 =
                em.createQuery("select concat(c.nombre, ' ', c.apellido) from Cliente c", String.class)
                        .getResultList();
        clientes6.forEach(System.out::println);

        System.out.println("============= Consulta con nombre y apellidos concatenado 2 ====================");
        List<String> clientes7 =
                em.createQuery("select c.nombre || ' ' || c.apellido from Cliente c", String.class)
                        .getResultList();
        clientes7.forEach(System.out::println);

        System.out.println("============= Consulta para uppercase ====================");
        List<String> clientes8 =
                em.createQuery("select upper(c.nombre) from Cliente c", String.class)
                        .getResultList();
        clientes8.forEach(System.out::println);

        System.out.println("============= Consulta para lowercase ====================");
        List<String> clientes9 =
                em.createQuery("select lower(c.nombre) from Cliente c", String.class)
                        .getResultList();
        clientes9.forEach(System.out::println);

        System.out.println("============= Consulta para like====================");
        List<Cliente> clientes10 =
                em.createQuery("select c from Cliente c where c.nombre like 'P%'", Cliente.class)
                        .getResultList();
        clientes10.forEach(System.out::println);

        System.out.println("============= Consulta para like con parametro ====================");
        List<Cliente> clientes11 =
                em.createQuery("select c from Cliente c where c.nombre like :nombre", Cliente.class)
                        .setParameter("nombre", "P%")
                        .getResultList();
        clientes11.forEach(System.out::println);

        System.out.println("============= Consulta para between ====================");
        List<Cliente> clientes12 =
                em.createQuery("select c from Cliente c where c.id between 2 and 5", Cliente.class)
                        .getResultList();
        clientes12.forEach(System.out::println);

        System.out.println("============= Consulta para order by ====================");
        List<Cliente> clientes13 =
                em.createQuery("select c from Cliente c order by c.nombre desc", Cliente.class)
                        .getResultList();
        clientes13.forEach(System.out::println);

        System.out.println("============= Consulta para agregacion count ====================");
        Long clientes14 =
                em.createQuery("select count(c) as total from Cliente c", Long.class)
                        .getSingleResult();
        System.out.println("Numero de clientes: " + clientes14);

        System.out.println("============= Consulta para agregacion sum ====================");
        Long clientes15 =
                em.createQuery("select sum(c.id) as total from Cliente c", Long.class)
                        .getSingleResult();
        System.out.println("Deuda total: " + clientes15);

        System.out.println("============= Consulta para agregacion max ====================");
        Long clientes16 =
                em.createQuery("select max(c.id) as total from Cliente c", Long.class)
                        .getSingleResult();
        System.out.println("total: " + clientes16);

        System.out.println("============= Consulta para agregacion min ====================");
        Long clientes17 =
                em.createQuery("select min(c.id) as total from Cliente c", Long.class)
                        .getSingleResult();
        System.out.println("total: " + clientes17);

        System.out.println("============= Consulta para nombre y su largo ====================");
        List<Object[]> clientes19 =
                em.createQuery("select c.nombre, length(c.nombre) from Cliente c", Object[].class)
                        .getResultList();
        clientes19.forEach(reg -> {
            System.out.println("Nombre: " + reg[0]);
            System.out.println("Largo: " + reg[1]);
        });

        System.out.println("============= Consulta con combinacion de todas ====================");
        List<Object[]> clientes20 =
                em.createQuery("select c.nombre, length(c.nombre), upper(c.nombre), lower(c.nombre) from Cliente c", Object[].class)
                        .getResultList();
        clientes20.forEach(reg -> {
            System.out.println("Nombre: " + reg[0]);
            System.out.println("Largo: " + reg[1]);
            System.out.println("Upper: " + reg[2]);
            System.out.println("Lower: " + reg[3]);
        });

        System.out.println("============= Consulta para agregación avg ====================");

        Double promedioLongitudNombres = em.createQuery(
                        "select avg(length(c.nombre)) from Cliente c", Double.class)
                .getSingleResult();

        System.out.println("Promedio de longitud de nombres: " + promedioLongitudNombres);


        System.out.println("============= Subqueries ====================");
        List<Cliente> clientes21 =
                em.createQuery("select c from Cliente c where c.id in (select max(c2.id) from Cliente c2)", Cliente.class)
                        .getResultList();
        clientes21.forEach(System.out::println);

        System.out.println("============= Subqueries 2 ====================");
        List<Cliente> clientes22 =
                em.createQuery("select c from Cliente c where c.id in (select max(c2.id) from Cliente c2 where c2.id in (1, 2, 3))", Cliente.class)
                        .getResultList();
        clientes22.forEach(System.out::println);

        System.out.println("============= Subquery complejo ====================");
        List<Cliente> clientes23 =
                em.createQuery("select c from Cliente c where c.id in (select max(c2.id) from Cliente c2 where c2.id in (select max(c3.id) from Cliente c3))",
                                Cliente.class).getResultList();
        clientes23.forEach(System.out::println);

        System.out.println("============= Subquery where in ====================");
        List<Cliente> clientes24 =
                em.createQuery("select c from Cliente c where c.id in (:ids)", Cliente.class)
                        .setParameter("ids", Arrays.asList(2L, 3L, 5L))
                        .getResultList();
        clientes24.forEach(System.out::println);


        em.close();

    }
}
