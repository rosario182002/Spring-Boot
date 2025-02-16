package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Empleado;
import com.example.demo.modelo.Oficina;
import com.example.demo.repositorio.OficinaRepositorio;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class OficinaServicio implements OficinaServicioInterfaz {

	@Autowired
	private OficinaRepositorio repositorio;


	@Override
	public Oficina crearOficina(Oficina oficina) {
		return repositorio.guardar(oficina);
	}

	@Override
	public List<Oficina> obtenerOficinas() {
		return repositorio.obtenerOficinas();
	}

	@Override
	public Oficina obtenerOficinaPorId(Integer id) {
		return repositorio.obtenerOficinaPorId(id);
	}

	@Transactional
	@Override
	public void eliminarOficina(Integer id) {
		Oficina oficina = repositorio.obtenerOficinaPorId(id);
		if (oficina != null) {
			repositorio.eliminarOficina(oficina);
		}
	}

	@Override
	public Integer obtenerNumeroEmpleadosOficina(Integer idOficina) {
		Oficina oficina = repositorio.obtenerOficinaPorId(idOficina);
		return oficina.getEmpleados().size();
	}

	@Override
	public Map<Integer, Long> obtenerMapaOficinasConEmpleados() {
		return repositorio.obtenerOficinas().stream()
				.collect(Collectors.toMap(Oficina::getId, oficina -> (long) oficina.getEmpleados().size()));
	}

	@Override
	public List<Oficina> obtenerOficinasConMasDeNEmpleados(Integer cantidad) {
		List<Oficina> oficinas = repositorio.obtenerOficinas();
		List<Oficina> ofi = new ArrayList<>();
		for (Oficina oficina : oficinas) {
			if (oficina.getEmpleados().size() > cantidad) {
				ofi.add(oficina);
			}
		}
		return ofi;
	}

	@Transactional
	@Override
	public void actualizarTelefono(Integer idEmpleado, Integer telefono) {
		repositorio.actualizarTelefono(idEmpleado, telefono);
	}



}