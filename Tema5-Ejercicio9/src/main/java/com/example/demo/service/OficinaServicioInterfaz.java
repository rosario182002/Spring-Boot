package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.modelo.Oficina;

public interface OficinaServicioInterfaz {

	Oficina obtenerOficina(Oficina oficina);

	Oficina obtenerOficinaPorId(Integer id);

	Boolean eliminarOficina(Integer id);

	long contarEmpleados(Integer id);

	Map<Integer, Long> MapNumeroEmpleados(Integer id);

	List<Oficina> listaOficinas();


}
