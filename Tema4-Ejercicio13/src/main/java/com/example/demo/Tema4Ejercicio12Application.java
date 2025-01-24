package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Autor;
import com.example.demo.modelo.Libro;
import com.example.demo.servicio.InterfazServicioAutor;
import com.example.demo.servicio.InterfazServicioLibro;

@SpringBootApplication
public class Tema4Ejercicio12Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Tema4Ejercicio12Application.class, args);
	}
	
	@Autowired 
	InterfazServicioLibro servicioLibro;
	@Autowired
	InterfazServicioAutor servicioAutor;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//1º Insertar 2 autors
		List<Libro>lista1 = new ArrayList<>();
		Autor autor1 = new Autor("Manoli Lopez",lista1);
		List<Libro>lista2 = new ArrayList<>();
		Autor autor2 = new Autor("Pepe Ruiz", lista2);
		
		
		servicioAutor.insertarAutor(autor1);
		servicioAutor.insertarAutor(autor2);
		
		//2º Insertar 1 Libro para cada autor
		
		Libro libro1 = new Libro();
		libro1.setTitulo("Castillo de arena");
		Libro libro2 = new Libro();
		libro2.setTitulo("Harry Potter");
		
		servicioLibro.insertarLibro(libro1);
		servicioLibro.insertarLibro(libro2);
		
		
		servicioAutor.añadirLibroConAutorExit(libro1, 1);
		servicioAutor.añadirLibroConAutorExit(libro2, 2);
		
		
		//3º MOSTRAR TODOS LOS AUTORES
		List<Autor>autores = servicioAutor.obtenerListaAutor();
		for(Autor autor : autores) {
			System.out.println("TODOS LOS AUTORES: " + autor);
		}
		
		//4º MOSTRAR TODOS LOS LIBROS
		List<Libro>libros = servicioLibro.obtenerLibros();
		for(Libro libro : libros) {
			System.out.println("TODOS LOS LIBROS: " + libro);
		}
		
		//5º Obtener el primer autor por su id
		System.out.println("PRIMER AUTOR: " + servicioAutor.buscarAutorId(1));
		
		//6º ACTUALIZA EL NOMBRE DEL PRIMER AUTOR
		Autor autor3 = servicioAutor.buscarAutorId(1);
		autor3.setNombre("BELÉN TUDÓ");
		servicioAutor.insertarAutor(autor3);
		System.out.println(autor3);
		
		//7º MOSTRAR AUTOR ANTERIOR ACTUALIZADO
		System.out.println("AUTOR ACTUALIZADO: " + autor3);
		
		//8º BUSCAR AUTOR CUYO NOMBRE CONTIENE ROWLING
		List<Libro>lista4 = new ArrayList<>();
		Autor autor4 = new Autor("JK Rowling",lista4);
		servicioAutor.insertarAutor(autor4);
		
		autores = servicioAutor.obtenerAutoresPorNombre("Rowling");
		for(Autor autor : autores) {
			System.out.println("Nombre: " + autor);
		}
		
		//9º Actualizar el título del segundo libro
		servicioLibro.ActualizarTitulo("Las paranoyas de Java", 2);
	
		//10º Mostrar los libros;
		List<Libro>libros1 = servicioLibro.obtenerLibros();
		for(Libro libro : libros1) {
			System.out.println("TODOS LOS LIBROS: " + libro);
		}
		
		//11º Eliminar el autor segundo
		servicioAutor.borrarAutor(2);
		
		//12º Mostrar todos los autores
		autores = servicioAutor.obtenerListaAutor();
		for(Autor autor : autores) {
			System.out.println("TODOS LOS AUTORES: " + autor);
		}
	}
	
	
	

}
