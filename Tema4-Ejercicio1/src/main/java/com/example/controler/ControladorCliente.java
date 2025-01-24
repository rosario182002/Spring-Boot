package com.example.controler;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.modelo.Cliente;
import com.example.services.ServiciosCliente;

@RestController
@RequestMapping("/clientes")
public class ControladorCliente {
	
	@Autowired
	private ServiciosCliente servicio;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getClientes(){
		List<Cliente> clientes = servicio.getClientes();
		return ResponseEntity.ok(clientes);
	}
	
	@PostMapping
	public ResponseEntity<Cliente>insertarCliente(@RequestBody Cliente cliente){
		servicio.insertarCliente(cliente);
		return ResponseEntity.ok(cliente);
	}
	   // Eliminar un cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable int id) {
    	servicio.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
    
    //Actualizar un cliente por ID
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable int id, @RequestBody Cliente cliente) {
        Cliente clienteActualizado = servicio.actualizarCliente(id, cliente);
        return ResponseEntity.ok(clienteActualizado);
    }

    // Actualizar parcialmente un cliente por ID
    @PatchMapping("/{id}")
    public ResponseEntity<Cliente> actualizarClienteParcial(@PathVariable int id, @RequestBody Cliente cliente) {
        Cliente clienteActualizado = servicio.actualizarClienteParcial(id, cliente);
        return clienteActualizado != null ? ResponseEntity.ok(clienteActualizado): ResponseEntity.notFound().build();
    }

    // Obtener clientes por nombre
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Cliente>> getClientesNombre(@PathVariable String nombre) {
        List<Cliente> clientes = servicio.obtenerClientesPorNombre(nombre);
        return ResponseEntity.ok(clientes);
    }
	
	
	
}
