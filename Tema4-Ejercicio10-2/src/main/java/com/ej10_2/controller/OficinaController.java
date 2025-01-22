package com.ej10_2.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ej10_2.model.Oficina;
import com.ej10_2.service.OficinaServiceImp;

@RestController
@RequestMapping("/api/oficina")
public class OficinaController {

	@Autowired
	private OficinaServiceImp servicio;

	// 1 - Crear una oficina.
	@PostMapping
	public ResponseEntity<Void> postOficina(@RequestBody Oficina oficina) {
		servicio.postOficina(oficina);
		return ResponseEntity.noContent().build();
	}

	// 2 - Consultar todas las oficinas.
	@GetMapping
	public ResponseEntity<List<Oficina>> getOficinas() {
		List<Oficina> oficinas = servicio.getOficinas();
		if (oficinas.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(oficinas);
		}
	}

	// 3 - Consultar una oficina por su id.
	@GetMapping("/{id}")
	public ResponseEntity<Oficina> getOficinaId(@PathVariable Integer id) {
		Oficina oficina = servicio.getOficinaId(id);
		if (oficina == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(oficina);
		}
	}

	// 4 - Eliminar una oficina por su id.
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOficina(@PathVariable Integer id) {
		Boolean oficina = servicio.deleteOficina(id);
		if (oficina) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// 5 - Contar el número de empleados de una oficinas.
	@GetMapping("/numEmpleados")
	public ResponseEntity<Long> contarEmpleados(@PathVariable Integer id) {
		long numEmpleados = servicio.contarEmpleados(id);

		return ResponseEntity.ok(numEmpleados);
	}

	// 6 - Devolver un mapa donde la clave es el id de la oficina y el valor el
	// número de empleados que tiene esa oficina.
	@GetMapping("/mapa-empleados/{id}")
	public ResponseEntity<Map<Integer, Long>> getMapNumeroEmpleados(@PathVariable Integer id) {
		Map<Integer, Long> mapaOficina = servicio.getMapNumeroEmpleados(id);

		return ResponseEntity.ok(mapaOficina);
	}

	// 7 - Devolver el listado de oficinas de más de N empleados.

}
