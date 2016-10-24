package dataStructures;

public class HashTable {
	String[] values; 
	
	public HashTable(int size) {	
		values = new String[size * 2];	
	}
	
	public void put(String key, String value) {
		int hash = hashFunction(key);
		values[hash] = value;	
	}
	
	public String get(String key) {		
		return values[hashFunction(key)];
	}
	
	private int hashFunction(String key) {
		// Generate a hash key using the keys first char and length
		char letter = key.charAt(0);
		int hash = (((int) letter) + key.length()) % values.length; ;
		return hash;
	}
	
}
