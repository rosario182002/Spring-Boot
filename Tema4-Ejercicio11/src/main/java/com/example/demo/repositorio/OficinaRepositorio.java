package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Oficina;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class OficinaRepositorio implements OficinaRepositorioInterfaz {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void obtenerOficina(Oficina oficina) {
        entityManager.persist(oficina);
    }

    @Override
    public List<Oficina> listaOficinas() {
        return entityManager.createQuery("SELECT o FROM Oficina o", Oficina.class).getResultList();
    }

    @Override
    public Oficina obtenerOficinaPorId(Integer id) {
        return entityManager.find(Oficina.class, id);
    }

    @Override
    public void borrarOficina(Oficina oficina) {
        entityManager.remove(oficina);
    }

    @Override
    public long contarEmpleados(Integer id) {
        Oficina oficina = entityManager.find(Oficina.class, id);
        return oficina.getEmpleados().size();
    }
}
