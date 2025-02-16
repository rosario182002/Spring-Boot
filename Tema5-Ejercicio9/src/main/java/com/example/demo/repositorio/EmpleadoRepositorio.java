package com.example.demo.repositorio;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class EmpleadoRepositorio implements EmpleadoRepositorioInterfaz{

	@PersistenceContext
	private EntityManager entityManager;
	
	  @Override
	    public void guardar(Empleado empleado) {
	        if (empleado.getId() == null) {
	        	entityManager.persist(empleado);
	        } else {
	        	entityManager.merge(empleado);
	        }
	    }

	    @Override
	    public List<Empleado> obtenerEmpleados() {
	        Query<Empleado> consulta = (Query<Empleado>) entityManager.createQuery("SELECT e FROM Empleado e", Empleado.class);
	        return consulta.getResultList();
	    }

	    @Override
	    public Empleado obtenerEmpleadoPorId(Integer id) {
	        return entityManager.find(Empleado.class, id);
	    }

	    @Override
	    public void eliminarEmpleado(Empleado empleado) {
	    	entityManager.remove(empleado);
	    }

}
