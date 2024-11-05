package com.example.demo.contoles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.modelo.Alumno;

public class AlumnosResponseController {
	
	public List <Alumno> alumnos = new ArrayList<>();
	
	public AlumnosResponseController() {
		
		Alumno a1 = new Alumno(111,"pepe","pepe@gmail.es",21,"1ºA");
		Alumno a2 = new Alumno(222,"ana","ana@gmail.es",20,"4ºA");
		Alumno a3 = new Alumno(333,"sara","sara@gmail.es",19,"3ºA");
		Alumno a4= new Alumno(444,"eda","eda@gmail.es",22,"2ºA");
		
		alumnos.add(a1);
		alumnos.add(a2);
		alumnos.add(a3);
		alumnos.add(a4);
	
	}
	@GetMapping
	public ResponseEntity<List<Alumno>> getAlumno(){ //Muestra todos los alumnos 
		return ResponseEntity.ok(alumnos);
	}
	
@GetMapping("/{email}")
    
    public ResponseEntity <Alumno> getAlumno(@PathVariable String email) { //Consulta alumno por su email
        for (Alumno alumnos : alumnos) {
            if (alumnos.getEmail().equals(email)) {
                 return ResponseEntity.ok(alumnos);
            }
        }
        return ResponseEntity.notFound().build();
    }
	
@PostMapping
	public ResponseEntity<Alumno> postAlumno(@RequestBody Alumno alumno) { //crear alumno
		alumnos.add(alumno);
		//return ResponseEntity.ok(alumno);
		return ResponseEntity.noContent().build(); //Este es mas correcto
		
}

@PutMapping
public ResponseEntity<Alumno> putAlumnos(@RequestBody Alumno modif) { //modifica a los alumnos 
	for(Alumno alumnos : alumnos) {
		if(alumnos.getId()== modif.getId()) {
			alumnos.setNombre(modif.getNombre());
			alumnos.setEmail(modif.getEmail());
			alumnos.setEdad(modif.getEdad());
			alumnos.setCurso(modif.getCurso());
			return ResponseEntity.noContent().build();
		}
		
	}
	return ResponseEntity.notFound().build();
	
}
@PatchMapping
public ResponseEntity<Alumno> pathAlumno(@RequestBody Alumno modif) {  //modifica a los alumnos 
	for(Alumno alumnos: alumnos) {
		if(alumnos.getId()==modif.getId()) {
			if(modif.getNombre()!=null) {
				System.out.println("nombre");
				alumnos.setNombre(modif.getNombre());
			}
			if(modif.getEmail()!=null) {
				System.out.println("email");
				alumnos.setEmail(modif.getEmail());
			}
			if(modif.getEdad()!=0) {
				System.out.println("edad");
				alumnos.setEdad(modif.getEdad());
			}
			if(modif.getCurso()!=null) {
				System.out.println("curso");
				alumnos.setCurso(modif.getCurso());
			}
			return ResponseEntity.noContent().build();
	}
		
	}
	return ResponseEntity.notFound().build();
} 
@DeleteMapping("/{id}")   
public ResponseEntity<Alumno> deleteCliente(@PathVariable int id) { //borra alumno
	Iterator<Alumno>iterador =alumnos.iterator();
	while(iterador.hasNext()) {
		Alumno alumnos = iterador.next();
		if(alumnos.getId()==id) {
			iterador.remove();
			return ResponseEntity.noContent().build();
		}
	}
	return ResponseEntity.notFound().build() ;
}
}
