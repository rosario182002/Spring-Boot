package com.ej10_2.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ej10_2.model.Empleado;
import com.ej10_2.model.Oficina;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class OficinaRepositoryImp implements OficinaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void postOficina(Oficina oficina) {
		entityManager.persist(oficina);
	}

	@Override
	public List<Oficina> getOficinas() {
		Query<Oficina> query = (Query<Oficina>) entityManager.createQuery("SELECT o FROM Oficina o", Oficina.class);
		return query.getResultList();
	}

	@Override
	public Oficina getOficinaId(Integer id) {
		return entityManager.find(Oficina.class, id);
	}

	@Override
	public void deleteOficina(Oficina oficina) {
		entityManager.remove(oficina);
	}

	@Override
	public long contarEmpleados(Integer id) {
		String jpql = "SELECT e FROM Empleado e WHERE e.oficina.id :id";
		Query<Empleado> query = (Query<Empleado>) entityManager.createQuery(jpql, Empleado.class).setParameter("id",
				id);
		return query.getResultCount();
	}

}
