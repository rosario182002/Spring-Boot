package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.modelo.Empleado;

public interface EmpleadoRepositorioInterfaz {

	void guardar(Empleado empleado);

	List<Empleado> obtenerEmpleados();

	Empleado obtenerEmpleadoPorId(Integer id);

	void eliminarEmpleado(Empleado empleado);



}
