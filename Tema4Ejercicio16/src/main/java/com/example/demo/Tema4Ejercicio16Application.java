package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Deportista;
import com.example.demo.servicio.ServiDeportista;

@SpringBootApplication
public class Tema4Ejercicio16Application  implements CommandLineRunner{

	 @Autowired
	    private ServiDeportista servicioDeportista;

	public static void main(String[] args) {
		SpringApplication.run(Tema4Ejercicio16Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		 // 1. Crear deportistas
        Deportista deportista1 = new Deportista("Juan");  // Crea el deportista Juan
        Deportista deportista2 = new Deportista("Maria");  // Crea el deportista Maria

        // Guarda los deportistas en la base de datos
        servicioDeportista.crearDeportista(deportista1);
        servicioDeportista.crearDeportista(deportista2);

        // 2. Agregar deportes
        servicioDeportista.crearDeportista(deportista1.getId(), "Fútbol");  // Agrega el deporte "Fútbol" a Juan
        servicioDeportista.crearDeportista(deportista1.getId(), "Baloncesto");  // Agrega el deporte "Baloncesto" a Juan
        servicioDeportista.crearDeportista(deportista2.getId(), "Tenis");  // Agrega el deporte "Tenis" a Maria

        // 3. Imprimir todos los deportistas
        // Obtiene todos los deportistas y los imprime en consola
        servicioDeportista.obtenerTodosLosDeportistas().forEach(System.out::println);

        // 4. Añadir Badminton a deportista2
        servicioDeportista.crearDeportista(deportista2.getId(), "Badminton");  // Agrega el deporte "Badminton" a Maria

        // 5. Obtener datos de deportista2
        // Muestra los detalles de Maria con los deportes agregados
        System.out.println(servicioDeportista.obtenerDeportistaPorId(deportista2.getId()));

        // 6. Eliminar Fútbol de deportista1
        servicioDeportista.eliminarDeporte(deportista1.getId(), "Fútbol");  // Elimina el deporte "Fútbol" de Juan

        // 7. Obtener datos de deportista1
        // Muestra los detalles de Juan después de eliminar el deporte "Fútbol"
        System.out.println(servicioDeportista.obtenerDeportistaPorId(deportista1.getId()));

}
}
