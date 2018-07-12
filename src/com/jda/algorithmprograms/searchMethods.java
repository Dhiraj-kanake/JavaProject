package com.jda.algorithmprograms;

import java.util.Arrays;

import com.jda.utility.Utility;

public class searchMethods {
public static void main(String args[])
{
	Utility utility = new Utility();
	System.out.println("Searching methods");
	System.out.println("1. Binary Search for Intigers \n2. Binary search for String \n3. Insertion Sort for Integer \n4. Insertion sort for String \n5. Bubble Sort for Integers \n6. Bubble sort for String");
	int choice = utility.InputInteger();
	switch(choice)
	{
	case 1:
	{
		System.out.println("enter length of array : ");
		int length = utility.InputInteger();
		int arr[]=new int[length];
		System.out.println("enter all elements");
		for(int i=0;i<length;i++)
			arr[i]=utility.InputInteger();
		Arrays.sort(arr);
		System.out.println("Enter Element to search");
		int searchElement = utility.InputInteger();
		
		int x=Utility.binarySearch(arr, searchElement, 0, 6);
		System.out.println(Arrays.toString(arr));
		if(x==-1)
			System.out.println("not found");
		else
		System.out.println("found at "+x+" position");
	}
	case 2:
	{
		System.out.println("enter length of array : ");
		int length = utility.InputInteger();
		String arr[]=new String[length];
		System.out.println("enter all elements");
		for(int i=0;i<length;i++)
			arr[i]=utility.ScanStringForLoop();
		Arrays.sort(arr);
		System.out.println("Enter Element to search");
		String searchElement = utility.ScanStringForLoop();
		
		int x=Utility.binarySearchForString(arr, searchElement, 0, length);
		System.out.println(Arrays.toString(arr));
		if(x==-1)
			System.out.println("not found");
		else
		System.out.println("found at "+x+" position");
	}
	}
	
}
}
