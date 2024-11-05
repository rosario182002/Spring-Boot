package Ejercicio11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Ejercicio11 {
	 public static void main(String[] args) {
	List<Curso> cursos = new ArrayList<>();
	  cursos.add(new Curso("Curso de Java", 6.0, 55, 800));
      cursos.add(new Curso("Curso de Python", 1.5, 45, 200));
      cursos.add(new Curso("Curso de JavaScript", 3.0, 60, 150));
      cursos.add(new Curso("Curso de HTML y CSS", 7.5, 70, 1000));
      cursos.add(new Curso("Curso de SQL", 2.5, 30, 300));

//1º Obtener la cantidad de cursos con una duración mayor a 5 horas
      int cursosDuracionMayor5 = 0;
      for(Curso curso :cursos) {
    	  if(curso.getDuracion() >5) {
    		  cursosDuracionMayor5++;
    	  }
      }
      System.out.println("Cantidad de cursos con duración mayor a 5 horas: " + cursosDuracionMayor5);
//2º Contar cursos con duracción menor a 2horas 
      
      int cursosDuracionMenor2 = 0;
      for(Curso curso :cursos) {
    	  if(curso.getDuracion() >2) {
    		  cursosDuracionMenor2++;
    	  }
      }
      System.out.println("Cantidad de cursos con duración mayor a 5 horas: " + cursosDuracionMenor2);
      
 //3º Listar titulos de cursor con mas de 50 videos 
      
      System.out.println("Cursos con más de 50 videos: ");
      cursos.stream().filter(curso -> curso.getNumeroDeVideos()>50).map(Curso::getNombre).forEach(System.out :: println);
      
 //4º Titulo de los 3 cursos con mayor duracción
      System.out.println("Los 3 cursos con mayor duracción");
      cursos.stream().sorted(Comparator.comparing(Curso::getDuracion).reversed()).limit(3).map(Curso::getNombre).forEach(System.out :: println);
 
 //5º Duraccion total de todos los cursos
      double duracionTotal = cursos.stream().mapToDouble(Curso::getDuracion).sum();
      System.out.println("Duraccion total de todos los curso: " + duracionTotal + "horas");
 
 //6º Mostrar duraccion de cursos con menos de 500 alumnos
      System.out.println("Duración de cursos con menos de 500 alumnos: ");
      cursos.stream().filter(curso -> curso.getNumeroDeAlumnos() < 500).forEach(curso -> System.out.println(curso.getNombre() + ": " + curso.getDuracion() + "horas"));
 
 //7º Obtener curso con mayor duraccion
      Optional<Curso> cursoMayorDuraccion = cursos.stream().max(Comparator.comparing(Curso::getDuracion));
      if(cursoMayorDuraccion.isPresent()) { //isPresent() verifica si hay un valor en el Optional
     	 System.out.println("Curso con mayor duración: " + cursoMayorDuraccion.get());
      }else {
     	 System.out.println("No hay cursos disponibles");
      }
      
  //8º Crear lista de Strings con titulos de los cursos
      List<String>titulosDeCursos = cursos.stream().map(Curso::getNombre).collect(Collectors.toList());
      System.out.println("Lista de títulos de cursos: " + titulosDeCursos);   
   
	 }
}

