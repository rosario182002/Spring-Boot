package com.example.demo.repositorio;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Empleado;
import com.example.demo.modelo.Oficina;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class OficinaRepositorio implements OficinaRepositorioInterfaz{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Oficina guardar(Oficina oficina) {
		if (oficina.getId() == null) {
			entityManager.persist(oficina);
		} else {
			entityManager.merge(oficina);
		}
		return oficina;
	}

	@Override
	public List<Oficina> obtenerOficinas() {
		Query<Oficina> consulta = (Query<Oficina>) entityManager.createQuery("SELECT o FROM Oficina o", Oficina.class);
		return consulta.getResultList();
	}

	@Override
	public Oficina obtenerOficinaPorId(Integer id) {
		return entityManager.find(Oficina.class, id);
	}

	@Override
	public void eliminarOficina(Oficina oficina) {
		entityManager.remove(oficina);
	}

	@Override
	public void actualizarTelefono(Integer idEmpleado, Integer telefono) {

		Empleado empleado = entityManager.find(Empleado.class, idEmpleado);
		if (empleado != null) {
			String consulta = "SELECT o FROM Oficina o JOIN o.empleados e WHERE e.id = :empleadoId";
			Oficina oficina = (Oficina) entityManager.createQuery(consulta).setParameter("empleadoId", idEmpleado)
					.getSingleResult();

			if (oficina != null) {
				oficina.setTelefono(telefono);
				entityManager.merge(oficina);
				System.out.println("Teléfono de la oficina actualizado correctamente.");
			} else {
				System.out.println("La oficina asociada no se encontró.");
			}
		} else {
			System.out.println("Empleado no encontrado.");
		}
	}


}
