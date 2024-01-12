package org.example.APICriteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.example.entity.Cliente;
import org.example.util.JpaUtil;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HibernateCriteria {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Cliente> query = cb.createQuery(Cliente.class);

        Root<Cliente> from = query.from(Cliente.class);

        System.out.println("----------Select all clients ----------");
        query.select(from);
        List<Cliente> clientes = em.createQuery(query).getResultList();
        clientes.forEach(System.out::println);


        //reiniciamos la consulta
        query = cb.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        System.out.println("---------- Seleccion con where e id ----------");
        query.select(from).where(cb.equal(from.get("id"), 2L));
        Cliente cliente = em.createQuery(query).getSingleResult();
        System.out.println(cliente);

        //reiniciamos la consulta
        query = cb.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        System.out.println("---------- Seleccion con where nombre ----------");
        ParameterExpression<String> nombre = cb.parameter(String.class, "nombre");
        query.select(from).where(cb.equal(from.get("nombre"), nombre));
        cliente = em.createQuery(query).setParameter("nombre", "lucy").getSingleResult();
        System.out.println(cliente);

        //reiniciamos la consulta
        query = cb.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        System.out.println("---------- Seleccion con where y like forma 1----------");
        ParameterExpression<String> apellido = cb.parameter(String.class, "apellido");
        query.select(from).where(cb.like(cb.upper(from.get("apellido")), apellido));
        List<Cliente> clientes2 = em.createQuery(query).setParameter("apellido", "%P%").getResultList();
        clientes2.forEach(System.out::println);

        //reiniciamos la consulta
        query = cb.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        System.out.println("---------- Seleccion con where y like forma 2----------");
        query.select(from).where(cb.like(from.get("apellido"), "%P%"));
        clientes2 = em.createQuery(query).getResultList();
        clientes2.forEach(System.out::println);

        //reiniciamos la consulta
        query = cb.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        System.out.println("---------- Seleccion con where y between---------");
        query.select(from).where(cb.between(from.get("id"), 2L, 5L));
        clientes2 = em.createQuery(query).getResultList();
        clientes2.forEach(System.out::println);

        //reiniciamos la consulta
        query = cb.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        System.out.println("---------- Seleccion con in--------");
        query.select(from).where(from.get("id").in(1L, 3L, 5L));
        clientes2 = em.createQuery(query).getResultList();
        clientes2.forEach(System.out::println);

        //reiniciamos la consulta
        query = cb.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        System.out.println("---------- Seleccion con gt mayor que --------");
        query.select(from).where(cb.gt(from.get("id"), 3L));
        clientes2 = em.createQuery(query).getResultList();
        clientes2.forEach(System.out::println);

        //reiniciamos la consulta
        query = cb.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        System.out.println("---------- Seleccion con lt menor que --------");
        query.select(from).where(cb.lt(from.get("id"), 3L));
        clientes2 = em.createQuery(query).getResultList();
        clientes2.forEach(System.out::println);

        //reiniciamos la consulta
        query = cb.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        System.out.println("---------- Seleccion con gt mayor que o igual a--------");
        query.select(from).where(cb.ge(from.get("id"), 3L));
        clientes2 = em.createQuery(query).getResultList();
        clientes2.forEach(System.out::println);

        //reiniciamos la consulta
        query = cb.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        System.out.println("---------- Seleccion con lt menor que o igual a--------");
        query.select(from).where(cb.le(from.get("id"), 3L));
        clientes2 = em.createQuery(query).getResultList();
        clientes2.forEach(System.out::println);

        //reiniciamos la consulta
        query = cb.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        System.out.println("---------- Seleccion con and--------");
        query.select(from).where(cb.and(cb.like(from.get("apellido"), "%P%"), cb.ge(from.get("id"), 3L)));
        clientes2 = em.createQuery(query).getResultList();
        clientes2.forEach(System.out::println);

        //reiniciamos la consulta
        query = cb.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        System.out.println("---------- Seleccion con or--------");
        query.select(from).where(cb.or(cb.like(from.get("apellido"), "%P%"), cb.ge(from.get("id"), 3L)));
        clientes2 = em.createQuery(query).getResultList();
        clientes2.forEach(System.out::println);

        //reiniciamos la consulta
        query = cb.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        System.out.println("---------- Seleccion con order by --------");
        query.select(from).orderBy(cb.asc(from.get("apellido")));
        clientes2 = em.createQuery(query).getResultList();
        clientes2.forEach(System.out::println);

        //reiniciamos la consulta
        query = cb.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        System.out.println("---------- Ejemplo complejo con order by single result por id distinct nombre y upper --------");
        query.select(from).where(cb.like(from.get("apellido"), "%P%")).orderBy(cb.asc(from.get("apellido")));
        clientes2 = em.createQuery(query).getResultList();
        clientes2.forEach(System.out::println);


        System.out.println("---------- Sleccion con concat --------");
        CriteriaQuery<String> nombreCompletoQuery = cb.createQuery(String.class);
        Root<Cliente> nombreCompletoRoot = nombreCompletoQuery.from(Cliente.class);
        Expression<String> nombreCompletoConcatenado = cb.function("concat", String.class,
                nombreCompletoRoot.get("nombre"),
                cb.literal(" "),
                nombreCompletoRoot.get("apellido")
        );
        nombreCompletoQuery.select(nombreCompletoConcatenado).
                where(cb.like(nombreCompletoRoot.get("apellido"), "%P%")).orderBy(cb.asc(nombreCompletoRoot.get("apellido")));
        List<String> nombresCompletos = em.createQuery(nombreCompletoQuery).getResultList();
        nombresCompletos.forEach(System.out::println);

        //reiniciamos la consulta
        query = cb.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        System.out.println("---------- Multiselect --------");
        CriteriaQuery<Object[]> multiselectQuery = cb.createQuery(Object[].class);
        from = multiselectQuery.from(Cliente.class);
        multiselectQuery.multiselect(from.get("id"), from.get("nombre"), from.get("apellido"));
        List<Object[]> multiselect = em.createQuery(multiselectQuery).getResultList();
        multiselect.forEach(
                (a) -> System.out.println("id: " + a[0] + " nombre: " + a[1] + " apellido: " + a[2])
        );


        System.out.println("---------- count  --------");
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<Cliente> countRoot = countQuery.from(Cliente.class);
        countQuery.select(cb.count(countRoot));
        Long count = em.createQuery(countQuery).getSingleResult();
        System.out.println("Cantidad de clientes: " + count);

        //reiniciamos la consulta
        query = cb.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        System.out.println("---------- sum --------");
        CriteriaQuery<Long> sumQuery = cb.createQuery(Long.class);
        Root<Cliente> sumRoot = sumQuery.from(Cliente.class);
        sumQuery.select(cb.sum(sumRoot.get("id")));
        Long sum = em.createQuery(sumQuery).getSingleResult();
        System.out.println("Suma de ids: " + sum);



        //reiniciamos la consulta
        query = cb.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        System.out.println("---------- max --------");
        CriteriaQuery<Long> maxQuery = cb.createQuery(Long.class);
        Root<Cliente> maxRoot = maxQuery.from(Cliente.class);
        maxQuery.select(cb.max(maxRoot.get("id")));
        Long max = em.createQuery(maxQuery).getSingleResult();
        System.out.println("Máximo id: " + max);

        //reiniciamos la consulta
            query = cb.createQuery(Cliente.class);
            from = query.from(Cliente.class);

        System.out.println("---------- min --------");
        CriteriaQuery<Long> minQuery = cb.createQuery(Long.class);
        Root<Cliente> minRoot = minQuery.from(Cliente.class);
        minQuery.select(cb.min(minRoot.get("id")));
        Long min = em.createQuery(minQuery).getSingleResult();
        System.out.println("Mínimo id: " + min);

        query = cb.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        System.out.println("---------- Busqueda dinamica --------");
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el nombre a buscar: ");
        String nombre1 = in.nextLine();
        System.out.println("Ingrese el apellido a buscar: ");
        String apellido1 = in.nextLine();
        System.out.println("Ingrese la forma de pago a buscar: ");
        String formaPago1 = in.nextLine();

        CriteriaQuery<Cliente> busquedaDinamicaQuery = cb.createQuery(Cliente.class);
        Root<Cliente> busquedaDinamicaRoot = busquedaDinamicaQuery.from(Cliente.class);
        List<Predicate> busquedaDinamicaPredicates = new ArrayList<>();
        if (!nombre1.isEmpty()) {
            busquedaDinamicaPredicates.add(cb.like(busquedaDinamicaRoot.get("nombre"), "%" + nombre1 + "%"));
        }
        if (!apellido1.isEmpty()) {
            busquedaDinamicaPredicates.add(cb.like(busquedaDinamicaRoot.get("apellido"), "%" + apellido1 + "%"));
        }
        if (!formaPago1.isEmpty()) {
            busquedaDinamicaPredicates.add(cb.like(busquedaDinamicaRoot.get("formaPago"), "%" + formaPago1 + "%"));
        }
        busquedaDinamicaQuery.select(busquedaDinamicaRoot).where(busquedaDinamicaPredicates.toArray(new Predicate[]{}));
        List<Cliente> busquedaDinamica = em.createQuery(busquedaDinamicaQuery).getResultList();
        busquedaDinamica.forEach(System.out::println);













        em.close();

    }
}
