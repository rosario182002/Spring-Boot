package com.example.demo.servicios;

import java.util.List;

import com.example.demo.modelo.Proyectos;

public interface InterfazServiProyecto {

	void crearActualizarProyecto(Proyectos proyecto);

	List<Proyectos> obtenerListaProyecto();

	Proyectos buscarProyectoId(Integer id);

	void borrarProyecto(Integer id);

}
