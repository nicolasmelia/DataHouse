package algorithms;

public class BubbleSort {
	int[] arrayToSort = {9,1,8,2,7,3,4,6,5,10};
	
	public void sort() {
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i = 0; i < arrayToSort.length - 1 ; i++) {
				if (arrayToSort[i] > arrayToSort[i + 1]) {
					// Swap the values
					int tempValue = arrayToSort[i];
					arrayToSort[i] = arrayToSort[i + 1];
					arrayToSort[i + 1] = tempValue;
					swapped = true;
				}			
			}
		}	
	}
	
	public void printArray() {
		for (int value : arrayToSort) {
			System.out.println(value);
		}	
	}
}
