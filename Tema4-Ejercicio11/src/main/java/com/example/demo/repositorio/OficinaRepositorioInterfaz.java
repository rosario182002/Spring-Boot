package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.modelo.Oficina;

public interface OficinaRepositorioInterfaz {

	void obtenerOficina(Oficina oficina);

	List<Oficina> listaOficinas();

	Oficina obtenerOficinaPorId(Integer id);

	void borrarOficina(Oficina oficina);

	long contarEmpleados(Integer id);

}
