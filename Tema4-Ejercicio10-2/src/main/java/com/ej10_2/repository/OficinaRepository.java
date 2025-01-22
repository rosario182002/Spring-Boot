package com.ej10_2.repository;

import java.util.List;

import com.ej10_2.model.Oficina;

public interface OficinaRepository {

	void postOficina(Oficina oficina);
	
	List<Oficina> getOficinas();
	
	Oficina getOficinaId(Integer id);
	
	void deleteOficina(Oficina oficina);
	
	long contarEmpleados(Integer id);
}
