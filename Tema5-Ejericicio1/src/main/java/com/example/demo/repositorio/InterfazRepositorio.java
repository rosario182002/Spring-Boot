package com.example.demo.repositorio;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Direccion;

public interface InterfazRepositorio {

	public List<Cliente> obtenerTodosLosClientes();
	public Optional<Cliente> buscarClientePorId(Long id);
	public Cliente actualizarCliente(Cliente cliente);
	public void eliminarClientePorId(Long id);
	public Cliente modificarDireccion(Long clienteId, Direccion nuevaDireccion);
	public List<Cliente> buscarClientesPorCiudad(String ciudad);
	public int actualizarCiudadPorNombre(String ciudad, String nombre);
	Cliente guardarCliente(Cliente cliente);
	
}
