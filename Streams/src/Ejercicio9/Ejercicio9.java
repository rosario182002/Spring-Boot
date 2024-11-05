package Ejercicio9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Lista de personas
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona("Ana", 20));
		personas.add(new Persona("Pedro", 26));
		personas.add(new Persona("Sara", 27));
		personas.add(new Persona("Alvaro", 28));
		personas.add(new Persona("Josema", 25));

		// Metodo para filtrar los mayores de 25 años

		List<Persona> mayores = personas.stream().filter(persona1 -> persona1.getEdad() >= 25)
				.sorted((p1, p2) -> p1.getNombre().compareTo(p2.getNombre())).collect(Collectors.toList());

		mayores.forEach(System.out::println);

	}

}
