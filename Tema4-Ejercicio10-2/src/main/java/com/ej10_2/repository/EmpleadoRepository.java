package com.ej10_2.repository;

import java.util.List;

import com.ej10_2.model.Empleado;

public interface EmpleadoRepository {

	List<Empleado> getEmpleados();

	void postEmpleado(Empleado empleado);

	Empleado getEmpleadoId(Integer id);

	Empleado putEmpleado(Empleado empleado);

	void deleteEmpleado(Empleado empleado);

	List<Empleado> getEmpleadosPuesto(String puesto);
}
