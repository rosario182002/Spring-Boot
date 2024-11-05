package Ejercicio10;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> numeros = List.of(1,2,3,4,5,6,7,8,9,10);
		
		List<Integer>cuadrado = numeros.stream().filter(n-> n % 2 == 0).map(n-> n * n).collect(Collectors.toList());
		
		System.out.println(cuadrado);
	}

}
