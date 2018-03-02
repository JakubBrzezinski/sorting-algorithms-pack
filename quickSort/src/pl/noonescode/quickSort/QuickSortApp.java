package pl.noonescode.quickSort;

import java.util.Arrays;
import java.util.Random;

public class QuickSortApp {

	public static void main(String[] args) {

		float[] values = generateArray();
		printTable(values);
		values = quickSort(values);
		printTable(values);

	}

	public static float[] generateArray() {
		float[] table = new float[10];
		Random randomGenerator = new Random();

		for (int i = 0; i < table.length; i++) {
			table[i] = randomGenerator.nextInt(100) / (float) 10;
		}
		return table;
	}

	public static void printTable(float[] elements) {

		if (elements == null || elements.length < 1) {
			return;
		}
		String separator = ", ";
		StringBuilder arrayDisplay = new StringBuilder("");

		for (float element : elements) {
			arrayDisplay.append(element);
			arrayDisplay.append(separator);
		}

		arrayDisplay.delete(arrayDisplay.length() - separator.length(), arrayDisplay.length());
		System.out.println(arrayDisplay);
	}

	public static float[] quickSort(float[] dataSet) {

		if (dataSet.length <= 1) {
			return dataSet;
		}

		int pivotIndex = dataSet.length / 2;
		float pivotValue = dataSet[pivotIndex];

		float[] smallerValueArray = new float[dataSet.length];
		float[] biggerValueArray = new float[dataSet.length];
		int smallerElementCounter = 0;
		int biggerElementCounter = 0;
		for (int i = 0; i < dataSet.length; i++) {
			if (i == pivotIndex) {
				continue;
			}

			if (dataSet[i] <= pivotValue) {
				smallerValueArray[smallerElementCounter] = dataSet[i];
				smallerElementCounter++;

			} else {
				biggerValueArray[biggerElementCounter] = dataSet[i];
				biggerElementCounter++;
			}

		}
		// Cut array default value to real value
		smallerValueArray = Arrays.copyOf(smallerValueArray, smallerElementCounter);
		biggerValueArray = Arrays.copyOf(biggerValueArray, biggerElementCounter);

		// Recursion is sorting elements in sets
		smallerValueArray = quickSort(smallerValueArray);
		biggerValueArray = quickSort(biggerValueArray);

		float[] ret = new float[dataSet.length];

		int counter = 0;
		for (int i = 0; i < smallerValueArray.length; i++) {
			ret[counter] = smallerValueArray[i];
			counter++;
		}
		ret[counter] = pivotValue;
		counter++;

		for (int i = 0; i < biggerValueArray.length; i++) {
			ret[counter] = biggerValueArray[i];
			counter++;
		}

		return ret;

	}
}
