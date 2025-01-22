package com.example.demo.modelo;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Oficina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String ubicacion;

    @Column
    private String telefono;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Empleado> empleados = new ArrayList<>();

    // Constructor vacío
    public Oficina() {
    	
    }

 
    public Oficina(String ubicacion, String telefono) {
        this.ubicacion = ubicacion;
        this.telefono = telefono;
    }

    // Métodos para manejar la relación bidireccional
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        empleado.setOficina(this);
    }

    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
        empleado.setOficina(null);
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Oficina{id=" + id + ", ubicacion='" + ubicacion + "', telefono='" + telefono + "'}";
    }
}
