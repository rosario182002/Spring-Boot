package com.example.demo.controles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.modelo.Libros;

//IMPORTANTE
@RestController  
@RequestMapping("/libros") //IMPORTANTE
public class DatosLibrosControles {
	
	private List <Libros> libros = new ArrayList<>();
	public DatosLibrosControles() {
		
		List<String> genero1 = new ArrayList<>();
		genero1.add("romance");
		List<String> genero2 = new ArrayList<>();
		genero2.add("novela");
		List<String> genero3 = new ArrayList<>();
		genero3.add("comedia");
		List<String> genero4 = new ArrayList<>();
		genero4.add("novela");
		
		
		Libros l1 = new Libros(123,"El Gato con Botas","juan","El planeta","12345678", 1898, genero1);
		Libros l2 = new Libros(111,"ALOHA","pepe","El mundo","9874561", 1999, genero2);
		Libros l3 = new Libros(123,"La bailarina","Jesus","Baby","6541237", 2000, genero3);
		Libros l4= new Libros(123,"La gorra","pedro","El planeta","9874521", 2001, genero4);
		
		libros.add(l1);
		libros.add(l2);
		libros.add(l3);
		libros.add(l4);
	
	}
	
	@GetMapping
	public ResponseEntity<List<Libros>> getLibros(){ //Muestra todos los libros 
		return ResponseEntity.ok(libros);
	}
	
@GetMapping("/{titulo}")
public ResponseEntity <Libros> getLibros(@PathVariable String titulo) { //Consulta libros por su titulos
    for (Libros libro : libros) {
        if (libro.getTitulo().equals(titulo)) {
             return ResponseEntity.ok(libro);
        }
    }
    return ResponseEntity.notFound().build();
}

@PostMapping
public ResponseEntity<Libros> postAlumno(@RequestBody Libros libro) { //crear libro
	libros.add(libro);
	return ResponseEntity.noContent().build();
	
}

@PutMapping
public ResponseEntity<Libros> putAlumnos(@RequestBody Libros modif) { //modifica a los libros 
	for(Libros libro : libros) {
		if(libro.getId()== modif.getId()) {
			libro.setTitulo(modif.getTitulo());
			libro.setAutor(modif.getAutor());
			libro.setEditorial(modif.getEditorial());
			libro.setAñoPublicacion(modif.getAñoPublicacion());
			libro.setGenero(modif.getGenero());
			
			return ResponseEntity.noContent().build();
		}
		
	}
	return ResponseEntity.notFound().build();
	
}
@PatchMapping
public ResponseEntity<Libros> pathLibros(@RequestBody Libros modif) {  //modifica a los alumnos 
	for(Libros libro: libros) {
		if(libro.getId()==modif.getId()) {
			if(modif.getTitulo()!=null) {
				System.out.println("Titulo");
				modif.setTitulo(modif.getTitulo());
			}
			if(modif.getAutor()!=null) {
				System.out.println("Autor");
				modif.setAutor(modif.getAutor());
			}
			if(modif.getEditorial()!=null) {
				System.out.println("edad");
				libro.setEditorial(modif.getEditorial());
			}
			if(modif.getIsbn()!=null) {
				System.out.println("curso");
				modif.setIsbn(modif.getIsbn());
			}
			if(modif.getAñoPublicacion()!=0) {
				System.out.println("AñoPublicacion");
				modif.setAñoPublicacion(modif.getAñoPublicacion());
			}
			if(modif.getGenero()!=null) {
				System.out.println("genero");
				modif.setGenero(modif.getGenero());
			}
			return ResponseEntity.noContent().build();
	}
		
	}
	return ResponseEntity.notFound().build();
} 

@DeleteMapping("/{id}")   
public ResponseEntity<Libros> deleteLibro(@PathVariable int id) { //borra libros
	Iterator<Libros>iterador =libros.iterator();
	while(iterador.hasNext()) {
		Libros libros = iterador.next();
		if(libros.getId()==id) {
			iterador.remove();
			return ResponseEntity.noContent().build();
		}
	}
	return ResponseEntity.notFound().build() ;
}


@GetMapping("/novelas")
public ResponseEntity<List<Libros>> obtenerNovelas(){
	List<Libros>novelas = new ArrayList<>();
	for(Libros libro : libros) {
		if(libro.getGenero().contains("novelas")) {
			novelas.add(libro);
		}
	}
	if(novelas.isEmpty()) {
		return ResponseEntity.notFound().build();
	}else {
		return ResponseEntity.ok(novelas);
	}
}


@GetMapping ("/porGenero/{genero}")
public ResponseEntity<List<Libros>> obtenerPorGenero(@PathVariable String genero){
	List<Libros>libroPorGenero = new ArrayList<>();
	for(Libros libro :libros) {
		if(libro.getGenero().contains(genero)) {
			libroPorGenero.add(libro);
		}
	}
	if(libroPorGenero.isEmpty()) {
		return ResponseEntity.notFound().build();
	}else {
		return ResponseEntity.ok(libroPorGenero);
	}
}


@GetMapping("/autores/con-mas-de/{numLibros}")
public Map<String,Integer> obtenerAutoresConMasDeXLibros(@PathVariable int numLibros){
	Map<String,Integer> conteoPorAutor = new HashMap<>();
	
	//Contar la cantidad de libros por autor
	for(Libros libro: libros) {
		String autor = libro.getAutor();
		conteoPorAutor.put(autor, conteoPorAutor.getOrDefault(autor, 0)+1);
	}
	
	//Filtar los autores que tienen más de `numLibros` libros
	Map<String, Integer> autoresFiltrados = new HashMap<>();
	for(Map.Entry<String, Integer>entry:conteoPorAutor.entrySet()) {
		if(entry.getValue() > numLibros) {
			autoresFiltrados.put(entry.getKey(), entry.getValue());
		}
	}
	return autoresFiltrados;
}








        
}