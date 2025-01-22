package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Hotel;
import com.example.demo.repository.RepositorioHotel;



@Service
public class ServicioHotel {
	  @Autowired
	    private RepositorioHotel hotelRepository;

	    public Hotel guardarHotel(Hotel hotel) {
	        return hotelRepository.guardarHotel(hotel);
	    }

	    public List<Hotel> obtenerTodosLosHoteles() {
	        return hotelRepository.obtenerTodosLosHoteles();
	    }

	    public Optional<Hotel> obtenerHotelPorId(Long id) {
	        return hotelRepository.buscarHotelPorId(id);
	    }

	    public Hotel actualizarHotel(Hotel hotel) {
	        return hotelRepository.actualizarHotel(hotel);
	    }

	    public void eliminarHotelPorId(Long id) {
	        hotelRepository.eliminarHotelPorId(id);
	    }

	    public List<Hotel> obtenerHotelesPorRangoEstrellas(int min, int max) {
	        return hotelRepository.buscarHotelesPorRangoEstrellas(min, max);
	    }

	    public Optional<Hotel> obtenerHotelPorTelefono(String telefono) {
	        return hotelRepository.buscarHotelPorTelefono(telefono);
	    }

	    public void eliminarHotelesPorNombre(String nombre) {
	        hotelRepository.eliminarHotelesPorNombreConteniendo(nombre);
	    }

	    public List<Hotel> guardarListaDeHoteles(List<Hotel> hoteles) {
	        return hotelRepository.guardarListaDeHoteles(hoteles);
	    }
}
