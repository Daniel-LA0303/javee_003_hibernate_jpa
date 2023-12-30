package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.entity.Cliente;

import java.util.List;

public class ClienteRepository implements CrudRepository<Cliente>{

    private EntityManager entityManager;

    public ClienteRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public List<Cliente> listar() {
        return entityManager.createQuery("select c from Cliente c", Cliente.class).getResultList();
    }

    @Override
    public Cliente porId(Long id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    public void guardar(Cliente c) {
        if (c.getId() != null && c.getId() > 0){
            entityManager.merge(c);
        }else{
            entityManager.persist(c);
        }
    }

    @Override
    public void eliminar(Long id) {
        Cliente cliente = porId(id);
        entityManager.remove(cliente);
    }
}
