package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.Empleado;

public interface EmpleadoServicioInterfaz {

	List<Empleado> listaEmpleados();

	void obtenerEmpleado(Empleado empleado);

	void actualizarEmpleado(Integer id, Empleado emp);

	Boolean borrarEmpleado(Integer id);

	List<Empleado> EmpleadosPuesto(String puesto);

}
