package com.jda.algorithmprograms;

import java.io.IOException;
import java.util.Arrays;

import com.jda.utility.Utility;

public class insertionSort {
public static void main(String args[]) throws IOException
{
	Utility utility = new Utility();
	String filename="/home/bridgelabz/Documents/file.txt"; 
	String StringOfArray[]=utility.fileSetup(filename);
	String StringOfSortedArray[]=Utility.insertionSort(StringOfArray);
	System.out.println(Arrays.toString(StringOfSortedArray));
}
}
