package Ejercicio5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio5 {

	public static void main(String[] args) {
			// TODO Auto-generated method stub
//5. Dado un array de 5 palabras, devolver aquellas palabras que tengan más de 5 caracteres.
		List<String>cosas = Arrays.asList("Maleta","Ordenador","Play","Televisor","Aire");
	List<String>largas= cosas.stream().filter(palabra -> palabra.length()>5).collect(Collectors.toList());
	System.out.println(largas);
	}
}
