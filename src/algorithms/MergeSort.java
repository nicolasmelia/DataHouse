package algorithms;

public class MergeSort {
	private int[] listToSort = {2,7,4,9,3,8,1,12,44,33,32};
	private int[] helper;
	
	public void sort() {
		this.helper = new int[listToSort.length];
		mergeSort(0, listToSort.length - 1);	
		printArray();
	}
	
	public void mergeSort(int low, int high) {		
		if (low < high) {
			int middle = (low + high) / 2;
			
			mergeSort(low, middle);
			mergeSort(middle + 1, high);
			merge(low,middle,high);
			
		}		
	}
	
	public void merge(int low, int middle, int high) {
		
		// create the temp array
		for (int i = low; i <= high; i++) {
			helper[i] = listToSort[i];
		}
		
		int i = low;
		int j = middle + 1;
		int k = low;
		
		while (i <= middle && j <= high){
			if (helper[i] <= helper[j]) {
				listToSort[k] = helper[i];
				i++;
			} else {
				listToSort[k] = helper[j];
				j++;
			}
			
			k++;		
		}
		
		while (i <= middle) {
			listToSort[k] = helper[i];
			k++;
			i++;		
		}	
		
	};
	
	public void printArray() {
		for (int value : listToSort) {
			System.out.println(value);
		}	
	}

}
