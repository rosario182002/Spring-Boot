package Ejercicio3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//3. Dado un array de 5 palabras, imprimir la primera letra de cada palabra
	List<String>nombre = Arrays.asList("Ana","Laura","Tay","Andrea","Sara");
	 Stream<String>primera = nombre.stream().map(palabra -> String.valueOf(palabra.charAt(0)));
	
	 		primera.forEach(System.out::println);
	}

}
