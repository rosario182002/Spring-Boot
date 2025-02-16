package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.modelo.Oficina;

public interface OficinaRepositorioInterfaz {

	Oficina guardar(Oficina oficina);

	List<Oficina> obtenerOficinas();

	Oficina obtenerOficinaPorId(Integer id);

	void eliminarOficina(Oficina oficina);

	void actualizarTelefono(Integer idEmpleado, Integer telefono);



}
