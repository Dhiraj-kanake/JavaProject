package com.jda.algorithmprograms;

import java.util.Arrays;

import com.jda.utility.Utility;

public class sortMethodUsingGenerics {
	public static void main(String args[]) {
		Utility utility = new Utility();
		Utility.bubbleSortForGenerics var=utility.new bubbleSortForGenerics();
		
               //		 input for Integer Array 
	System.out.println("For Int type of variable");
		Integer IntArray[] = utility.inputIntArray();
		Comparable[] SortedArray = var.bubbleForGenerics(IntArray);
		System.out.println("Array : "+Arrays.toString(SortedArray));
					//		input for String Array
		System.out.println("For String type of variable");
		String StringArray[] = utility.inputStringArray();
		Comparable[] SortedStringArray = var.bubbleForGenerics(StringArray);
		System.out.println("String Array : "+Arrays.toString(SortedStringArray));
		
					//		input for double array
		System.out.println("For Double type of variable");
		Double DoubleArray[]=utility.inputDoubleArray();
		Comparable[] SortedDouble =var.bubbleForGenerics(DoubleArray);
				System.out.println("double Array : "+Arrays.toString(SortedDouble));
		

	}
}
