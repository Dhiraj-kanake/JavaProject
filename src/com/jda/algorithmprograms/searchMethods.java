package com.jda.algorithmprograms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

import com.jda.utility.Utility;

public class searchMethods {
public static void main(String args[])
{
	Utility utility = new Utility();
	int choice=0;
	long arrOfTimer[]=new long[7];
	TreeMap<Long,String> map = new TreeMap<>();
	while(choice!=7)
	{
		System.out.println("Searching methods");
		System.out.println("1. Binary Search for Intigers \n2. Binary search for String \n3. Insertion Sort for Integer \n4. Insertion sort for String \n5. Bubble Sort for Integers \n6. Bubble sort for String \n7.Exit");
		choice = utility.InputInteger();
	switch(choice)
	{
	case 1:
	{
		System.out.println("enter length of array : ");
		int length = utility.InputInteger();
		Integer arr[]=new Integer[length];
		System.out.println("enter all elements");
		for(int i=0;i<length;i++)
			arr[i]=utility.InputInteger();
		Arrays.sort(arr);
		System.out.println("Enter Element to search");
		Integer searchElement = utility.InputInteger();
		long start=utility.stopwatch();
		int x=Utility.binarySearch(arr, searchElement, 0, length);
		long elapsedTime=utility.endwatch(start);
		System.out.println(Arrays.toString(arr));
		if(x==-1)
			System.out.println("not found");
		else
		System.out.println("found at "+x+" position");
		System.out.println("elapsed time : "+elapsedTime);
		arrOfTimer[1]=elapsedTime;
		map.put(elapsedTime,"binary search for Integer");
		break;
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
		System.out.println("Enter String to search");
		String searchElement = utility.ScanStringForLoop();
		long start=utility.stopwatch();
		int x=Utility.binarySearch(arr, searchElement, 0, length);
		long elapsedTime=utility.endwatch(start);
		System.out.println(Arrays.toString(arr));
		if(x==-1)
			System.out.println("not found");
		else
		System.out.println("found at "+x+" position");
		System.out.println("elapsed time : "+elapsedTime);
		arrOfTimer[2]=elapsedTime;
		map.put(elapsedTime,"binary search for string");
		break;
	}
	
	case 3:
	{
		System.out.println("enter length of array : ");
		int length = utility.InputInteger();
		Integer arr[]=new Integer[length];
		System.out.println("enter all elements");
		for(int i=0;i<length;i++)
			arr[i]=utility.InputInteger();
		long start=utility.stopwatch();
		Integer x[]=Utility.insertionSort(arr);
		long elapsedTime=utility.endwatch(start);
		System.out.println(Arrays.toString(x));
		System.out.println("elapsed time : "+elapsedTime);
		arrOfTimer[3]=elapsedTime;
		map.put(elapsedTime," insertion sort for Integer");
		break;
	}
	
	case 4:
	{
		System.out.println("enter length of array : ");
		int length = utility.InputInteger();
		String arr[]=new String[length];
		System.out.println("enter all elements");
		for(int i=0;i<length;i++)
			arr[i]=utility.ScanStringForLoop();
		long start=utility.stopwatch();
		String x[]=Utility.insertionSort(arr);
		long elapsedTime=utility.endwatch(start);
		System.out.println(Arrays.toString(x));
		System.out.println("elapsed time : "+elapsedTime);
		arrOfTimer[4]=elapsedTime;
		map.put(elapsedTime," insertion sort for String");
		break;
	}
	
	case 5:
	{
		System.out.println("enter length of array : ");
		int length = utility.InputInteger();
		Integer arr[]=new Integer[length];
		System.out.println("enter all elements");
		for(int i=0;i<length;i++)
			arr[i]=utility.InputInteger();
		long start=utility.stopwatch();
		Integer x[]=Utility.bubbleSort(arr);
		long elapsedTime=utility.endwatch(start);
		System.out.println(Arrays.toString(x));
		System.out.println("elapsed time : "+elapsedTime);
		arrOfTimer[5]=elapsedTime;
		map.put(elapsedTime," bubble sort for Integer");
		break;
	}
	
	case 6:
	{
		System.out.println("enter length of array : ");
		int length = utility.InputInteger();
		String arr[]=new String[length];
		System.out.println("enter all elements");
		for(int i=0;i<length;i++)
			arr[i]=utility.ScanStringForLoop();
		long start=utility.stopwatch();
		String x[]=Utility.bubbleSort(arr);
		long elapsedTime=utility.endwatch(start);
		System.out.println(Arrays.toString(x));
		System.out.println("elapsed time : "+elapsedTime);
		arrOfTimer[6]=elapsedTime;
		map.put(elapsedTime," bubble sort for string");
		break;
	} //case ends here
	case 7:
		break;
	
	default :
	{
		System.out.println("invalid choice please enter again : ");
		break;
	}
	
	} // switch ends here
	} //end of while
	System.out.println(map.toString());
	
}
}
