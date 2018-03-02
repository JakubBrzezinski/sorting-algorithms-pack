package bubblesort;

import java.util.Random;

public class BubbleSortApp {

	public static void main(String[] args) {
		
		float[] newArray = generateArray();
		printTable(newArray);
		newArray = bubbleSort(newArray);
		printTable(newArray);

	}

	public static float[] generateArray() {
		float[] table = new float[90];
		Random randomGenerator = new Random();
		
		for (int i = 0; i < table.length; i++) {
			table[i] = randomGenerator.nextInt(100) / (float) 10;
		}
		return table;
	}

	public static void printTable(float[] elements) {

		for (float element : elements) {
			System.out.print(element + ", ");

		}
		System.out.println("");
	}

	public static float[] bubbleSort(float[] dataSet) {

		int counter = 0;
		
		for (int j = dataSet.length - 1; j >= 0; j--) {
			for (int i = 0; i < dataSet.length -1; i++) {
				counter++;
				if(dataSet[i] > dataSet[i+1]) {
					float temp = dataSet[i];
					dataSet[i] = dataSet[i+1];
					dataSet[i+1] = temp;
					
				}
			}

		}
		
		System.out.println("Number of comparsions: " + counter);
		
		return dataSet;
	}
	
}
