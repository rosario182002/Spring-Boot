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
	
	public Cliente mostrarCliente (int id) {
			return cliente.mostrarCliente(id);
	}

	@Transactional
	 public Cliente insertarCliente(Cliente clientes) {
		return cliente.insertarCliente(clientes);
	}
	
	public void eliminarCliente(int id) {
        cliente.eliminarCliente(id);
    }

   /* public Cliente actualizarCliente(int id, Cliente cliente) {
        return cliente. actualizarCliente(id, cliente);
    }

    public Cliente actualizarClienteParcial(int id, Cliente cliente) {
        return cliente.actualizarClienteParcial(id, cliente);
    }
*/
    public List<Cliente> obtenerClientesPorNombre(String nombre) {
        return cliente.getClientesPorNombre(nombre);
    }
	
}
