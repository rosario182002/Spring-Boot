package com.example.demo.modelo;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Deporte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private String nombre;
	
	@ManyToMany(mappedBy = "deporte")
	private Set<Deportista> deportistas;
	
	public Deporte() {
		
	}

	public Deporte(Long id, String nombre, Set<Deportista> deportistas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.deportistas = deportistas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Deportista> getDeportistas() {
		return deportistas;
	}

	public void setDeportistas(Set<Deportista> deportistas) {
		this.deportistas = deportistas;
	}
	
	@Override
    public String toString() {
        return nombre;
    }
	

}
