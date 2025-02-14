package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Oficina;
import com.example.demo.repositorio.OficinaRepositorio;

import jakarta.transaction.Transactional;

@Service

public class OficinaServicio implements OficinaServicioInterfaz{

	@Autowired
	private OficinaRepositorio oficinaRepositorio;
	
	@Transactional
	@Override
	public Oficina obtenerOficina (Oficina oficina) {
		return oficinaRepositorio.obtenerOficina(oficina);
	}
	@Override 
	public List<Oficina> listaOficinas() {
		return oficinaRepositorio.listaOficinas();
	}
	
	
	@Override
	public Oficina obtenerOficinaPorId(Integer id) {
		return oficinaRepositorio.obtenerOficinaPorId(id);
	}
	
	@Transactional
	@Override
	public Boolean eliminarOficina(Integer id) {
		Oficina oficina = oficinaRepositorio.obtenerOficinaPorId(id);
		if (oficina != null) {
			oficinaRepositorio.borrarOficina(oficina);
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public long contarEmpleados(Integer id) {
		return oficinaRepositorio.contarEmpleados(id);
	}
	
	@Override
	public Map<Integer, Long> MapNumeroEmpleados(Integer id) {
		long conteo = contarEmpleados(id);

		Map<Integer, Long> mapaEmpleados = new HashMap<>();
		mapaEmpleados.put(id, conteo);

		return mapaEmpleados;
	}

}
