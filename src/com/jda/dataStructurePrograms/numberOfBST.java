package com.jda.dataStructurePrograms;

import com.jda.utility.Utility;

public class numberOfBST {
public static void main(String args[])
{
	Utility utility = new Utility();
	System.out.println("Enter Number of inputs");
	int input=utility.InputInteger();
 System.out.println("Enter "+input +" numbers");
 int arr[]=new int[input];
	for(int i=0;i<input;i++)
	arr[i]=utility.InputInteger();
	for(int i=0;i<input;i++)
		utility.findNumberOfBST(arr[i]);
}
}
