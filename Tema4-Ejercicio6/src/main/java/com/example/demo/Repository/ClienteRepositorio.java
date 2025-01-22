package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Direccion;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ClienteRepositorio implements InterfazRepositorio {
	@PersistenceContext 
	private EntityManager entityManager;
	
	public Cliente guardarCliente(Cliente cliente) {
		entityManager.persist(cliente);
		return cliente;
	}
	
	public List<Cliente> obtenerTodosLosClientes(){
		 return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
	}
	
	public Optional<Cliente> buscarClientePorId(Long id){
		Cliente cliente = entityManager.find(Cliente.class, id);
		return Optional.ofNullable(cliente);
	}
	
	public Cliente actualizarCliente(Cliente cliente) {
		return entityManager.merge(cliente);
	}
	
	public void eliminarClientePorId(Long id) {
		Cliente cliente = entityManager.find(Cliente.class, id);
		if(cliente != null) {
			entityManager.remove(cliente);
		}
	}
	
	public Cliente modificarDireccion(Long clienteId, Direccion nuevaDireccion) {
		Cliente cliente = entityManager.find(Cliente.class, clienteId);
		if(cliente != null) {
			cliente.setDireccion(nuevaDireccion);
			entityManager.merge(cliente);
		}
		return cliente;
	}
	
	public List<Cliente> buscarClientesPorCiudad(String ciudad) {
        return entityManager.createQuery(
                "SELECT c FROM Cliente c WHERE c.direccion.ciudad = :ciudad", Cliente.class)
                .setParameter("ciudad", ciudad)
                .getResultList();
    }
	
	public int actualizarCiudadPorNombre(String ciudad, String nombre) {
        return entityManager.createQuery(
                "UPDATE Cliente c SET c.direccion.ciudad = :ciudad WHERE LOWER(c.nombre) LIKE LOWER(:nombre)")
                .setParameter("ciudad", ciudad)
                .setParameter("nombre", nombre + "%")
                .executeUpdate();
    }
	
}
