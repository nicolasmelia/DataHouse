package algorithms;

public class QuickSort {
	
	int[] arrayToSort = {1,4,2,10,8,7};
	
	public void sort() {		
		quickSort(0, arrayToSort.length - 1);
	}

	public void quickSort(int low, int high) {

		// pick the pivot
		int pivot = arrayToSort[high];
 
		// make left < pivot and right > pivot
		int lowPointer = low, highPointer = high;
		while (lowPointer <= highPointer) {
			while (arrayToSort[lowPointer] < pivot) {
				lowPointer++;
			}
 
			while (arrayToSort[highPointer] > pivot) {
				highPointer--;
			}
 
			if (lowPointer <= highPointer) {
				exchange(lowPointer,highPointer);
				lowPointer++;
				highPointer--;
			}
		}
 
		// recursively sort two sub parts
		if (low < highPointer) {
			quickSort(low, highPointer);
		}
 
		if (high > lowPointer) {
			quickSort(lowPointer, high);
		}
	}
	private void exchange(int low, int high) {
		int tempLow = arrayToSort[low];
		arrayToSort[low] = arrayToSort[high];
		arrayToSort[high] = tempLow;
	}
	
	public void printArray() {
		for (int value : arrayToSort) {
			System.out.println(value);
		}	
	}
	

}
