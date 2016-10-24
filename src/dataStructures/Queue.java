package dataStructures;
// ****** implementation of a queue without a linked list ******
public class Queue<T> {
	private T[] queueArray;
	private int back, front, queueSize = 0;
	
	@SuppressWarnings("unchecked")
	public Queue(int size){
		queueArray = (T[]) new Object[size];
	}
	
	public void add(T value) {
		queueArray[back] = value;
		back++;
		queueSize++;
	}
	
	public T poll() {
		T returnString = queueArray[front];		
		queueArray[front] = null;	
		front++;
		queueSize--;
		return returnString;
	}
	
	public T peek() {
		return queueArray[front];
	}
	
	public int size() {
		return queueSize;
	}
	
	public boolean isEmpty() {
		return queueSize == 0;
	}

}
