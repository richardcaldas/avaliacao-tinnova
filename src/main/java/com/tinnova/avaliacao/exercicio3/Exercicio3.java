package com.tinnova.avaliacao.exercicio3;

/**
 * Exercicio3
 */
public class Exercicio3 {

    public static void main(String[] args) {
        
        final int number = 5;
		
		final long resultFactorial = Exercicio3.calculateFactorial(number);
		
		System.out.println("Factorial result is: " + resultFactorial);

    }

    public static long calculateFactorial(final int number) {
		long factorial = 1;
		
		
		for (int i = 1; i <= number; i++) {
			factorial *= i;
		}
		
		return factorial;
	}
}