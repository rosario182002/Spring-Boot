package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Autor;
import com.example.demo.modelo.Libro;
import com.example.demo.repositorio.RepositorioAutor;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServicioAutor implements InterfazServicioAutor {

	@Autowired
	public RepositorioAutor repositorio;
	
	@Override
	public List<Autor> obtenerListaAutor(){
		return repositorio.obtenerListaAutores();
	}
	
	@Override
	public Autor buscarAutorId(Integer id) {
		return repositorio.buscarAutorID(id);
	}
	@Override
	public void insertarAutor(Autor autor) {
			repositorio.insertarAutor(autor);
	}
	@Override
	public void borrarAutor(Integer id) {
	     Autor autor = repositorio.buscarAutorID(id); //Guarda el autor en una variable, lo traes a local para ver si existe
	        if (autor != null) {
	            repositorio.borrarAutor(autor); // comprueba si existe y si existe lo borra
	        }
	}
    @Override
    public void añadirLibroConAutorExit(Libro libro, Integer id) {
        Autor autor = repositorio.buscarAutorID(id); //busca autor por id
        if (autor != null) { // si el autor existe
            autor.getListaLibros().add(libro); //añade libro
            repositorio.insertarAutor(autor);; //actualiza el autor
        }
    }
    
    @Override
    public void borrarLibrodeUnAutor(Libro libro, Integer id) {
    	Autor autor = repositorio.buscarAutorID(id); // busca el id del autor
    	List<Libro>libros = autor.getListaLibros(); // en esta guardamos la lista de libros
    	if(autor != null) { //comprobamos que existe el autor
    		for(Libro libro1:libros) { // recorremos la lista de libros
    			if(libro1 == libro) { //comprobamos que es el libro que hemos pasado
    				libros.remove(libro1); // borramos el libro
    				repositorio.insertarAutor(autor); // y actualizamos el autor
    			}
    		}
    	}
    }
    
    @Override
    public List<Libro> ObtenerLibrosIdAutor(Integer id){
    	Autor autor = repositorio.buscarAutorID(id);
    	if(autor != null) {
    		return autor.getListaLibros();
    	}
    	return null;
    }
    
    @Override
    public List<Autor> obtenerAutoresPorNombre(String nombre){
    	return repositorio.obtenerAutoresPorNombre(nombre);
    }
    
    @Override
    public void actualizarNombredeTodosAutoresConLibros(String nombre, String nuevo) {
    	List<Autor>autores = repositorio.obtenerListaAutores();
    	for (Autor autor : autores) {
			List<Libro> libros = autor.getListaLibros();
			for (Libro libro : libros) {
				if (libro.getTitulo().equalsIgnoreCase(nombre)) {
					autor.setNombre(nuevo);
					repositorio.insertarAutor(autor);
				}
			}
		}
    	
    }
    
    
    
	
}
