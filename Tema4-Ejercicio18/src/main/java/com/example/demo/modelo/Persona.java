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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import jakarta.persistence.JoinTable;


@Entity
@Table(name = "persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id_persona;
	
	@Column 
	private String nombre;
	
	@OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
	private Pasaporte pasaporte;
	
	@ManyToMany
	@JoinTable(name = "persona_proyecto", 
		joinColumns = {@JoinColumn(name="id_persona")},
		inverseJoinColumns = {@JoinColumn(name ="id_proyecto")})
	private List<Proyectos> proyectos = new ArrayList<>();
	
	
	
	public Persona() {
		
	}

	public Persona(Integer id_persona, String nombre, Pasaporte pasaporte, List<Proyectos> proyectos) {
		super();
		this.id_persona = id_persona;
		this.nombre = nombre;
		this.pasaporte = pasaporte;
		this.proyectos = proyectos;
	}




	public Integer getId() {
		return id_persona;
	}



	public void setId(Integer id_persona) {
		this.id_persona = id_persona;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Pasaporte getPasaporte() {
		return pasaporte;
	}



	public void setPasaporte(Pasaporte pasaporte) {
		this.pasaporte = pasaporte;
	}



	public List<Proyectos> getProyectos() {
		return proyectos;
	}



	public void setProyectos(List<Proyectos> proyectos) {
		this.proyectos = proyectos;
	}
	
	


}
