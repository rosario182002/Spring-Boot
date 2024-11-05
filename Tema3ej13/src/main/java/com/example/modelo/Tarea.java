package com.example.modelo;

import java.time.LocalDate;

public class Tarea {

	private String id;
	private String titulo;
	private String descripcion;
	private LocalDate fechaVencimiento;
	private String estados;
	
	
	public Tarea(String id, String titulo, String descripcion, LocalDate fechaVencimiento, String estados) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaVencimiento = fechaVencimiento;
		this.estados = estados;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}


	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}


	public String getEstados() {
		return estados;
	}


	public void setEstados(String estados) {
		this.estados = estados;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
