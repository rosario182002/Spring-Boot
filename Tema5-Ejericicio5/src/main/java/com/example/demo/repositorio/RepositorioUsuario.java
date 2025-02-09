package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RepositorioUsuario implements InterRepoUsuario{
	
	@PersistenceContext
	private EntityManager entityManager; 
	
	@Override
	public List<Usuario> obtenerTodosLosUsuarios(){
		return entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
	}
	
	@Override
	public Usuario obtenerUsuarioPorId(Integer id) {
		return entityManager.find(Usuario.class, id);
	}
	
	
	@Override
	public Usuario crearGuardarUsuario(Usuario usuario) {
		if(usuario.getId() == null) {
			entityManager.persist(usuario);
			return usuario;
		}else {
			return entityManager.merge(usuario);
		}
		
	}
	
	@Override
	public void eliminarUsuario(Integer id) {
		Usuario usuario = obtenerUsuarioPorId(id);
		if(usuario != null) {
			entityManager.remove(usuario);
		}
	}
	
	@Override
	public List<Usuario>obtenerPorBiografiaContenido(String palabra){
		return entityManager.createQuery("SELECT u FROM Usuario u WHERE u.perfil.bio LIKE :palabra", Usuario.class).setParameter("palabra","%" + palabra + "%").getResultList();
	}

	@Override
	public Usuario obtenerPrimeroPorEstadoDelPerfil(String estado) {
        List<Usuario> resultList = entityManager.createQuery(
                        "SELECT u FROM Usuario u WHERE u.perfil.estado = :estado", Usuario.class)
                .setParameter("estado", estado)
                .setMaxResults(1) //esto es por que quiero solo el 1 que salga si lo quisiera todos no le pondria nada
                .getResultList();
        return resultList.isEmpty() ? null : resultList.get(0); //Me dice si esta vacia la lista lo esta me devuelve null sino lo esta me devuelve el primer usuario que encuentre
    }
	@Override
    public List<Usuario> obtenerPorEstadoDelPerfil(String estado) {
        return entityManager.createQuery(
                        "SELECT u FROM Usuario u WHERE u.perfil.estado = :estado", Usuario.class)
                .setParameter("estado", estado)
                .getResultList();
    }
}
