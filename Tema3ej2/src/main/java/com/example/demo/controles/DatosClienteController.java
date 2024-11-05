package com.example.demo.controles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Clientes;

@RestController
public class DatosClienteController {
	/*
	public List <Clientes> clientes = new ArrayList<>();
	public DatosClienteController() {
		
		Clientes c1 = new Clientes(234,"Juan Perez","jperez","clave123");
		Clientes c2 = new Clientes(127,"Sara Lopez","slopez","clave123");
		Clientes c3 = new Clientes(896,"Eda Cruz","ecruz","clave123");
		Clientes c4= new Clientes(865,"Pepe Fuente","pfuente","clave123");
		
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		clientes.add(c4);
	
	}
	
	@GetMapping("/clientes")
	public List<Clientes> obtenerDatos(){
		return clientes;
	}
	
@GetMapping("/clientes/{username}")
    
    public Clientes metodoC(@PathVariable String username) {
        Clientes respuesta=null;
        for (Clientes client : clientes) {
            if (client.getUsername().equals(username)) {
                 respuesta = client;
            }
        }
        return respuesta;
    }
@PostMapping("/clientes")
public Clientes postCliente(@RequestBody Clientes cliente) {
	clientes.add(cliente);
	return cliente;
	
}

@PutMapping("/clientes")
public Clientes putClientes(@RequestBody Clientes modif) {
	for(Clientes cliente : clientes) {
		if(cliente.getId()== modif.getId()) {
			cliente.setNombre(modif.getNombre());
			cliente.setPassword(modif.getPassword());
			cliente.setUsername(modif.getUsername());
			return cliente;
		}
		
	}
	return null;
	
}

@DeleteMapping("/clientes/{id}")
public Clientes deleteCliente(@PathVariable int id) {
	Iterator<Clientes>iterador =clientes.iterator();
	while(iterador.hasNext()) {
		Clientes clientes = iterador.next();
		if(clientes.getId()==id) {
			iterador.remove();
			return clientes;
		}
	}
	return null;
}


@PatchMapping("/clientes")
public Clientes pathCliente(@RequestBody Clientes modif) {
	for(Clientes clientes: clientes) {
		if(clientes.getId()==modif.getId()) {
			if(modif.getNombre()!=null) {
				System.out.println("nombre");
				clientes.setNombre(modif.getNombre());
			}
			if(modif.getPassword()!=null) {
				System.out.println("pass");
				clientes.setPassword(modif.getPassword());
			}
			if(modif.getUsername()!=null) {
				System.out.println("user");
				clientes.setUsername(modif.getUsername());
			}
			return clientes;
	}
		
	}
	return null;
	
}*/

}
