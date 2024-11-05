package Ejercicio4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//4. Dado un array de 5 palabras, devuelve una lista con la longitud de cada palabra. Imprime la
		//lista.
		List<String>cosas = Arrays.asList("Maleta","Ordenador","Play","Televisor","Aire");
		List<Integer> longitud = cosas.stream().map(String::length).collect(Collectors.toList());
		
		System.out.println(longitud);
	}

}
