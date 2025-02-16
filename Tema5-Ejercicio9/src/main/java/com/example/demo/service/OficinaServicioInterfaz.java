package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.modelo.Oficina;

public interface OficinaServicioInterfaz {


	Oficina crearOficina(Oficina oficina);

	List<Oficina> obtenerOficinas();

	Oficina obtenerOficinaPorId(Integer id);

	void eliminarOficina(Integer id);

	Integer obtenerNumeroEmpleadosOficina(Integer idOficina);

	Map<Integer, Long> obtenerMapaOficinasConEmpleados();

	List<Oficina> obtenerOficinasConMasDeNEmpleados(Integer cantidad);

	void actualizarTelefono(Integer idEmpleado, Integer telefono);

	

}
