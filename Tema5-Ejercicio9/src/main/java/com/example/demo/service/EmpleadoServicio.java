package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Empleado;
import com.example.demo.repositorio.EmpleadoRepositorio;


import jakarta.transaction.Transactional;

@Service
public class EmpleadoServicio implements EmpleadoServicioInterfaz{

	@Autowired
	private EmpleadoRepositorio empleadoRepositorio;
	
	@Override
	public List<Empleado> listaEmpleados()  {
		return empleadoRepositorio.listaTodosEmpleados();
	}
	
	@Transactional
	@Override
	public void obtenerEmpleado(Empleado empleado) {
		empleadoRepositorio.obtenerEmpleados(empleado);
	}
	@Override
	public Empleado obtenerEmpleadoPorId(Integer id) {
	    return empleadoRepositorio.obtenerEmpleadoPorId(id);
	}


	public Empleado insertarEmpleado(Empleado empleado) {
		return empleadoRepositorio.insertarEmpleado(empleado);
	}
	
	@Transactional
	@Override
	public void actualizarEmpleado(Integer id, Empleado emp) {
		Empleado empleado = empleadoRepositorio.obtenerEmpleadoPorId(id);
		if (empleado != null) {
			empleado.setNombre(emp.getNombre());
			empleado.setEmail(emp.getEmail());
			empleado.setPuesto(emp.getPuesto());
			empleado.getOficina().setTelefono(emp.getOficina().getTelefono());
			empleado.getOficina().setUbicacion(emp.getOficina().getUbicacion());
		}
		 empleadoRepositorio.actualizarEmpleado(empleado);
	}

	@Transactional
	@Override
	public Boolean borrarEmpleado(Integer id) {
		Empleado empleado = empleadoRepositorio.obtenerEmpleadoPorId(id);
		if (empleado != null) {
			empleadoRepositorio.eliminarEmpleado(empleado);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Empleado> EmpleadosPuesto(String puesto) {
		return empleadoRepositorio.EmpleadoPuesto(puesto);
	}

	@Override
	public List<Empleado> EmpleadosNoOficina() {
		List<Empleado> empleados = empleadoRepositorio.listaTodosEmpleados().stream().filter(x -> x.getOficina() == null).toList();
		return empleados;
	}

	
}
