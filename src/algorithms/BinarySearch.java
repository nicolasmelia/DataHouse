package algorithms;

public class BinarySearch {
	public int binarySearch(int key) {
		int[] values = new int[] {1,2,3,4,5,6,7,8,9,10};
		int middleIndex = 0;
		int upperIndex = values.length - 1;
		int lowerIndex = 0;
		
		while (lowerIndex <= upperIndex) {			
			middleIndex = (lowerIndex + upperIndex) / 2;
			if (key == values[middleIndex]) {
				return middleIndex;
			}
			
			if (key > values[middleIndex]) {
				lowerIndex = middleIndex + 1;				
			} 
			
			if (key < values[middleIndex]) {
				upperIndex = middleIndex - 1;					
			} 						
		}	
		
		// If lowerIndex > upperIndex
		System.out.println("Value does not exist in array.");
		return 0;		
	}
}
