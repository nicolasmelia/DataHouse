package main;

import java.util.Arrays;

public class SamplePrograms {

	public static boolean IsPalindrome(String word) {
		// This sample "program" will reverse a string and check if it is a palindrome
		char[] reversedWord = word.toCharArray();
		for (int i = 0; i < reversedWord.length / 2; i++) {
			char tempLetter = reversedWord[i];
			reversedWord[i] = reversedWord[reversedWord.length - 1 - i];
			reversedWord[reversedWord.length - 1 - i] = tempLetter;
		}
		
		// Turn the char array into a string
		StringBuilder sb = new StringBuilder();
		for (char w : reversedWord)  {
			sb.append(w);
		}
		
		return sb.toString().equals(word);
	}
	
	
	public static int findIntArrayIndex(int[] intArray, int intToFind) {
		// This "program: will find the array of the passed in value by index.
		// This is using the binary search algorithm and the array must be sorted!
		int beginPoint = 0;
		int endPoint = intArray.length - 1;
		int pivot = 0;
		
		while (intArray[pivot] != intToFind) {
			pivot = (beginPoint + endPoint) / 2;
			
			if (intArray[pivot] > intToFind) {
				endPoint = pivot - 1;
			}

			if (intArray[pivot] < intToFind) {
				beginPoint = pivot + 1;	
			}
			
			// Return -1, value not found in array
			if (endPoint < beginPoint) {
				return -1;
			}
			
		}
		return pivot;
	}
	
	
	
}
