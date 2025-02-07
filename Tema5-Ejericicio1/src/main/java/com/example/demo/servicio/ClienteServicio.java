package com.example.demo.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.repositorio.ClienteRepositorio;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Direccion;

@Service
public class ClienteServicio implements InterfazServicio{

    private  ClienteRepositorio clienteRepositorio;


    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepositorio.obtenerTodosLosClientes();
    }

    public Cliente obtenerClientePorId(Long id) {
        return clienteRepositorio.buscarClientePorId(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepositorio.guardarCliente(cliente);
    }

    public Cliente actualizarCliente(Long id, Cliente clienteDetalles) {
        Cliente cliente = obtenerClientePorId(id);
        cliente.setNombre(clienteDetalles.getNombre());
        cliente.setDireccion(clienteDetalles.getDireccion());
        return clienteRepositorio.actualizarCliente(cliente);
    }

    public void eliminarClientePorId(Long id) {
        clienteRepositorio.eliminarClientePorId(id);
    }

    public Cliente modificarDireccion(Long clienteId, Direccion nuevaDireccion) {
        return clienteRepositorio.modificarDireccion(clienteId, nuevaDireccion);
    }

    public List<Cliente> buscarClientesPorCiudad(String ciudad) {
        return clienteRepositorio.buscarClientesPorCiudad(ciudad);
    }

    public void actualizarCiudadPorNombre(String ciudad, String letraInicial) {
        clienteRepositorio.actualizarCiudadPorNombre(ciudad, letraInicial);
    }
}