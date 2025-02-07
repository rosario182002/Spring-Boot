package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Deporte;
import com.example.demo.modelo.Deportista;
import com.example.demo.servicio.InterServiDeporte;
import com.example.demo.servicio.InterServiDeportista;

@SpringBootApplication
public class Tema4Ejercicio17Application implements CommandLineRunner{
	
	  @Autowired
	  
	    private InterServiDeportista deportistaService;

	    @Autowired
	    private InterServiDeporte deporteService;

	public static void main(String[] args) {
		SpringApplication.run(Tema4Ejercicio17Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		 // 1. Crear dos deportistas: deportista1 y deportista2.
        Deportista deportista1 = new Deportista();
        deportista1.setNombre("Deportista 1");
        deportistaService.crearDeportista(deportista1);

        Deportista deportista2 = new Deportista();
        deportista2.setNombre("Deportista 2");
        deportistaService.crearDeportista(deportista2);

        // 2. Crear 3 deportes: futbol, tenis, y baloncesto
        Deporte futbol = new Deporte();
        futbol.setNombre("Futbol");
        deporteService.crearDeporte(futbol);

        Deporte tenis = new Deporte();
        tenis.setNombre("Tenis");
        deporteService.crearDeporte(tenis);

        Deporte baloncesto = new Deporte();
        baloncesto.setNombre("Baloncesto");
        deporteService.crearDeporte(baloncesto);

        // 3. Imprimir todos los deportistas. ¿Tienen deportes asociados?
        System.out.println("Deportistas Iniciales:");
        List<Deportista> deportistas = deportistaService.obtenerTodosLosDeportistas();
        deportistas.forEach(System.out::println);

        // 4. Agregar al deportista1 el deporte futbol.
        deportistaService.agregarDeporte(deportista1.getId(), futbol.getId());

        // 5. Agregar al deportista1 el deporte baloncesto.
        deportistaService.agregarDeporte(deportista1.getId(), baloncesto.getId());

        // 6. Agregar al deportista2 el deporte tenis.
        deportistaService.agregarDeporte(deportista2.getId(), tenis.getId());

        // 7. Imprimir todos los deportistas de nuevo. ¿Tienen deportes asociados?
        System.out.println("\nDeportistas con deportes asociados:");
        deportistas = deportistaService.obtenerTodosLosDeportistas();
        deportistas.forEach(System.out::println);

        // 8. Añadir un nuevo deporte: badminton, al deportista 2.
        Deporte badminton = new Deporte();
        badminton.setNombre("Badminton");
        deporteService.crearDeporte(badminton);
        deportistaService.agregarDeporte(deportista2.getId(), badminton.getId());

        // 9. Obtener los datos del deportista2.
        System.out.println("\nDatos del deportista2:");
        Deportista deportista2Datos = deportistaService.obtenerDeportistaPorId(deportista2.getId());
        System.out.println(deportista2Datos);

        // 10. Eliminar la relación del futbol con el deportista 1.
        deportistaService.eliminarDeporte(deportista1.getId(), "Futbol");

        // 11. Obtener los datos del deportista1.
        System.out.println("\nDatos del deportista1 después de eliminar futbol:");
        Deportista deportista1Datos = deportistaService.obtenerDeportistaPorId(deportista1.getId());
        System.out.println(deportista1Datos);

        //Ejemplo de uso de la bidireccionalidad:
        Deporte deporteFutbol = deporteService.obtenerDeportePorId(futbol.getId());
        System.out.println("\nDeportistas que juegan al futbol: " + deporteFutbol.getDeportistas());

    }
	
	

}
