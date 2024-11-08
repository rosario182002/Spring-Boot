package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.modelo.Cliente;
import com.example.repositorio.RepositorioCliente;

@Service
public class ServiciosCliente {
	
	@Autowired
	private RepositorioCliente cliente;

		public List<Cliente> getClientes() {
			
			List<Cliente> clientes = cliente.getCliente();

		return clientes;
	}
		

	@Transactional
	 public Cliente insertarCliente(Cliente clientes) {
		return cliente.insertarCliente(clientes);
	}
	
	public Cliente mostrarCliente (Cliente id) {
		return cliente.mostrarCliente(id);
	}
	
}
