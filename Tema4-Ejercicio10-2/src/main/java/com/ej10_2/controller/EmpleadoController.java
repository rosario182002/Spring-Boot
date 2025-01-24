package com.ej10_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ej10_2.model.Empleado;
import com.ej10_2.service.EmpleadoServiceImp;

@RestController
@RequestMapping("api/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoServiceImp servicio;

	// Crear un empleado con o sin oficina asociada
	@PostMapping
	public ResponseEntity<Void> postEmpleado(@RequestBody Empleado empleado) {
		servicio.postEmpleado(empleado);
		return ResponseEntity.noContent().build();
	}

	// Consultar todos los empleados.
	@GetMapping
	public ResponseEntity<List<Empleado>> getEmpleados() {
		List<Empleado> empleados = servicio.getEmpleados();
		if (empleados.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(empleados);
		}
	}

	// Consultar un empleado por su id.
	@GetMapping("/{id}")
	public ResponseEntity<Empleado> getEmpleadoId(@PathVariable Integer id) {
		Empleado empleado = servicio.getEmpleadoId(id);
		if (empleado == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(empleado);
		}
	}

	// Actualizar la información de un empleado, incluyendo la oficina asociada.
	@PutMapping("/{id}")
	public ResponseEntity<Void> putEmpleado(@PathVariable Integer id, @RequestBody Empleado emp) {
		Empleado empleado = servicio.putEmpleado(id, emp);
		if (empleado == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	// Eliminar un empleado por su id.
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmpleado(@PathVariable Integer id) {
		Boolean empleado = servicio.deleteEmpleado(id);
		if (empleado) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Devolver todos los empleados que tengan un puesto especifico.
	@GetMapping("/puesto/{puesto}")
	public ResponseEntity<List<Empleado>> getEmpleadosPuesto(@PathVariable String puesto) {
		List<Empleado> empleados = servicio.getEmpleadosPuesto(puesto);
		if (empleados.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(empleados);
		}
	}

	// Devolver todos los empleados que no tengan oficina.
	@GetMapping("/no-oficina")
	public ResponseEntity<List<Empleado>> getEmpleadosNoOficina() {
		List<Empleado> empleados = servicio.getEmpleadosNoOficina();
		if (empleados.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(empleados);
		}
	}

}
