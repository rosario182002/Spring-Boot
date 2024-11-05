package Ejercicio6;

import java.util.Arrays;
import java.util.List;

public class Ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//6. Crea un array de 10 enteros y devuelve el numero de pares que hay.
		List<Integer>numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		long pares = numeros.stream().filter(numerito -> numerito %2 ==0).count(); //count solo recoge long
		System.out.println("Numeros pares: " + pares);
	}

}
