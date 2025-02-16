package com.example.demo.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "oficina")
public class Oficina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String ubicacion;

	@Column
	private Integer telefono;

	// El eager se utiliza para traer todos los datos de una lista, sino quiero traer todos los datos uso el lazy
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "oficina_id")
	private List<Empleado> empleados;

	public Oficina() {

	}

	public Oficina(String ubicacion, Integer telefono, List<Empleado> empleados) {
		super();
		this.empleados = new ArrayList<>();
		this.ubicacion = ubicacion;
		this.telefono = telefono;
		this.empleados = empleados;
	}

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

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
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
		return "Oficina [id=" + id + ", ubicacion=" + ubicacion + ", telefono=" + telefono + ", empleados=" + empleados
				+ "]";
	}

	
}
