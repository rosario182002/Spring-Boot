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
	
	@ManyToMany(mappedBy = "proyectos") //esto es el atributo que esta en la clase Persona en la lista
	private List<Persona> persona;
	
	public Proyectos() {
		
	}
	
	public Proyectos(Integer id, String nombre, List<Persona> persona) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.persona = persona;
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

	public List<Persona> getPersonas() {
		return persona;
	}

	public void setPersonas(List<Persona> persona) {
		this.persona = persona;
	}
	
	

}