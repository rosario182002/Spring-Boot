package com.example.controler;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping
	
	
	
	
}
