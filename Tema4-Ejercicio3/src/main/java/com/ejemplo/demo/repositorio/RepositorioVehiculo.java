package com.ejemplo.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ejemplo.demo.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RepositorioVehiculo {

	 @PersistenceContext
	    private EntityManager entityManager;

	    // Crear un nuevo vehículo
	    public Vehiculo crearVehiculo(Vehiculo vehiculo) {
	        entityManager.persist(vehiculo);
	        return vehiculo;
	    }

	    // Obtener un vehículo por su ID
	    public Vehiculo obtenerVehiculoPorId(Long id) {
	        return entityManager.find(Vehiculo.class, id);
	    }

	    // Obtener todos los vehículos
	    public List<Vehiculo> obtenerTodosLosVehiculos() {
	        return entityManager.createQuery("FROM Vehiculo", Vehiculo.class).getResultList();
	    }

	    // Actualizar un vehículo
	    public Vehiculo actualizarVehiculo(Vehiculo vehiculo) {
	        return entityManager.merge(vehiculo);
	    }

	    // Eliminar un vehículo
	    public void eliminarVehiculo(Long id) {
	        Vehiculo vehiculo = obtenerVehiculoPorId(id);
	        if (vehiculo != null) {
	            entityManager.remove(vehiculo);
	        }
	    }

	    // Cambiar el estado de un vehículo
	    public Vehiculo actualizarEstado(Long id, String estado) {
	        Vehiculo vehiculo = obtenerVehiculoPorId(id);
	        if (vehiculo != null) {
	            vehiculo.setEstado(estado);
	            return entityManager.merge(vehiculo);
	        }
	        return null;
	    }

	    // Registrar kilometraje
	    public Vehiculo actualizarKilometraje(Long id, Double kilometraje) {
	        Vehiculo vehiculo = obtenerVehiculoPorId(id);
	        if (vehiculo != null) {
	            vehiculo.setKilometraje(kilometraje);
	            return entityManager.merge(vehiculo);
	        }
	        return null;
	    }

	    // Obtener vehículos por estado
	    public List<Vehiculo> obtenerVehiculosPorEstado(String estado) {
	        return entityManager.createQuery("FROM Vehiculo v WHERE v.estado = :estado", Vehiculo.class)
	                .setParameter("estado", estado)
	                .getResultList();
	    }

	    // Filtrar vehículos por año
	    public List<Vehiculo> filtrarVehiculosPorAnyo(Integer añoInicial, Integer añoFinal) {
	        return entityManager.createQuery("FROM Vehiculo v WHERE v.anyo BETWEEN :añoInicial AND :añoFinal", Vehiculo.class)
	                .setParameter("añoInicial", añoInicial)
	                .setParameter("añoFinal", añoFinal)
	                .getResultList();
	    }
	
	
}
