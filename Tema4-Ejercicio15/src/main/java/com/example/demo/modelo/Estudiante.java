package com.example.demo.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String nombre;
	
	@Column 
	private String email;
	
	@ManyToMany(mappedBy = "estudiante")	
	private List<Curso> curso;
<<<<<<< HEAD
	
	public Estudiante() {
		
	}
	
	public Estudiante(String nombre, String email, List<Curso> curso) {
		super();
=======

	
	public Estudiante(Integer id, String nombre, String email, List<Curso> curso) {
		super();
		this.id = id;
>>>>>>> 4451a31c42c8c2dbbeaf9d071869701a47731704
		this.nombre = nombre;
		this.email = email;
		this.curso = new ArrayList<>();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Curso> getCurso() {
		return curso;
	}

	public void setCurso(List<Curso> curso) {
		this.curso = curso;
	}

	
	
}
