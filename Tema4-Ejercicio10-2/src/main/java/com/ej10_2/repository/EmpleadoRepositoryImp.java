package com.ej10_2.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ej10_2.model.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class EmpleadoRepositoryImp implements EmpleadoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Empleado> getEmpleados() {
		Query<Empleado> query = (Query<Empleado>) entityManager.createQuery("SELECT e FROM Empleado e", Empleado.class);
		return query.getResultList();
	}

	@Override
	public void postEmpleado(Empleado empleado) {
		entityManager.persist(empleado);
	}

	@Override
	public Empleado getEmpleadoId(Integer id) {
		return entityManager.find(Empleado.class, id);
	}

	@Override
	public Empleado putEmpleado(Empleado empleado) {
		return entityManager.merge(empleado);
	}

	@Override
	public void deleteEmpleado(Empleado empleado) {
		entityManager.remove(empleado);
	}

	@Override
	public List<Empleado> getEmpleadosPuesto(String puesto) {
		String jpql = "SELECT e FROM Empleado e WHERE e.puesto LIKE :puesto";
		Query<Empleado> query = (Query<Empleado>) entityManager.createQuery(jpql, Empleado.class).setParameter("puesto",
				"%" + puesto + "%");

		return query.getResultList();
	}

}
