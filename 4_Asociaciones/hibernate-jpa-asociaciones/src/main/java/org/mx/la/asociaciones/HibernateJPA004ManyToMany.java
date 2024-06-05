package org.mx.la.asociaciones;

import jakarta.persistence.EntityManager;
import org.mx.la.asociaciones.entity.Alumnos;
import org.mx.la.asociaciones.entity.Cursos;
import org.mx.la.asociaciones.util.JPAUtil;

public class HibernateJPA004ManyToMany {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        try {

            /**
             * ManyToMany
             */

            /**
             * 1. Agragando multiples alumnos con cursos
             */
            /*
            em.getTransaction().begin();

            //1.1 Creando alumnos
            Alumnos alumno1 = new Alumnos("Cata", "Edu");
            Alumnos alumno2 = new Alumnos("Jano", "Fernan");

            //1.2 Creando cursos
            Cursos curso1 = new Cursos("Curso Java", "Andres");
            Cursos curso2 = new Cursos("Curso Hibernate y Jpa", "Andres");

            //1.3 Agregando cursos a alumno 1
            alumno1.getCursos().add(curso1);
            alumno1.getCursos().add(curso2);

            //1.4 Agregando curso a alumno 2
            alumno2.getCursos().add(curso1);

            //1.5 Persisntencia
            em.persist(alumno1);
            em.persist(alumno2);

            em.getTransaction().commit();

            System.out.println(alumno1);
            System.out.println(alumno2);
            */

            /**
             * 2. Eliminando cursos
             */
            /*
            em.getTransaction().begin();
            //2.1 Encontrando un alumno
            Cursos c2 = em.find(Cursos.class, 3L);
            //2.2 Eliminando un curso
            alumno1.getCursos().remove(c2);
            em.getTransaction().commit();
            System.out.println(alumno1);
            */

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
