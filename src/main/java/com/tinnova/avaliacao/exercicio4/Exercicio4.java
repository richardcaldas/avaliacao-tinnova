package com.tinnova.avaliacao.exercicio4;

public class Exercicio4 {

    public static void main(String[] args) {
        
        final int number = 10;
		
		final int sum = Exercicio4.getSumOfMultiplesOf3And5(number);
		System.out.println("The sum is: " + sum);

    }

    public static int getSumOfMultiplesOf3And5(final int number) {
		int sum = 0;
		for (int i = 1; i < number; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		return sum;
	}
    
}