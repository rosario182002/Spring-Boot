package com.example.demo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Libros {
	private int id;
	private String titulo;
	private String autor;
	private String editorial;
	private String isbn;
	private Integer añoPublicacion;
	private List<String> genero;
	
	public Libros() {
		this.genero = new ArrayList<>();
	}
	
	public Libros(int id, String titulo, String autor, String editorial, String isbn, Integer añoPublicacion,List<String> genero) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.isbn = isbn;
		this.añoPublicacion = añoPublicacion;
		this.genero = genero;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getAñoPublicacion() {
		return añoPublicacion;
	}
	public void setAñoPublicacion(Integer añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}
	public List<String> getGenero() {
		return genero;
	}
	public void setGenero(List<String> generos) {
		this.genero = generos;
	}
















}
