package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Cliente;

public interface interfazServicio {

	public List<Cliente> getClientes();
	public Cliente getCliente(Integer id);
	public Cliente insertaCliente(Cliente cl);
	public Boolean deleteCliente(Integer id);
	public Cliente actualizarCliente(Cliente cl);
	public List<Cliente> getClientesNombre(String nombre);
}
