package Ejercicio11;

public class Curso {

	private String nombre;
	private double duracion;
	private int numeroDeVideos;
	private int numeroDeAlumnos;
	
	
	public Curso(String nombre, double duracion, int numeroDeVideos, int numeroDeAlumnos) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.numeroDeVideos = numeroDeVideos;
		this.numeroDeAlumnos = numeroDeAlumnos;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getDuracion() {
		return duracion;
	}


	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}


	public int getNumeroDeVideos() {
		return numeroDeVideos;
	}


	public void setNumeroDeVideos(int numeroDeVideos) {
		this.numeroDeVideos = numeroDeVideos;
	}


	public int getNumeroDeAlumnos() {
		return numeroDeAlumnos;
	}


	public void setNumeroDeAlumnos(int numeroDeAlumnos) {
		this.numeroDeAlumnos = numeroDeAlumnos;
	}


	@Override
	public String toString() {
		return  nombre + ": " + duracion + " horas";
	}
	
	
	
	
}
