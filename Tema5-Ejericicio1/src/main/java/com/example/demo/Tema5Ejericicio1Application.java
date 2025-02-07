package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Direccion;
import com.example.demo.servicio.ClienteServicio;

@SpringBootApplication
public class Tema5Ejericicio1Application implements CommandLineRunner {

	@Autowired
	ClienteServicio clienteServicio;
	
	public static void main(String[] args) {
		SpringApplication.run(Tema5Ejericicio1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// 1. Insertar el cliente con nombre Pepe Ruiz y dirección calle Sol de Oviedo.
        Direccion direccion1 = new Direccion();
        direccion1.setCalle("Sol");
        direccion1.setCiudad("Oviedo");
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Pepe Ruiz");
        cliente1.setDireccion(direccion1);
        clienteServicio.guardarCliente(cliente1);

        // 2. Insertar el cliente con nombre Andrés Ramírez y dirección calle Mar de Cádiz.
        Direccion direccion2 = new Direccion();
        direccion2.setCalle("Mar");
        direccion2.setCiudad("Cádiz");
        Cliente cliente2 = new Cliente();
        cliente2.setNombre("Andrés Ramírez");
        cliente2.setDireccion(direccion2);
        clienteServicio.guardarCliente(cliente2);

        // 3. Mostrar la lista de todos los clientes
        System.out.println("\nLista de todos los clientes:");
        clienteServicio.obtenerTodosLosClientes().forEach(System.out::println);

        // 4. Obtener los datos del cliente con el id de Pepe Ruiz.
        Long pepeRuizId = cliente1.getId().longValue();
        System.out.println("\nDatos del cliente con id de Pepe Ruiz:");
        clienteServicio.obtenerClientePorId(pepeRuizId);

        // 5. Dado el id de Pepe Ruiz, actualizar sus datos: Pepe José Ruiz, calle luna de Madrid.
        cliente1.setNombre("Pepe José Ruiz");
        direccion1.setCalle("Luna");
        direccion1.setCiudad("Madrid");
        cliente1.setDireccion(direccion1);
        clienteServicio.guardarCliente(cliente1);

        // 6. Mostrar la lista de todos los clientes y comprobar la actualización.
        System.out.println("\nLista de todos los clientes después de la actualización:");
        clienteServicio.obtenerTodosLosClientes().forEach(System.out::println);

        // 7. Volver a añadir a otro cliente con los mismos datos de Andrés Ramírez.
        Cliente cliente3 = new Cliente();
        cliente3.setNombre("Andrés Ramírez");
        cliente3.setDireccion(direccion2);
        clienteServicio.guardarCliente(cliente3);

        // 8. Modificar la dirección del primer Andrés: Calle Estrella de Málaga
        Direccion nuevaDireccion = new Direccion();
        nuevaDireccion.setCalle("Estrella");
        nuevaDireccion.setCiudad("Málaga");
        Cliente clienteOriginalAndres = clienteServicio.obtenerClientePorId(cliente2.getId().longValue());
        if (clienteOriginalAndres != null) {
           clienteOriginalAndres.setDireccion(nuevaDireccion);
            clienteServicio.guardarCliente(clienteOriginalAndres);
        }

        // 9. Actualizar a Sevilla todos los clientes cuyo nombre empiece por ‘A’ o ‘a’. Comprobar
        clienteServicio.actualizarCiudadPorNombre("Sevilla", "A");
        System.out.println("\nLista de clientes después de actualizar a Sevilla:");
        clienteServicio.obtenerTodosLosClientes().forEach(System.out::println);

        // 10. Actualizar a Granada todos los clientes cuyo nombre empiece por P. Comprobar
        clienteServicio.actualizarCiudadPorNombre("Granada", "P");
        System.out.println("\nLista de clientes después de actualizar a Granada:");
        clienteServicio.obtenerTodosLosClientes().forEach(System.out::println);

        // 11. Mostrar la lista de todos los clientes de Sevilla.
        System.out.println("\nLista de clientes de Sevilla:");
        clienteServicio.buscarClientesPorCiudad("Sevilla").forEach(System.out::println);

        // 12. Eliminar al último Andrés insertado.
        Long andresId = cliente3.getId().longValue();
        clienteServicio.eliminarClientePorId(andresId);

        // 13. Mostrar de nuevo la lista de clientes.
        System.out.println("\nLista de clientes después de eliminar el último Andrés:");
        clienteServicio.obtenerTodosLosClientes().forEach(System.out::println);
    };
		
	}
	



