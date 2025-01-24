package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RepositorioHotel {

	 @PersistenceContext
	    private EntityManager entityManager;

	    public Hotel guardarHotel(Hotel hotel) {
	        entityManager.persist(hotel);
	        return hotel;
	    }

	    public List<Hotel> obtenerTodosLosHoteles() {
	        return entityManager.createQuery("SELECT h FROM Hotel h", Hotel.class).getResultList();
	    }

	    public Optional<Hotel> buscarHotelPorId(Long id) {
	        Hotel hotel = entityManager.find(Hotel.class, id);
	        return Optional.ofNullable(hotel);
	    }

	    public Hotel actualizarHotel(Hotel hotel) {
	        return entityManager.merge(hotel);
	    }

	    public void eliminarHotelPorId(Long id) {
	        Hotel hotel = entityManager.find(Hotel.class, id);
	        if (hotel != null) {
	            entityManager.remove(hotel);
	        }
	    }

	    public List<Hotel> buscarHotelesPorRangoEstrellas(int min, int max) {
	        return entityManager.createQuery("SELECT h FROM Hotel h WHERE h.estrellas BETWEEN :min AND :max", Hotel.class)
	                .setParameter("min", min)
	                .setParameter("max", max)
	                .getResultList();
	    }

	    public Optional<Hotel> buscarHotelPorTelefono(String telefono) {
	        return entityManager.createQuery("SELECT h FROM Hotel h WHERE h.telefono = :telefono", Hotel.class)
	                .setParameter("telefono", telefono)
	                .getResultStream()
	                .findFirst();
	    }

	    public void eliminarHotelesPorNombreConteniendo(String nombre) {
	        entityManager.createQuery("DELETE FROM Hotel h WHERE h.nombre LIKE :nombre")
	                .setParameter("nombre", "%" + nombre + "%")
	                .executeUpdate();
	    }

	    public List<Hotel> guardarListaDeHoteles(List<Hotel> hoteles) {
	        for (Hotel hotel : hoteles) {
	            entityManager.persist(hotel);
	        }
	        return hoteles;
	    }
	
	
	
}
