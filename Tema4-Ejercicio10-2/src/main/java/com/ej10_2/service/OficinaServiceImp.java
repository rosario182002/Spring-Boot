package com.ej10_2.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ej10_2.model.Oficina;
import com.ej10_2.repository.OficinaRepositoryImp;

@Service
public class OficinaServiceImp implements OficinaService{

	@Autowired
	private OficinaRepositoryImp repository;

	@Transactional
	@Override
	public void postOficina(Oficina oficina) {
		repository.postOficina(oficina);

	}

	@Override
	public List<Oficina> getOficinas() {
		return repository.getOficinas();
	}

	@Override
	public Oficina getOficinaId(Integer id) {
		return repository.getOficinaId(id);
	}

	@Transactional
	@Override
	public Boolean deleteOficina(Integer id) {
		Oficina oficina = repository.getOficinaId(id);
		if (oficina != null) {
			repository.deleteOficina(oficina);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public long contarEmpleados(Integer id) {
		return repository.contarEmpleados(id);
	}

	@Override
	public Map<Integer, Long> getMapNumeroEmpleados(Integer id) {
		long conteo = contarEmpleados(id);

		Map<Integer, Long> mapaEmpleados = new HashMap<>();
		mapaEmpleados.put(id, conteo);

		return mapaEmpleados;
	}

}
