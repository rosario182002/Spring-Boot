package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Empleado;


public interface EmpleadoServicioInterfaz {

	void crearEmpleado(Empleado empleado);

	List<Empleado> obtenerEmpleados();

	Empleado obtenerEmpleadoPorId(Integer id);

	void actualizarEmpleado(Integer idEmpleado, Empleado empleado);

	void eliminarEmpleado(Integer idEmpleado);

	List<Empleado> obtenerEmpleadosPorPuesto(String puesto);

	
}
