package Ejercicio7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//7. Multiplicar todos los elementos de un array de 10 numeros
		List<Integer>numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		int multiplicar = 2;
		
		List<Integer> resultado = numeros.stream().map(numero -> numero * multiplicar).collect(Collectors.toList());
		System.out.println("Array sin multiplicar: " + numeros);
		System.out.println("Array multiplicado: " + resultado);
		/*List<Integer> resultado = new ArrayList<>();
		for(Integer numero : numeros) {
			resultado.add(numero*multiplicar);
		}
		System.out.println(resultado);*/
		
	}

}
