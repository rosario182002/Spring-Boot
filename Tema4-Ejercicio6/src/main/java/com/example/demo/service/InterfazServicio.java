package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Direccion;

public interface InterfazServicio {

	 public List<Cliente> obtenerTodosLosClientes();
	 public Cliente obtenerClientePorId(Long id);
	 public Cliente guardarCliente(Cliente cliente);
	 public Cliente actualizarCliente(Long id, Cliente clienteDetalles);
	 public void eliminarClientePorId(Long id);
	 public Cliente modificarDireccion(Long clienteId, Direccion nuevaDireccion);
	 public List<Cliente> buscarClientesPorCiudad(String ciudad);
	 public void actualizarCiudadPorNombre(String ciudad, String letraInicial);
}
