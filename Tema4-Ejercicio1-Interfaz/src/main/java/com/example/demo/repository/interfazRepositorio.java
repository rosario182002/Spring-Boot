package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Cliente;

public interface interfazRepositorio {
	
	public Cliente getCliente(Integer id);
	public Cliente insertaCliente(Cliente cliente);
	public Boolean deleteCliente(Integer id);
	public Cliente actualizarCliente(Cliente cliente);
	public List<Cliente> getClientesNombre(String nombre);

}
