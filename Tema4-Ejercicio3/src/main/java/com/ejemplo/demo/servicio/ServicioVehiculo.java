package com.ejemplo.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.demo.modelo.Vehiculo;
import com.ejemplo.demo.repositorio.RepositorioVehiculo;



@Service
public class ServicioVehiculo {

	  @Autowired
	    private RepositorioVehiculo vehiculoRepositorio;

	    public Vehiculo crearVehiculo(Vehiculo vehiculo) {
	        return vehiculoRepositorio.crearVehiculo(vehiculo);
	    }

	    public Vehiculo obtenerVehiculoPorId(Long id) {
	        return vehiculoRepositorio.obtenerVehiculoPorId(id);
	    }

	    public List<Vehiculo> obtenerTodosLosVehiculos() {
	        return vehiculoRepositorio.obtenerTodosLosVehiculos();
	    }

	    public Vehiculo actualizarVehiculo(Vehiculo vehiculo) {
	        return vehiculoRepositorio.actualizarVehiculo(vehiculo);
	    }

	    public void eliminarVehiculo(Long id) {
	        vehiculoRepositorio.eliminarVehiculo(id);
	    }

	    public Vehiculo actualizarEstado(Long id, String estado) {
	        return vehiculoRepositorio.actualizarEstado(id, estado);
	    }

	    public Vehiculo actualizarKilometraje(Long id, Double kilometraje) {
	        return vehiculoRepositorio.actualizarKilometraje(id, kilometraje);
	    }

	    public List<Vehiculo> obtenerVehiculosPorEstado(String estado) {
	        return vehiculoRepositorio.obtenerVehiculosPorEstado(estado);
	    }

	    public List<Vehiculo> filtrarVehiculosPorAnyo(Integer añoInicial, Integer añoFinal) {
	        return vehiculoRepositorio.filtrarVehiculosPorAnyo(añoInicial, añoFinal);
	    }
	
}
