package com.ej10_2.service;

import java.util.List;

import com.ej10_2.model.Empleado;

public interface EmpleadoService {

	List<Empleado> getEmpleados();

	void postEmpleado(Empleado empleado);

	Empleado getEmpleadoId(Integer id);

	Empleado putEmpleado(Integer id, Empleado emp);

	Boolean deleteEmpleado(Integer id);

	List<Empleado> getEmpleadosPuesto(String puesto);

	List<Empleado> getEmpleadosNoOficina();
}
