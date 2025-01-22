package com.ej10_2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ej10_2.model.Empleado;
import com.ej10_2.repository.EmpleadoRepository;

import jakarta.transaction.Transactional;

@Service
public class EmpleadoServiceImp implements EmpleadoService {

	@Autowired
	private EmpleadoRepository repository;

	@Override
	public List<Empleado> getEmpleados() {
		return repository.getEmpleados();
	}

	@Transactional
	@Override
	public void postEmpleado(Empleado empleado) {
		repository.postEmpleado(empleado);
	}

	@Override
	public Empleado getEmpleadoId(Integer id) {
		return repository.getEmpleadoId(id);
	}

	@Transactional
	@Override
	public Empleado putEmpleado(Integer id, Empleado emp) {
		Empleado empleado = repository.getEmpleadoId(id);
		if (empleado != null) {
			empleado.setNombre(emp.getNombre());
			empleado.setEmail(emp.getEmail());
			empleado.setPuesto(emp.getPuesto());
			empleado.getOficina().setTelefono(emp.getOficina().getTelefono());
			empleado.getOficina().setUbicacion(emp.getOficina().getUbicacion());
		}
		return repository.putEmpleado(empleado);
	}

	@Transactional
	@Override
	public Boolean deleteEmpleado(Integer id) {
		Empleado empleado = repository.getEmpleadoId(id);
		if (empleado != null) {
			repository.deleteEmpleado(empleado);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Empleado> getEmpleadosPuesto(String puesto) {
		return repository.getEmpleadosPuesto(puesto);
	}

	@Override
	public List<Empleado> getEmpleadosNoOficina() {
		List<Empleado> empleados = repository.getEmpleados().stream().filter(x -> x.getOficina() == null).toList();
		return empleados;
	}

}
