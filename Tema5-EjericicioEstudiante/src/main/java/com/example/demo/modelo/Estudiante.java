package com.example.demo.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "estudiante")
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String nombre;
	
	@Column 
	private String email;

	@ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "curos-estudiante", joinColumns = { @JoinColumn(name = "id_estudiante") }, inverseJoinColumns = {
			@JoinColumn(name = "id_curso") })
	private List<Curso>cursos;

	public Estudiante() {
		
	}
	
	
	public Estudiante(String nombre, String email, List<Curso> cursos) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.cursos = cursos;
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

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}


	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", email=" + email +"]";
	}
	
	
	

}
