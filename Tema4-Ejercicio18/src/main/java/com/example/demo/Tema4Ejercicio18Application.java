package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Pasaporte;
import com.example.demo.modelo.Persona;
import com.example.demo.modelo.Proyectos;
import com.example.demo.servicios.ServicioPasaporte;
import com.example.demo.servicios.ServicioPersona;
import com.example.demo.servicios.ServicioProyecto;

@SpringBootApplication
public class Tema4Ejercicio18Application implements CommandLineRunner {
	@Autowired
    private ServicioPersona servicioPersona;

    @Autowired
    private ServicioPasaporte servicioPasaporte;

    @Autowired
    private ServicioProyecto servicioProyecto;

	public static void main(String[] args) {
		SpringApplication.run(Tema4Ejercicio18Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//1. Almacenar en BD una persona1 con nombre ‘Juan Perez’.

		Persona persona1 = new Persona();
		persona1.setNombre("Juan Perez");
		servicioPersona.crearActualizarPersona(persona1);
		
		//2. Almacenar en BD una persona2 con nombre ‘Ana Lopez’.
		Persona persona2 = new Persona();
		persona2.setNombre("Ana Lopez");
		servicioPersona.crearActualizarPersona(persona2);
		
		//3. Almacenar en BD un pasaporte1 con número ‘ABC123 ‘
		
		Pasaporte pasaporte1 = new Pasaporte();
		pasaporte1.setNumero("ABC123");
		servicioPasaporte.crearActualizarPasaporte(pasaporte1);
		
		//4. Almacenar en BD un pasaporte2 con número ‘XYZ456 ‘
		
		Pasaporte pasaporte2 = new Pasaporte();
		pasaporte2.setNumero("XYZ456");
		servicioPasaporte.crearActualizarPasaporte(pasaporte2);
		
		//5. Almacenar en BD un proyecto1 con nombre con número ‘Proyecto Alpha ‘ 
		
		Proyectos proyecto1 = new Proyectos();
		proyecto1.setNombre("Proyecto Alpha");
		servicioProyecto.crearActualizarProyecto(proyecto1);
		
		//6. Almacenar en BD un proyecto2 con nombre con número ‘Proyecto Beta ‘

		Proyectos proyecto2 = new Proyectos();
		proyecto2.setNombre("Proyecto Beta");
		servicioProyecto.crearActualizarProyecto(proyecto2);
		
		
		// 7. Asignar el pasaporte1 a la persona1
		persona1.setPasaporte(pasaporte1);
		servicioPersona.crearActualizarPersona(persona1);
		
		// 8. Asignar el pasaporte2 a la persona2
		persona2.setPasaporte(pasaporte2);
		servicioPersona.crearActualizarPersona(persona2);
		
		// 9. Asignar el proyecto1 a la persona1
		persona1.getProyectos().add(proyecto1);
		servicioPersona.crearActualizarPersona(persona1);
		
		//10. Asignar el proyecto2 a la persona1
		persona1.getProyectos().add(proyecto2);
		servicioPersona.crearActualizarPersona(persona1);
		
		//11. Asignar el proyecto1 a la persona2
		persona2.getProyectos().add(proyecto1);
		servicioPersona.crearActualizarPersona(persona2);
		
		
		//12. Obtener todas el nombre de todas las personas con los nombres de sus proyectos.
		List<Object[]> personasConProyectos = servicioPersona.obtenerNombresPersonasConProyectos();
        System.out.println("Nombres de personas con sus proyectos:");
        for (Object[] personaProyecto : personasConProyectos) {
            System.out.println("Persona: " + personaProyecto[0] + ", Proyecto: " + personaProyecto[1]);
        }
        
        
		//13. Eliminar el proyecto2 de la persona1

        servicioPersona.eliminarProyectoDePersona(persona1.getId(), proyecto2.getId());
        System.out.println("Proyecto2 eliminado de Persona1.");
        // Verificar que el proyecto ha sido eliminado
        List<Object[]> personasConProyectosActualizados = servicioPersona.obtenerNombresPersonasConProyectos();
        System.out.println("Nombres de personas con sus proyectos después de la eliminación:");
        for (Object[] personaProyecto : personasConProyectosActualizados) {
            System.out.println("Persona: " + personaProyecto[0] + ", Proyecto: " + personaProyecto[1]);
        }
		
	}

}
