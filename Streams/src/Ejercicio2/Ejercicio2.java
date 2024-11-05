package Ejercicio2;

import java.util.Arrays;
import java.util.List;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//2. Dada una lista de 5 nombres, filtrar e imprimir aquellos que comienzan por ‘A’, convertirlos
		//a mayúsculas y luego ordenarlo alfabéticamente.
List<String>nombre = Arrays.asList("Ana","Laura","Tay","Andrea","Sara");
nombre.stream().filter(n -> n.startsWith("A")).map(String::toUpperCase).sorted().forEach(System.out::println);
		
	}

}
