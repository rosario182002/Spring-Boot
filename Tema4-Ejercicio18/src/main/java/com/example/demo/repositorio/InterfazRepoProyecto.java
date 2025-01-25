package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.modelo.Proyectos;

public interface InterfazRepoProyecto {

	void crearActualizarProyecto(Proyectos proyecto);

	List<Proyectos> obtenerListaProyectos();

	Proyectos buscarProyectoPorId(Integer id);

	void borrarProyectos(Proyectos proyecto);

}
