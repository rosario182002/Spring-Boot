package com.example.repositorio;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RepositorioCliente {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Cliente> getCliente(){
		Query<Cliente> query = (Query<Cliente>)entityManager.createQuery("select c from cliente c ", Cliente.class);
		
		List<Cliente> lista = query.getResultList();
		return lista;
	}
	
	public Cliente insertarCliente(Cliente cliente){
		entityManager.persist(cliente);
		return cliente;
		
	}
	public Cliente mostrarCliente(String id) {
   Cliente cliente = entityManager.find(Cliente.class, id);
   return cliente;
	}
	
}
