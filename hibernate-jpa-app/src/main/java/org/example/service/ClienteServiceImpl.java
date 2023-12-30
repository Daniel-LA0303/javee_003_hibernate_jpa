package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.entity.Cliente;
import org.example.repository.ClienteRepository;
import org.example.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl implements ClienteService{

    private EntityManager entityManager;
    private CrudRepository<Cliente> crudRepository;

    public ClienteServiceImpl(EntityManager entityManager){
        this.entityManager = entityManager;
        this.crudRepository = new ClienteRepository(entityManager);
    }

    @Override
    public List<Cliente> listar() {
        return crudRepository.listar();
    }

    @Override
    public Optional<Cliente> porId(Long id) {
        return Optional.ofNullable(crudRepository.porId(id));
    }

    @Override
    public void guardar(Cliente c) {
        try {
            entityManager.getTransaction().begin();
            crudRepository.guardar(c);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            entityManager.getTransaction().begin();
            crudRepository.eliminar(id);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
