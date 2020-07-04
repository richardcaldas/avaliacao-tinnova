package com.tinnova.avaliacao.exercicio2;

public class Exercicio2 {

    public static void main(String[] args) {
        
        final int disorderedArray[] = {5,3,2,4,7,1,0,6};
		
		System.out.println("Disorderd Array: ");
	    Exercicio2.printArray(disorderedArray);
		
		final int orderedArray[] = Exercicio2.orderbyBubbleSort(disorderedArray);
		
		System.out.println("Orderd Array: ");
		Exercicio2.printArray(orderedArray);

    }

    public static int[] orderbyBubbleSort(int[] array) {
		
		final int size = array.length;
		
		int auxiliar = 0;
		
		for (int i = 0; i < size; i++) {
			
			for (int j = 0; j < size - 1; j++) {
				
				if (array[j] > array[j+1]) {
					auxiliar = array[j];
					array[j] = array[j+1];
					array[j+1] = auxiliar;
				}
				
			}
			
		}
		
		return array;
		
	}
	
	public static void printArray(final int[] array) {
		for(int i = 0; i < array.length; i++){
	        System.out.println(" " + array[i]);
	    }
	    System.out.println(" ");
	}
    
}