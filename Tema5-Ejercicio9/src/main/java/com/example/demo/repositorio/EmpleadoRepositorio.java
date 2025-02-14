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
	
	public List<Empleado>listaTodosEmpleados(){
		return entityManager.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
	}
	
	@Override
	public void obtenerEmpleados(Empleado empleado) {
		entityManager.persist(empleado);
	}
	
	@Override
	public Empleado obtenerEmpleadoPorId (Integer id) {
		return entityManager.find(Empleado.class, id);
	}
	@Override
	public Empleado insertarEmpleado(Empleado empleado) {
		return entityManager.find(Empleado.class, empleado);
	}
	@Override
	public Empleado actualizarEmpleado(Empleado empleado) {
		return entityManager.merge(empleado);
	}
	@Override
	public void eliminarEmpleado(Empleado empleado) {
		entityManager.remove(empleado);
	}
	@Override
	public List<Empleado> EmpleadoPuesto(String puesto){
		String jpql = "SELECT e FROM Empleado e WHERE e.puesto LIKE :puesto";
		Query<Empleado> query = (Query<Empleado>) entityManager.createQuery(jpql, Empleado.class).setParameter("puesto",
				"%" + puesto + "%");
		return query.getResultList();
	}

}
