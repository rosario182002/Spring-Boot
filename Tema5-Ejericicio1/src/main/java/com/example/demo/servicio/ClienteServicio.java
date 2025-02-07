package com.example.demo.servicio;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositorio.ClienteRepositorio;

import jakarta.transaction.Transactional;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Direccion;

@Service
@Transactional
public class ClienteServicio implements InterfazServicio{

	@Autowired
    private  ClienteRepositorio clienteRepositorio;


	@Override
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepositorio.obtenerTodosLosClientes();
    }

	@Override
    public Cliente obtenerClientePorId(Long id) {
        return clienteRepositorio.buscarClientePorId(id)
        		.orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }
	
	@Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepositorio.guardarCliente(cliente);
    }

	@Override
    public Cliente actualizarCliente(Long id, Cliente clienteDetalles) {
        Cliente cliente = obtenerClientePorId(id);
        cliente.setNombre(clienteDetalles.getNombre());
        cliente.setDireccion(clienteDetalles.getDireccion());
        return clienteRepositorio.actualizarCliente(cliente);
    }

	@Override
    public void eliminarClientePorId(Long id) {
        clienteRepositorio.eliminarClientePorId(id);
    }
	@Override
    public Cliente modificarDireccion(Long clienteId, Direccion nuevaDireccion) {
        return clienteRepositorio.modificarDireccion(clienteId, nuevaDireccion);
    }
	@Override
    public List<Cliente> buscarClientesPorCiudad(String ciudad) {
        return clienteRepositorio.buscarClientesPorCiudad(ciudad);
    }
	@Override
    public void actualizarCiudadPorNombre(String ciudad, String letraInicial) {
        clienteRepositorio.actualizarCiudadPorNombre(ciudad, letraInicial);
    }
}