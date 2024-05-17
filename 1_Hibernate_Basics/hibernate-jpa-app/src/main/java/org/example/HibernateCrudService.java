package org.example;

import jakarta.persistence.EntityManager;
import org.example.entity.Cliente;
import org.example.service.ClienteService;
import org.example.service.ClienteServiceImpl;
import org.example.util.JpaUtil;

import java.util.List;
import java.util.Optional;

public class HibernateCrudService {

    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();

        ClienteService clienteService = new ClienteServiceImpl(entityManager);

        System.out.println("==========LISTAR==========");
        List<Cliente> clientes = clienteService.listar();
        clientes.forEach(System.out::println);

        System.out.println("==========POR ID==========");
        Optional<Cliente> clienteOptional = clienteService.porId(1L);
        clienteOptional.ifPresent(c -> System.out.println(c.toString()));
        //System.out.println(cliente.orElse(new Cliente()));

        System.out.println("==========GUARDAR==========");
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Juan");
        cliente1.setApellido("Perez");
        cliente1.setFormaPago("Efectivo");
        clienteService.guardar(cliente1);

        System.out.println("==========ELIMINAR==========");
        clienteService.eliminar(1L);

        System.out.println("==========EDITAR==========");
        Long id = cliente1.getId();
        clienteOptional = clienteService.porId(id);
        clienteOptional.ifPresent(c -> {
            c.setNombre("editado");
            c.setApellido("Perez");
            c.setFormaPago("Credito");
            clienteService.guardar(c);
        });



        entityManager.close();
    }
}
