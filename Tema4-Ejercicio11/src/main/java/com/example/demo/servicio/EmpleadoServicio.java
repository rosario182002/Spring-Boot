package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Empleado;
import com.example.demo.repositorio.EmpleadoRepositorio;

import jakarta.transaction.Transactional;

@Service
public class EmpleadoServicio implements EmpleadoServicioInterfaz {

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    @Override
    public List<Empleado> listaEmpleados() {
        return empleadoRepositorio.listaTodosEmpleados();
    }

    @Transactional
    @Override
    public void obtenerEmpleado(Empleado empleado) {
        empleadoRepositorio.obtenerEmpleados(empleado);
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
        }
        empleadoRepositorio.actualizarEmpleado(empleado);
    }

    @Transactional
    @Override
    public Boolean borrarEmpleado(Integer id) {
        Empleado empleado = empleadoRepositorio.obtenerEmpleadoPorId(id);
        if (empleado != null) {
            empleado.getOficina().eliminarEmpleado(empleado);
            empleadoRepositorio.eliminarEmpleado(empleado);
            return true;
        }
        return false;
    }

    @Override
    public List<Empleado> EmpleadosPuesto(String puesto) {
        return empleadoRepositorio.EmpleadoPuesto(puesto);
    }
}