package com.example.demo.servicio;

import java.util.Map;

import com.example.demo.modelo.Oficina;

public interface OficinaServicioInterfaz {

	void obtenerOficina(Oficina oficina);

	Oficina obtenerOficinaPorId(Integer id);

	Boolean eliminarOficina(Integer id);

	long contarEmpleados(Integer id);

	Map<Integer, Long> MapNumeroEmpleados(Integer id);


}
