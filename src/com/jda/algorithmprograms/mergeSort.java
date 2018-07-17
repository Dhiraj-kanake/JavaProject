package com.jda.algorithmprograms;

import java.util.Arrays;

import com.jda.utility.Utility;

public class mergeSort {
public static void main(String args[])
{
	Utility utility=new Utility();
	System.out.println("Enter length of Array :");
	int LengthOfArray=utility.InputInteger();
	
	String ArrayOfString[]=new String[LengthOfArray];
	
	System.out.println("Enter Array:");
	
	for(int i=0;i<LengthOfArray;i++)
	ArrayOfString[i]=utility.ScanString();
	String array[] = utility.mergeSortForString(ArrayOfString,0,LengthOfArray-1);
	System.out.println("Sorted Array : "+Arrays.toString(array));
}
}
