package com.example.demo.modelo;

import java.util.List;

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
	private Integer id;
	
	@Column 
	private String nombre;
	
	@OneToOne
	@JoinColumn(name = "id_pasaporte")
	private Pasaporte pasaporte;
	
	@ManyToMany
	@JoinTable(name = "persona_proyecto", 
		joinColumns = {@JoinColumn(name="id_persona")},
		inverseJoinColumns = {@JoinColumn(name ="id_proyecto")})
	private List<Pasaporte> pasaportes;
	
	
	
	public Persona() {
		
	}

	public Persona(Integer id, String nombre, Pasaporte pasaporte, List<Pasaporte> pasaportes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pasaporte = pasaporte;
		this.pasaportes = pasaportes;
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



	public Pasaporte getPasaporte() {
		return pasaporte;
	}



	public void setPasaporte(Pasaporte pasaporte) {
		this.pasaporte = pasaporte;
	}



	public List<Pasaporte> getPasaportes() {
		return pasaportes;
	}



	public void setPasaportes(List<Pasaporte> pasaportes) {
		this.pasaportes = pasaportes;
	}
	
	


}
