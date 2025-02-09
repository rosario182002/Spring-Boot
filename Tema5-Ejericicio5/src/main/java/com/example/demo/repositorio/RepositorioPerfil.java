package com.example.demo.repositorio;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Perfil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RepositorioPerfil implements InterRepoPerfil {
	@PersistenceContext
    private EntityManager entityManager;

	@Override
    public Perfil crearGuardarPerfil(Perfil perfil) {
        if (perfil.getId() == null) {
            entityManager.persist(perfil);
            return perfil;
        } else {
            return entityManager.merge(perfil);
        }
    }

	@Override
    public Perfil obtenerPorId(Integer id) {
        return entityManager.find(Perfil.class, id);
    }

	@Override
    public void eliminar(Integer id) {
        Perfil perfil = obtenerPorId(id);
        if (perfil != null) {
            entityManager.remove(perfil);
        }
    }

}
