package com.example.demo.repositorio;

import com.example.demo.modelo.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpleadoRepositorio implements EmpleadoRepositorioInterfaz {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void obtenerEmpleados(Empleado empleado) {
        entityManager.persist(empleado);
    }

    @Override
    public List<Empleado> listaTodosEmpleados() {
        return entityManager.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
    }

    @Override
    public Empleado obtenerEmpleadoPorId(Integer id) {
        return entityManager.find(Empleado.class, id);
    }

    @Override
    public Empleado actualizarEmpleado(Empleado empleado) {
        return entityManager.merge(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        if (entityManager.contains(empleado)) {
            entityManager.remove(empleado);
        } else {
            entityManager.remove(entityManager.merge(empleado));
        }
    }

    @Override
    public List<Empleado> EmpleadoPuesto(String puesto) {
        return entityManager.createQuery("SELECT e FROM Empleado e WHERE e.puesto = :puesto", Empleado.class)
                .setParameter("puesto", puesto)
                .getResultList();
    }
}
