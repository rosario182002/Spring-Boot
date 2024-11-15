package com.ejemplo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.modelo.Vehiculo;
import com.example.servicio.ServicioVehiculo;

@RestController
@RequestMapping("/vehiculo")
public class ControladorVehiculo {
	 @Autowired
	    private ServicioVehiculo vehiculoService;

	    // Crear un nuevo vehículo
	    @PostMapping
	    public ResponseEntity<Vehiculo> crearVehiculo(@RequestBody Vehiculo vehiculo) {
	        Vehiculo vehiculoCreado = vehiculoService.crearVehiculo(vehiculo);
	        return ResponseEntity.status(201).body(vehiculoCreado);  // Devuelve 201 Created
	    }

	    // Consultar vehículo por ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Vehiculo> obtenerVehiculoPorId(@PathVariable Long id) {
	        Vehiculo vehiculo = vehiculoService.obtenerVehiculoPorId(id);
	        if (vehiculo != null) {
	            return ResponseEntity.ok(vehiculo);  // Devuelve 200 OK
	        } else {
	            return ResponseEntity.notFound().build();  // Devuelve 404 Not Found
	        }
	    }

	    // Consultar todos los vehículos
	    @GetMapping
	    public ResponseEntity<List<Vehiculo>> obtenerTodosLosVehiculos() {
	        List<Vehiculo> vehiculos = vehiculoService.obtenerTodosLosVehiculos();
	        return ResponseEntity.ok(vehiculos);  // Devuelve 200 OK
	    }

	    // Actualizar un vehículo
	/*    @PutMapping("/{id}")
	    public ResponseEntity<Vehiculo> actualizarVehiculo(@PathVariable Long id, @RequestBody Vehiculo vehiculo) {
	        Vehiculo vehiculoActualizado = vehiculoService.actualizarVehiculo(id, vehiculo);
	        if (vehiculoActualizado != null) {
	            return ResponseEntity.ok(vehiculoActualizado);  // Devuelve 200 OK
	        } else {
	            return ResponseEntity.notFound().build();  // Devuelve 404 Not Found
	        }
	    }
	*/
	    // Eliminar un vehículo
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> eliminarVehiculo(@PathVariable Long id) {
	        vehiculoService.eliminarVehiculo(id);
	        return ResponseEntity.noContent().build();  // Devuelve 204 No Content
	    }

	    // Actualizar el estado de un vehículo
	    @PatchMapping("/{id}/estado")
	    public ResponseEntity<Void> actualizarEstado(@PathVariable Long id, @RequestParam String estado) {
	        vehiculoService.actualizarEstado(id, estado);
	        return ResponseEntity.noContent().build();  // Devuelve 204 No Content
	    }

	    // Registrar kilometraje
	/*    @PatchMapping("/{id}/kilometraje")
	    public ResponseEntity<Void> registrarKilometraje(@PathVariable Long id, @RequestParam double kilometraje) {
	        vehiculoService.registrarKilometraje(id, kilometraje);
	        return ResponseEntity.noContent().build();  // Devuelve 204 No Content
	    }
*/
	    // Consultar vehículos por estado
	    @GetMapping("/estado/{estado}")
	    public ResponseEntity<List<Vehiculo>> obtenerVehiculosPorEstado(@PathVariable String estado) {
	        List<Vehiculo> vehiculos = vehiculoService.obtenerVehiculosPorEstado(estado);
	        return ResponseEntity.ok(vehiculos);  // Devuelve 200 OK
	    }

	    // Filtrar vehículos por año
   /*	    @GetMapping("/anyo")
	    public ResponseEntity<List<Vehiculo>> obtenerVehiculosPorAnyoRango(@RequestParam int anyoInicio, @RequestParam int anyoFin) {
	        List<Vehiculo> vehiculos = vehiculoService.obtenerVehiculosPorAnyoRango(anyoInicio, anyoFin);
	        return ResponseEntity.ok(vehiculos);  // Devuelve 200 OK
	    }
	*/
}
