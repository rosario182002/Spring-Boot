package com.example.demo;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Curso;
import com.example.demo.modelo.Estudiante;
import com.example.demo.repositorio.RepositorioEstudiante;
import com.example.demo.servicio.InterfazServiCurso;
import com.example.demo.servicio.InterfazServiEstudiante;


@SpringBootApplication
public class Tema4Ejercicio15Application {

	public static void main(String[] args) {
		SpringApplication.run(Tema4Ejercicio15Application.class, args);
	}
	@Autowired 
	InterfazServiEstudiante servicioEstudiante;
	@Autowired
	InterfazServiCurso servicioCurso;
	
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//1. Crear un curso con o sin estudiantes.
		List <Curso> curso1 = new ArrayList<>();
		Curso curso2 = new Curso();
		curso2.setNombre("JavaScript");
		servicioCurso.crearCurso(curso2);
		List <Curso> curso3 = new ArrayList<>();
		Curso curso4 = new Curso();
		curso4.setNombre("Diseño");
		servicioCurso.crearCurso(curso4);
				
		//2. Agregar un estudiante a un curso.
		Estudiante estu1 = new Estudiante();
		estu1.setNombre("Ana");
		Estudiante estu2 = new Estudiante();
		estu2.setNombre("Josema");
		
		servicioEstudiante.crearActualizarEstudiante(estu1);
		servicioEstudiante.crearActualizarEstudiante(estu2);
		
		servicioCurso.añadirEstudianteACurso(estu1, 1);
		servicioCurso.añadirEstudianteACurso(estu2, 2);
		
		//3. Consultar todos los cursos.
		List<Curso> cursos = servicioCurso.obtenerListaCursos();
		for(Curso curso : cursos) {
			System.out.println("Todos los cursos: " + curso);
		}
		
		//4. Consultar un curso por su ID
		System.out.println("Curso por Id: " + servicioCurso.buscarCursoPorId(1));
		
		//5. Buscar los cursos cuyo nombre contenga una palabra.
		List<Curso> curso5 = new ArrayList<>();
		Estudiante estu3 = new Estudiante();
		estu3.setNombre("Inma");
		servicioEstudiante.crearActualizarEstudiante(estu3);
		servicioCurso.añadirEstudianteACurso(estu3, 2);
		
		curso5 = servicioCurso.obtenerCursoNombreUnaPalabra("Inma");
		for(Curso curso : curso5) {
			System.out.println("Nombre: " + curso);
		}
		
		//6. Eliminar un estudiante de un curso.
		servicioCurso.borrarEstudianteDeUnCurso(estu3, 2);
		
		//7. Eliminar un curso dado su ID.
		servicioCurso.borrarCursoPorId(1);
		
		//1. Consultar todos los estudiantes.
		List<Estudiante> estudiantes = servicioEstudiante.obtenerEstudiantes();
		for(Estudiante estudiante : estudiantes) {
			System.out.println("Todos los estudiantes: " + estudiante);	
		}
		
		//2. Consultar un estudiante por su ID.
		System.out.println("Curso por Id: " + servicioEstudiante.obtenerEstudiantePorId(1));
		
		//3. Actualizar el email de un estudiante dado su ID.
		servicioEstudiante.ActualizarEstudiante("josema@gmail", 2);
		
		//4. Buscar estudiantes cuyo nombre contenga una cadena específica.
		/*List<Estudiante> estudiantes1 = new ArrayList<>();
		Estudiante estu4 = new Estudiante();
		estu4.setNombre("Angel");
		servicioEstudiante.crearActualizarEstudiante(estu4);
		servicioCurso.añadirEstudianteACurso(estu4, 4);
		
		estu4 = servicioEstudiante.obtenerEstudiantePorNombreConCadenaEspe("Angel");
		for(Estudiante estu : estu4 ) {
			System.out.println("Nombre: " + estu);
		}*/
		
		
		
		
		
		
	}
 }

