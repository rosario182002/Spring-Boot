package com.example.demo.modelo;
public class User {

	private String nombre;
	private Integer edad;
	
	public User() {
		
	}
	
	public User(String nombre, Integer edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	
}
