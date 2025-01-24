package com.example.demo.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table (name= "proyectos")
public class Proyectos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String nombre;
	
	@ManyToMany(mappedBy = "id_proyectos")
	private List<Proyectos> proyectos;
	
	public Proyectos() {
		
	}
	
	public Proyectos(Integer id, String nombre, List<Proyectos> proyectos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.proyectos = proyectos;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Proyectos> getPersonas() {
		return proyectos;
	}

	public void setPersonas(List<Proyectos> proyectos) {
		this.proyectos = proyectos;
	}
	
	

}