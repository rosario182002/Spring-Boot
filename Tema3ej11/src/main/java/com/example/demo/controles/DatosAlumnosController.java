package com.example.demo.controles;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Alumno;
import com.example.demo.modelo.Direccion;
@RestController
@RequestMapping("/alumnos")
public class DatosAlumnosController {

	public List <Alumno> alumnos = new ArrayList<>();
	public DatosAlumnosController() {
		Direccion d1 = new Direccion("Calle Jose 123", "15236", "Sevilla");
		Direccion d2 = new Direccion("Calle Rafaela 123", "56985", "Sevilla");
		Direccion d3 = new Direccion("Calle Juan 123", "123245", "Sevilla");
		Direccion d4 = new Direccion("Calle  123", "28080", "Sevilla");
		
		Alumno a1 = new Alumno(111,"pepe","pepe@gmail.es",21,"1ºA",d1);
		Alumno a2 = new Alumno(222,"ana","ana@gmail.es",20,"4ºA",d2);
		Alumno a3 = new Alumno(333,"sara","sara@gmail.es",19,"3ºA",d3);
		Alumno a4= new Alumno(444,"eda","eda@gmail.es",22,"2ºA",d4);
		
		alumnos.add(a1);
		alumnos.add(a2);
		alumnos.add(a3);
		alumnos.add(a4);
	
	}
	@GetMapping
	public List<Alumno> obtenerDatos(){ //Muestra todos los alumnos 
		return alumnos;
	}
	
@GetMapping("/{email}")
    
    public Alumno ConsultarAlumno(@PathVariable String email) { //Consulta alumno por su email
        for (Alumno alumnos : alumnos) {
            if (alumnos.getEmail().equals(email)) {
                 return alumnos;
            }
        }
        return null;
    }
	
@PostMapping
	public Alumno postAlumno(@RequestBody Alumno alumno) { //crear alumno
		alumnos.add(alumno);
		return alumno;
		
}
@PutMapping
public Alumno putAlumnos(@RequestBody Alumno modif) { //modifica a los alumnos 
	for(Alumno alumnos : alumnos) {
		if(alumnos.getId()== modif.getId()) {
			alumnos.setNombre(modif.getNombre());
			alumnos.setEmail(modif.getEmail());
			alumnos.setEdad(modif.getEdad());
			alumnos.setCurso(modif.getCurso());
			alumnos.setDireccion(modif.getDireccion());
			return alumnos;
		}
		
	}
	return null;
	
}
@PatchMapping
public Alumno pathAlumno(@RequestBody Alumno modif) {  //modifica a los alumnos 
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
			if(modif.getDireccion() !=null) {
				System.out.println("dirección");
				alumnos.setDireccion(modif.getDireccion());
			}
			return alumnos;
	}
		
	}
	return null;
} 
@DeleteMapping("/{id}")   
public Alumno deleteCliente(@PathVariable int id) { //borra alumno
	Iterator<Alumno>iterador =alumnos.iterator();
	while(iterador.hasNext()) {
		Alumno alumnos = iterador.next();
		if(alumnos.getId()==id) {
			iterador.remove();
			return alumnos;
		}
	}
	return null;
}
@GetMapping ("/direcciones") //para las direcciones 
	public  List<Direccion> getDirecciones(){
		List<Direccion> direcciones = new ArrayList<>();
			for(Alumno alumno : alumnos) {	
				direcciones.add(alumno.getDireccion());			
			}
	return direcciones;
}


@GetMapping ("/direcciones/{cp}")
 public List<Direccion> obtenerDireccionesPorCodigoPostal(@PathVariable String cp){
	 List<Direccion>direcciones = new ArrayList<>();
	 for (Alumno alumnos : alumnos) {
         if (alumnos.getDireccion().getCodigoPostal().equals(cp)) {
        	 direcciones.add(alumnos.getDireccion());
         }
         }
	 return direcciones;
 }

@GetMapping ("/cantidad/{ciudad}")
public Integer contarAlumnosPorCiudad(@PathVariable String ciudad){
	int contador = 0;
	for(Alumno alumno : alumnos) {
		if(alumno.getDireccion().getCiudad().equalsIgnoreCase(ciudad)) {
			contador++;
		}
	}
	return contador;	
}

}
