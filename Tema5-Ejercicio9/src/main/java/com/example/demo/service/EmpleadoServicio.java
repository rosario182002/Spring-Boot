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
	private EmpleadoRepositorio repositorio;

	@Override
	public void crearEmpleado(Empleado empleado) {
		repositorio.guardar(empleado);
	}

	@Override
	public List<Empleado> obtenerEmpleados() {
		return repositorio.obtenerEmpleados(); // Cambiado a obtenerTodos
	}

	@Override
	public Empleado obtenerEmpleadoPorId(Integer id) {
		return repositorio.obtenerEmpleadoPorId(id); // Cambiado a obtenerPorId
	}

	@Transactional
	@Override
	public void actualizarEmpleado(Integer idEmpleado, Empleado empleado) {
		Empleado emp = repositorio.obtenerEmpleadoPorId(idEmpleado); // Cambiado a obtenerPorId
		if (emp != null) {
			empleado.setId(idEmpleado);
			repositorio.guardar(empleado); // Cambiado a guardar
		}
	}

	@Transactional
	@Override
	public void eliminarEmpleado(Integer idEmpleado) {
		Empleado empleado = repositorio.obtenerEmpleadoPorId(idEmpleado); // Cambiado a obtenerPorId
		if (empleado != null) {
			repositorio.eliminarEmpleado(empleado); // Cambiado a eliminar
		}
	}

	@Override
	public List<Empleado> obtenerEmpleadosPorPuesto(String puesto) {
		List<Empleado> empleados = repositorio.obtenerEmpleados().stream() // Cambiado a obtenerTodos
				.filter(usuario -> usuario.getPuesto().equalsIgnoreCase(puesto)).toList();
		return empleados;
	}
}
