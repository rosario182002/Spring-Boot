package com.example.demo;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Direccion;
import com.example.demo.service.ClienteServicio;

@SpringBootApplication
public class Tema4Ejercicio6Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Tema4Ejercicio6Application.class, args);
	}
	
	@Autowired
	ClienteServicio clienteServicio;
	
	@Override
	public void run(String...arg) throws Exception{
		//1. Insertar el cliente con nombre Pepe Ruiz y dirección calle Sol de Oviedo
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Pepe Ruiz");
		
		Direccion dir1 = new Direccion();
		dir1.setCalle("Sol");
		dir1.setCiudad("Oviedo");
		
		cliente1.setDireccion(dir1);
		
		clienteServicio.guardarCliente(cliente1);
		
		
		//2. Insertar el cliente con nombre Andrés Ramírez y dirección calle Mar de Cádiz.
		Cliente cliente2 = new Cliente();
		cliente2.setNombre("Andrés Ramírez");
		
		Direccion dir2 = new Direccion();
		dir2.setCalle("Malaga");
		dir2.setCiudad("Cádiz");
		
		cliente2.setDireccion(dir2);
		
		clienteServicio.guardarCliente(cliente2);
		
		
		//3. Mostrar la lista de todos los clientes 
		
		List<Cliente> clientes = clienteServicio.obtenerTodosLosClientes();
		for (Cliente cliente : clientes) {
			System.out.println(clientes);
		}
	
		//4. Obtener los datos del cliente con el id de Pepe Ruiz.
		
		System.out.println(clienteServicio.obtenerClientePorId(cliente1.getId()));
		//5. Dado el id de Pepe Ruiz, actualizar sus datos: Pepe José Ruiz, calle luna de Madrid.
		
		cliente1.setNombre("Pepe Jose Ruiz");
		cliente1.getDireccion().setCalle("Luna");
		cliente1.getDireccion().setCiudad("Madrid");
		clienteServicio.actualizarCliente(cliente1.getId(), cliente1);
		
		//6. Mostrar la lista de todos los clientes y comprobar la actualización.
		System.out.println("Lista de todos los clientes: ");
		clientes = clienteServicio.obtenerTodosLosClientes();
		for(Cliente cliente : clientes) {
			System.out.println(cliente.getNombre() + " - " + cliente.getDireccion().getCalle());
			
		}
		//7. Volver a añadir a otro cliente con los mismos datos de Andrés Ramírez.
		Cliente cliente3 = new Cliente();
		cliente3.setNombre("Andrés Ramírez");
		Direccion dir3 = new Direccion();
		dir3.setCalle("Mar");
		dir3.setCiudad("Cádiz");
		
		cliente3.setDireccion(dir3);
		clienteServicio.guardarCliente(cliente3);
		
		//8. Modificar la dirección del primer Andrés: Calle Estrella de Málaga, usando el método 6.
		cliente2.getDireccion().setCalle("Estrella");
		cliente2.getDireccion().setCiudad("Málaga");
		clienteServicio.actualizarCliente(cliente2.getId() ,cliente2);
		
		//9. Actualizar a Sevilla todos los clientes cuyo nombre empiece por ‘A’ o ‘a’. 
		 clienteServicio.actualizarCiudadPorNombre("Sevilla", "A");
	        System.out.println("\nClientes cuyo nombre empieza con 'A' después de la actualización:");
	        clientes = clienteServicio.buscarClientesPorCiudad("Sevilla");
	        for (Cliente cliente : clientes) {
	            System.out.println(cliente.getNombre() + " - " + cliente.getDireccion().getCiudad());
	        }
		
		//10. Actualizar a Granada todos los clientes cuyo nombre empiece por P.
	        clienteServicio.actualizarCiudadPorNombre("Granada", "P");
	        System.out.println("\nClientes cuyo nombre empieza con 'P' después de la actualización:");
	        clientes = clienteServicio.buscarClientesPorCiudad("Granada");
	        for (Cliente cliente : clientes) {
	            System.out.println(cliente.getNombre() + " - " + cliente.getDireccion().getCiudad());
	        }
	        
	    //11. Mostrar la lista de todos los clientes de Sevilla.
	        System.out.println("\nClientes de Sevilla:");
	        clientes = clienteServicio.buscarClientesPorCiudad("Sevilla");
	        for (Cliente cliente : clientes) {
	            System.out.println(cliente.getNombre() + " - " + cliente.getDireccion().getCiudad());
	        }
		//12. Eliminar al último Andrés insertado.
	        clienteServicio.eliminarClientePorId(cliente3.getId());
	        System.out.println("\nClientes después de eliminar al último Andrés:");
	        clientes = clienteServicio.obtenerTodosLosClientes();
	        for (Cliente cliente : clientes) {
	            System.out.println(cliente.getNombre() + " - " + cliente.getDireccion().getCiudad());
	        }
	        
		//13. Mostrar de nuevo la lista de clientes
	        System.out.println("\nLista final de todos los clientes:");
	        clientes = clienteServicio.obtenerTodosLosClientes();
	        for (Cliente cliente : clientes) {
	            System.out.println(cliente.getNombre() + " - " + cliente.getDireccion().getCiudad());
	        }
	}

}
