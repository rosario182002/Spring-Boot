package Ejercicio1;

import java.util.Arrays;
import java.util.List;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//1. Dada una lista de 5 nombres, filtrar e imprimir aquellos que comienzan por ‘A’
		List<String>nombre = Arrays.asList("Ana","Laura","Tay","Andrea","Sara");
		
		nombre.stream().filter(n -> n.startsWith("A")).forEach(System.out::println);
		
		
	}

}
