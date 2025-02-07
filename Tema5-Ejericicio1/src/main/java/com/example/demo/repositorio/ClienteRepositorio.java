package com.example.demo.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Direccion;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository

public class ClienteRepositorio implements InterfazRepositorio {
	@PersistenceContext 
	private EntityManager entityManager;
	
	@Override
	public Cliente guardarCliente(Cliente cliente) {
		if(cliente.getId() == null) {
			entityManager.persist(cliente);
		}else {
			entityManager.merge(cliente);
			
		}
		
		
		return cliente;
	}
	
	@Override
	public List<Cliente> obtenerTodosLosClientes(){
		 return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
	}
	@Override
	public Optional<Cliente> buscarClientePorId(Long id) {
	    return Optional.ofNullable(entityManager.find(Cliente.class, id));
	}
	@Override
	public Cliente actualizarCliente(Cliente cliente) {
		return entityManager.merge(cliente);
	}
	@Override
	public void eliminarClientePorId(Long id) {
		Cliente cliente = entityManager.find(Cliente.class, id);
		if(cliente != null) {
			entityManager.remove(cliente);
		}
	}
	@Override
	public Cliente modificarDireccion(Long clienteId, Direccion nuevaDireccion) {
		Cliente cliente = entityManager.find(Cliente.class, clienteId);
		if(cliente != null) {
			cliente.setDireccion(nuevaDireccion);
			entityManager.merge(cliente);
		}
		return cliente;
	}
	@Override
	public List<Cliente> buscarClientesPorCiudad(String ciudad) {
        return entityManager.createQuery(
                "SELECT c FROM Cliente c WHERE c.direccion.ciudad = :ciudad", Cliente.class)
                .setParameter("ciudad", ciudad)
                .getResultList();
    }
	@Override
	public int actualizarCiudadPorNombre(String ciudad, String nombre) {
        return entityManager.createQuery(
                "UPDATE Cliente c SET c.direccion.ciudad = :ciudad WHERE LOWER(c.nombre) LIKE LOWER(:nombre)")
                .setParameter("ciudad", ciudad)
                .setParameter("nombre", nombre + "%")
                .executeUpdate();
    }
	
}
