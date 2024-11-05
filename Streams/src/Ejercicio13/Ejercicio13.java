package Ejercicio13;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Stream;

public class Ejercicio13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Generar un stream con la cadena "ABC" cinco veces
        Stream<String> stream = Stream.generate(() -> "ABC").limit(5);

        // Crear una lista para almacenar el resultado
        List<String> resultList = new ArrayList<>();
        
        stream.map(s -> s.replace("B", " ")) // Reemplaza "B" con " "
        .forEach(resultList::add); // Agrega cada elemento modificado a la lista
        
        // Imprimir el resultado manualmente, sin Collectors.joining
        for (int i = 0; i < resultList.size(); i++) {
            System.out.print(resultList.get(i));
            if (i < resultList.size() - 1) {
                System.out.print(", "); // Agrega coma y espacio entre elementos
            }
          }
	}
}
