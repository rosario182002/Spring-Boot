package com.example.demo.controlador;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Direccion;
import com.example.demo.servicio.ClienteServicio;



@RestController

@RequestMapping("/api/clientes")
public class ClienteControlador {

    private  ClienteServicio clienteServicio;

    @GetMapping
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteServicio.obtenerTodosLosClientes();
    }

    @GetMapping("/{id}")
    public Cliente obtenerClientePorId(@PathVariable Long id) {
        return clienteServicio.obtenerClientePorId(id);
    }

    @PostMapping
    public Cliente guardarCliente(@RequestBody Cliente cliente) {
        return clienteServicio.guardarCliente(cliente);
    }

    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteDetalles) {
        return clienteServicio.actualizarCliente(id, clienteDetalles);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteServicio.eliminarClientePorId(id);
    }

    @PutMapping("/{id}/direccion")
    public Cliente modificarDireccion(@PathVariable Long id, @RequestBody Direccion nuevaDireccion) {
        return clienteServicio.modificarDireccion(id, nuevaDireccion);
    }

    @GetMapping("/buscar-por-ciudad")
    public List<Cliente> buscarClientesPorCiudad(@RequestParam String ciudad) {
        return clienteServicio.buscarClientesPorCiudad(ciudad);
    }

    @PutMapping("/actualizar-ciudad")
    public void actualizarCiudadPorNombre(@RequestParam String ciudad, @RequestParam String letraInicial) {
        clienteServicio.actualizarCiudadPorNombre(ciudad, letraInicial);
    }
}
