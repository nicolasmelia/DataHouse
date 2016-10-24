package dataStructures;

public class LinkList<T> {
	public Link<T>  tail; // Tail Node
	protected Link<T>  head; // Head Node

	public LinkList() {
		tail = null;
	}
	
	public void addToFirstPosition(T value) {
		Link<T>  newLink = new Link<T> (value);
		
		if (isEmpty()) {
			head = newLink;	
			tail = newLink;
		} else {
			newLink.next = tail;
			tail.previous = newLink;
			tail = newLink;
		}
	}
	
	public void add(T value) { 
		Link<T>  newLink = new Link<T>(value);	
		if (isEmpty()) {
			tail = newLink;
			head = newLink;
		} else {
			head.next = newLink;
			newLink.previous = head;
			head = newLink;
		}			
	}

	
	public boolean remove (T value) {
		Link<T> currLink = tail;
		
		if (tail.value == value) {
			tail = tail.next;
			return true;
		}
		
		if (head.value == value) { // Quicker than searching the entire list
			head = head.previous;
			head.next = null;
			return true;
		}
		
		while (currLink.next != null) {
			
			if (currLink.next.value == value) {
				if (currLink.next == head) head = currLink;
				currLink.next = currLink.next.next;
				break;
			} 		
			currLink = currLink.next;
		}
		
		return (currLink == null) ? false : true;
	}
	
	public boolean isEmpty() {
		return tail == null ? true:false;
	}
	
	public void printAllLinks() {
		Link<T> currLink = tail;
		while (currLink != null) {
			System.out.print(currLink.value + "\n");
			currLink = currLink.next;		
		}		
	}
}

class Link <T> {
	T value;
	public Link<T>  next;
	public Link<T>  previous;

	
	Link (T value) {
		this.value = value; 
	}
	
	public String toString(){
		return value.toString();
	};
	
}

@SuppressWarnings("rawtypes")
class ListIterator  {
	LinkList list;
	Link currLink;
	boolean firstItem = false;
	
	
	ListIterator(LinkList list) {
		this.list = list;
		currLink = list.tail;
	}
	
	public Link next() {
		
		if (!firstItem) {
			firstItem = true;
			return currLink;
		}
		
		currLink = currLink.next;
		return currLink;
		
	}
	
	public Link previous() {
		currLink = currLink.previous;
		return currLink;
		
	}
	
	public boolean hasNext() {

		if (currLink.next != null) {
			return true;
		} else {
			return false;
		}	
	}
	
	
	
	
	
}

