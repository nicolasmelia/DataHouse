package dataStructures;

public class Stack {
	
	private String[] stackArray;
	private int stackSize = -1;
	
	public Stack(int size) {
		stackArray = new String[size];
	}
	
	public void push(String value) {
		if (stackSize + 1 < (stackArray.length)) {
			stackArray[++stackSize] = value;
		} else {
			System.out.println("Stack is full. Item did not push.");
		}
	}
	
	public String pop() {
		if (stackSize >= 0) {
			return stackArray[stackSize--];	
		} else {
			return null;
		}
	}
	
	public String peek() {
		return  stackArray[stackSize];	
	}
	
	public boolean isEmpty() {
		return (stackSize == -1);
	}
	
	
}
