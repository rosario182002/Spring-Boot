package com.ej10_2.service;

import java.util.List;
import java.util.Map;

import com.ej10_2.model.Oficina;

public interface OficinaService {

	void postOficina(Oficina oficina);

	List<Oficina> getOficinas();

	Oficina getOficinaId(Integer id);

	Boolean deleteOficina(Integer id);

	long contarEmpleados(Integer id);

	Map<Integer, Long> getMapNumeroEmpleados(Integer id);
}
