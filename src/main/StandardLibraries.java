package main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
// This class demonstrates Java's built in data structure libraries (Collections)
public class StandardLibraries {
	
	// **********  Methods below Implement the Collections interface **********	
	public static void arrayListDemo(){
		ArrayList<String> al = new ArrayList<String>();
		al.add("One");
		al.add("Two");
		al.add("Three");
		al.add("Four");
		al.add("Five");
		//Remove an object by index
		al.remove(4);
		//Remove object while looping.
		ListIterator<String> arrayIterator = al.listIterator();

		while (arrayIterator.hasNext()) {
			System.out.println(arrayIterator.next());
		}
		
		while (arrayIterator.hasPrevious()) {
			System.out.println(arrayIterator.previous());
		}

		System.out.println(al.get(0));	
		System.out.println(al.toString());	
	}
	
	// ********** LinkedList Example **********
	public static void linkedListDemo(){
		// Example, [TAIL][NODE][NODE][NODE][HEAD]
		LinkedList<String> ls = new LinkedList<String>();
		ls.add("One");
		ls.add("Two");
		ls.add("Three");
		ls.addFirst("Four");
		ls.add("Five");
		ls.remove();		
		//Remove object while looping.
		Iterator<String> lsIterator = ls.iterator();
		while (lsIterator.hasNext()) {
			if (lsIterator.next().equals("One")) {
				lsIterator.remove();
			}
		}
		
		ls.subList(0, 2).clear(); // Returns/Clears a sublist from 0 - 2				
		System.out.println(ls.get(0));	
		System.out.println(ls.toString());	
				
	}
	
	public static void hashSetDemo(){
		// HashSet uses a hash function and does not keep order and does not allow duplicates.
		// LinkedHashSet will keep order. (Still hashes but uses a linkedlist to do so)
		HashSet<String> hash = new HashSet<String>();

		hash.add("One");
		hash.add("Two");
		hash.add("Three");
		hash.add("Four");
		hash.add("Three"); // Sets do not allow duplicates 
		hash.remove("Three");
		
		Iterator<String> hashIterator = hash.iterator();
		while (hashIterator.hasNext()) {
			if (hashIterator.next().equals("One")) {
				hashIterator.remove();
			}
		}
			
		System.out.println(hash.toString());	
	}
	
	public static void treeSetDemo() {
		// Tree set will sort elements in ascending order 
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("C");
		ts.add("D");
		ts.add("D"); // No duplicates in this tree.
		ts.add("F");
		ts.add("B");
		ts.add("E");
		ts.add("F");
		ts.add("A");
		ts.remove("D");
		
		System.out.println(ts.tailSet("B")); // Returns everything after B
		System.out.println(ts.subSet("B", "F")); // Returns B - F (exclusive) 	
		
		// descendingSet returns a reversed list
		for(String letter : ts.descendingSet()) {
			System.out.println(letter);
		}
		
		ArrayList<String> al = new ArrayList<String>(); // sort an arraylist of strings with a treeset
		al.add("2");
		al.add("3");
		al.add("1");
		ts.clear();
		ts.addAll(al); // add elements of arraylist to the tree set which will sort it.
		System.out.println(ts.toString()); 

	}
	
	// ********** Methods below implement the Map interface **********

	public static void hashMapDemo() {
		// HaspMap is a <K,v> pair. It does not keep order of inserted objects. O(1) lookup time.
		// Use LinkedHashMap to maintain order when using an iterator (Maintains a linkedList)
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("Son", "Nick");
		hm.put("Father", "Paul");
		hm.put("Moster", "Kim");
		hm.put("Girlfriend", "Jenna");
		hm.put("Son", "Nick Melia"); // overwrites the value with the same key
		
		// You can not loop though a map with a for loop.
		Iterator hpIterator = hm.entrySet().iterator();
		while (hpIterator.hasNext()) {
	        Map.Entry<String, String> pair = (Map.Entry)hpIterator.next();
			System.out.println(pair.getValue()); 
		}

		System.out.println(hm.get("Son")); 	
	}
	
	public static void treeMapDemo() {
		// TreeMap is like a HashMap, however a TreeMap is sorted using a tree.
		// O(N) lookup time! Unlike HashMaps O(1)
		TreeMap<String, String> tm = new TreeMap<String, String>();
		tm.put("C", "Nick");
		tm.put("D", "Paul");
		tm.put("A", "Kim");
		tm.put("E", "Jenna");
		tm.put("C", "Nick Melia"); // overwrites the value with the same key
		
		// You can not loop though a map with a for loop.
		Iterator hpIterator = tm.entrySet().iterator();
		while (hpIterator.hasNext()) {
	        Map.Entry<String, String> pair = (Map.Entry)hpIterator.next();
			System.out.println(pair.getValue()); 
		}
		
		System.out.println(tm.get("C")); 
		
	}
	
	public static void treeSetDemoComparator() {
		// Use a Comparator to define the order of elements in sets and maps.
		TreeSet<String> ts = new TreeSet<String>(new Mycomparator());
		ts.add("C");
		ts.add("D");
		ts.add("F");
		ts.add("B");
		ts.add("E");
		ts.add("F");
		ts.add("A");
		System.out.println(ts.toString());

	}
	
	// ********** Vector Implemention  **********
	public static void stackDemo() {
		Stack<String> stack = new Stack<String>();
		stack.push("One");
		stack.push("Two");
		stack.push("Three");
		stack.push("Four");
		stack.push("Five");
		stack.pop();

		System.out.println(stack.toString());

	}
	
	public static void queueDemo() {
		Queue<String> queue = new LinkedList<String>();
		queue.add("One");
		queue.add("Two");
		queue.add("Three");
		queue.add("Four");
		queue.poll();
		
		System.out.println(queue.toString());

	}
}

class Mycomparator implements Comparator<String>{
	@Override
	public int compare(String aString, String bString) {
		return (int)bString.charAt(0) - (int)aString.charAt(0);
	}
	
	
}

