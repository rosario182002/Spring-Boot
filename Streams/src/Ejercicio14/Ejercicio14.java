package Ejercicio14;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Ejercicio14 {
	public static void main(String[] args) {
        Random random = new Random();
        Set<Integer> numerosImpares = new HashSet<>();

        // Generar 5 números impares aleatorios entre 1 y 20
        while (numerosImpares.size() < 5) {
            int numero = random.nextInt(20) + 1; // Genera un número entre 1 y 20
            if (numero % 2 != 0) { // Verifica si el número es impar
                numerosImpares.add(numero); // Agrega el número al conjunto
            }
        }

        // Imprimir los números impares 
        System.out.println("Números impares aleatorios: " + numerosImpares);
    }
}
