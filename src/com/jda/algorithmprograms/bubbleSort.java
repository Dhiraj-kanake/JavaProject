package com.jda.algorithmprograms;

import java.io.IOException;
import java.util.Arrays;

import com.jda.utility.Utility;

public class bubbleSort {
public static void main(String args[]) throws IOException
{
	Utility utility=new Utility();
	String filename="/home/bridgelabz/Documents/integers.txt"; 
	String ArrayOfNumbers[]=utility.fileSetup(filename);   //in string form
	Integer ArrayOfIntegers[]=utility.arrayOfStringToInteger(ArrayOfNumbers);
	Integer sortedArray[]=Utility.bubbleSort(ArrayOfIntegers);      
//	System.out.println(Arrays.toString(sortedArray));     //sorting in descending order
	for(int i=0;i<sortedArray.length;i++)
		System.out.print(sortedArray[i]+" ");
	System.out.println();
	System.out.println(Arrays.toString(ArrayOfNumbers));

}
}
