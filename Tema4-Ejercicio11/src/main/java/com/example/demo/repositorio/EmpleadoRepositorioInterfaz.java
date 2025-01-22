package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.modelo.Empleado;

public interface EmpleadoRepositorioInterfaz {

	void obtenerEmpleados(Empleado empleado);

	List<Empleado> listaTodosEmpleados();

	Empleado obtenerEmpleadoPorId(Integer id);

	Empleado actualizarEmpleado(Empleado empleado);

	void eliminarEmpleado(Empleado empleado);

	List<Empleado> EmpleadoPuesto(String puesto);



}
