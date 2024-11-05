package com.example.controles;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.modelo.Tarea;


//IMPORTANTE
@RestController
@RequestMapping("/tareas") // IMPORTANTE
public class DatosTareaControles {

	private List<Tarea> tareas = new ArrayList<>();

	public DatosTareaControles() {

		Tarea t1 = new Tarea("1", "JavaScript", "Hacer la act 14", LocalDate.of(2024, 10, 23), "PENDIENTE");
		Tarea t2 = new Tarea("2", "PHP", "Terminar actividad de la cerveza", LocalDate.of(2024, 10, 23),
				"EN_PROCESO");
		Tarea t3 = new Tarea("3", "Inglés", "Correo Formal", LocalDate.of(2024, 10, 21), "TERMINADO");
		Tarea t4 = new Tarea("4", "Diseño de Interfaz", "Terminar Actividad 3", LocalDate.of(2024, 10, 27),
				"EN_PROCESO");

		tareas.add(t1);
		tareas.add(t2);
		tareas.add(t3);
		tareas.add(t4);

	}

	@GetMapping
	public ResponseEntity<List<Tarea>> getTareas() { // Muestra todos las Tareas
		return ResponseEntity.ok(tareas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tarea> getTareas(@PathVariable String id) { //Consulta tarea por su id
	    for (Tarea tarea : tareas) {
	        if (tarea.getId().equalsIgnoreCase(id)) {
	             return ResponseEntity.ok(tarea);
	        }
	    }
	    return ResponseEntity.notFound().build();
	}
	@PostMapping
	public ResponseEntity<Tarea> postTarea(@RequestBody Tarea tarea1) { //crear libro
		tareas.add(tarea1);
		return ResponseEntity.noContent().build();
		
	}
	@PutMapping
	public ResponseEntity<Tarea> putAlumnos(@RequestBody Tarea modif) { //modifica a los libros 
		for(Tarea tarea1 : tareas) {
			if(tarea1.getId()== modif.getId()) {
				tarea1.setTitulo(modif.getTitulo());
				tarea1.setDescripcion(modif.getDescripcion() );
				
				
				return ResponseEntity.noContent().build();
			}
			
		}
		return ResponseEntity.notFound().build();
		
	}


}
