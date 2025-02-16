package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Curso;
import com.example.demo.modelo.Estudiante;
import com.example.demo.repositorio.Repositorio;
import com.example.demo.servicio.Servicio;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@SpringBootApplication
public class Tema5EjericicioEstudianteApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Tema5EjericicioEstudianteApplication.class, args);
	}
	
	@Autowired
	private Servicio servicio;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Crear curso
		Curso daw = new Curso();
		daw.setNombre("DAW");
		daw.setDescripcion("Desarrollador Aplicaciones Web");
		
		servicio.crearActualizarCurso(daw);
		
		Curso dam = new Curso();
		dam.setNombre("DAM");
		dam.setDescripcion("Desarrollador Aplicaciones Multiplataforma");
		
		servicio.crearActualizarCurso(dam);
		
		//Crear estudiante
		Estudiante estu1 = new Estudiante();
		estu1.setNombre("Rosario");
		estu1.setEmail("rosario@correo.com");
		
		servicio.crearActualizarEstudiante(estu1);
		
		servicio.agregarEstudianteaCursos(estu1, daw);
		
		System.out.println("Curso por id " + servicio.cursoId(1));
		
		System.out.println("Estudiante por id " + servicio.estudianteId(1));
		
	System.out.println("Estos son todos los cursos: " + servicio.obtenerTodosCursos());
	System.out.println("Estos son todos los estudiantes: " + servicio.obtenerTodosEstudiante());
	
	//servicio.EliminarEstudiantedeCurso(estu1, daw);
		
	//servicio.eliminarCurso(1);
	
	servicio.actulizarEmail("rosario@ceu.com", 1);
	
	servicio.buscarEstudiantePorCadena("rosario");
	
	}

}
