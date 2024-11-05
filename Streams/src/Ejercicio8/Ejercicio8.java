package Ejercicio8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//8. Dado un array de 5 precios, devolver en una lista los mayores de 20 euros. Usar Double.
		
		Double [] precios = {15.0, 25.5, 10.99, 30.0, 18.5};
		List<Double> precioMayorA20 = (List<Double>) Arrays.stream(precios).filter(precio -> precio >20.0).collect(Collectors.toList());
		
		System.out.println("Precio mayores a 20€: " + precioMayorA20);
	}

}
