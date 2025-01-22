package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.modelo.Empleado;

public interface EmpleadoRepositorioInterfaz {

	public List<Empleado>listaTodosEmpleados();
	public void obtenerEmpleados(Empleado empleado);
	public Empleado insertarEmpleado(Integer id);
	public Empleado actualizarEmpleado(Empleado empleado);
	public void eliminarEmpleado(Empleado empleado);
	public List<Empleado> EmpleadoPuesto(String puesto);
	public Empleado obtenerEmpleadoPorId(Integer id);
	

}
