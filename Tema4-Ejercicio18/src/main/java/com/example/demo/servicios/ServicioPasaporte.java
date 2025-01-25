package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Pasaporte;
import com.example.demo.repositorio.RepositorioPasaporte;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServicioPasaporte implements InterfazServiPasaporte {
	@Autowired
	public RepositorioPasaporte repositorio;

	@Override
	public void crearActualizarPasaporte(Pasaporte pasaporte) {
		repositorio.crearActualizarPasaporte(pasaporte);
	}
	
	@Override
	public List<Pasaporte>obtenerListaPasaporte(){
		return repositorio.obtenerListaPasaporte();
	}
	
	@Override
	public Pasaporte buscarPasaportePorId(Integer id) {
		return repositorio.buscarPasaportePorId(id);
	}
	@Override
	public void borrarPasaporte(Integer id) {
		Pasaporte pasaporte = repositorio.buscarPasaportePorId(id);
		if(pasaporte != null) {
			repositorio.borrarPasaporte(pasaporte);
		}
	}


}
