package dataStructures;

import java.util.ArrayList;

public class Heap {
	// Parent of a node is at index (k-1)/2
	// child of a parent is at index, left: 2k+1 and  right: 2k+2
	
	ArrayList<Integer> heapArray = new ArrayList<Integer>();
	
	public void insert(int number) {
		heapArray.add(number);
		siftUp();	
	}
	
	private void siftUp() {
		int k = heapArray.size() - 1;

		while (k > 0) {			
			int p = (k-1)/2;
			int item = heapArray.get(k);
			int parent = heapArray.get(p);
			
			if (item > parent) {				
				heapArray.set(k, parent);
				heapArray.set(p, item);				
				k = p;
			} else {
				break;
			}
		}
	}
	
	public int pop() {
		int itemToPop = heapArray.get(0);
		heapArray.set(0, heapArray.remove(heapArray.size() - 1));
		siftDown();
		return itemToPop;		
	}
	
	private void siftDown() {
		int k = 0; // First node in the array
		int leftIndex = 2*k + 1;
		int rightIndex = 2*k + 2;
		System.out.println("r");

		while (leftIndex < heapArray.size() -1) {
			int leftChild = heapArray.get(leftIndex);
			int rightChild = heapArray.get(rightIndex);
			int currItem = heapArray.get(k);
			
			if (leftChild < rightChild) {
				heapArray.set(rightIndex, currItem);
				heapArray.set(k, rightChild);
				k = rightIndex;
			}  else {
				heapArray.set(leftChild, currItem);
				heapArray.set(k, leftChild);
				k = leftIndex;
			}		
				
			leftIndex = 2*k + 1;
			rightIndex = 2*k + 2;
			
		}
		
		
		
	}
	
	public void printHeap() {
		for (int i : heapArray) {
			System.out.println(i);
		}		
	}
	
}

