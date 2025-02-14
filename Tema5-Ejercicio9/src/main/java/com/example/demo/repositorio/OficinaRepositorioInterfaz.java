package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.modelo.Oficina;

public interface OficinaRepositorioInterfaz {

	public Oficina obtenerOficina(Oficina oficina);

	public List<Oficina> listaOficinas();

	public Oficina obtenerOficinaPorId(Integer id);

	public void borrarOficina(Oficina oficina);

	public long contarEmpleados(Integer id);

}
