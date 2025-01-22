package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.Empleado;


public interface EmpleadoServicioInterfaz {

	public List<Empleado> listaEmpleados();
	public void obtenerEmpleado(Empleado empleado);
	public Empleado insertarEmpleado(Integer id);
	public void actualizarEmpleado(Integer id, Empleado emp);
	public Boolean borrarEmpleado(Integer id);
	public List<Empleado> EmpleadosPuesto(String puesto);
	public List<Empleado> EmpleadosNoOficina();
}
