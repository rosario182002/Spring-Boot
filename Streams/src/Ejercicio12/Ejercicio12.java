package Ejercicio12;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Ejercicio12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. Crear una lista de 5 libros.
        List<Libro> libros = Arrays.asList(
                new Libro("Historia de una escalera", "Michael Huerta", 350, "Drama"),
                new Libro("El viaje", "Ana Smith", 150, "Aventura"),
                new Libro("Historia universal", "John Doe", 400, "Historia"),
                new Libro("La ciencia en la historia", "Michael Clark", 320, "Ciencia"),
                new Libro("Relatos de ficción", "Michael Martínez", 200, "Ficción")
        );
        
        //2º Filtrar libros con más de 300 páginas
        System.out.println("Libros con mas de 300 páginas");
        libros.stream().filter(libro -> libro.getNumeroPaginas() > 300).forEach(System.out::println);
        
        //3º Obtener los títulos de todos los libros e imprimpir
        
        System.out.println("\nTotal de libros: " );
        libros.stream().map(Libro::getTitulo).forEach(System.out::println);
        
        //4º Contar cuantos libros hay en total
		
		int totalLibros = libros.size();
		System.out.println("\nTotal de libros: " + totalLibros);
		
		//5º Obtener el libro con más páginas
		
		Optional<Libro> libroMasPaginas = libros.stream()
		        .reduce((libro1, libro2) -> libro1.getNumeroPaginas() > libro2.getNumeroPaginas() ? libro1 : libro2);

		if (libroMasPaginas.isPresent()) {
		    System.out.println("\nLibro con más páginas: " + libroMasPaginas.get());
		} else {
		    System.out.println("\nNo hay libros en la lista.");
		}
		
		//6º Obtener los tirulos  que contenga la palabra "historia"
		System.out.println("\nTítulos que contienen la palabra 'Historia' ");
		libros.stream().map(Libro::getTitulo).filter(titulo -> titulo.toLowerCase().contains("historia")).forEach(System.out::println);
		
		//7º Ordenar los resultados por la longitud del titulo
		System.out.println("\nLibros ordenados por la longitud del título");
		libros.stream().sorted((libro1, libro2) -> Integer.compare(libro1.getTitulo().length(), libro2.getTitulo().length())).forEach(System.out::println);
		
		//8º Obtener los tres tíyulos con mas página
		System.out.println("\nTres libros con más páginas:");
		List<String> tresLibrosMasPaginas = libros.stream()
		        .sorted((libro1, libro2) -> Integer.compare(libro2.getNumeroPaginas(), libro1.getNumeroPaginas()))
		        .map(Libro::getTitulo)
		        .collect(Collectors.toList())
		        .subList(0, Math.min(3, libros.size())); // Tomamos los primeros 3 o menos si hay menos de 3 libros

		tresLibrosMasPaginas.forEach(System.out::println);
		
		//9º Obtener los 4 primeros libros que tenga más de 250 páginas y el autor sea 'Michael'
		 System.out.println("\nCuatro primeros libros con más de 250 páginas y autor contiene 'Michael':");
	        libros.stream().filter(libro -> libro.getNumeroPaginas() > 250 && libro.getAutor().contains("Michael"))
	        .limit(4).forEach(System.out::println);
	        
	     // 10. Encuentra el primer libro que tenga exactamente 200 páginas sin usar orElse
	        Optional<Libro> libro200Paginas = libros.stream()
	                .filter(libro -> libro.getNumeroPaginas() == 200)
	                .findFirst();

	        if (libro200Paginas.isPresent()) {
	            System.out.println("\nPrimer libro con 200 páginas: " + libro200Paginas.get());
	        } else {
	            System.out.println("\nNo se encontró un libro con exactamente 200 páginas.");
	        }

	     // 11. Encuentra cualquier libro cuyo género sea Aventura sin usar orElse
	        Optional<Libro> libroAventura = libros.stream()
	                .filter(libro -> libro.getGenero().equalsIgnoreCase("Aventura"))
	                .findAny();

	        if (libroAventura.isPresent()) {
	            System.out.println("\nCualquier libro de género Aventura: " + libroAventura.get());
	        } else {
	            System.out.println("\nNo se encontró un libro del género Aventura.");
	        }
	        
	      // 12. Comprobar si todos los libros son de ficción.
	        boolean todosSonFiccion = libros.stream()
	                .allMatch(libro -> libro.getGenero().equalsIgnoreCase("Ficción"));
	        System.out.println("\n¿Todos los libros son de ficción? " + todosSonFiccion);

	      // 13. Comprobar si todos los libros tienen más de 100 páginas
	        boolean todosMasDe100Paginas = libros.stream()
	                .allMatch(libro -> libro.getNumeroPaginas() > 100);
	        System.out.println("\n¿Todos los libros tienen más de 100 páginas? " + todosMasDe100Paginas); 
		

	}

}
