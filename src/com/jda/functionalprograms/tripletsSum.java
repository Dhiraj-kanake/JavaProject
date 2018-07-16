package com.jda.functionalprograms;
import com.jda.utility.Utility;
public class tripletsSum {
	public static void main(String args[])
	{
		Utility utility = new Utility();
		int ArraySize;
		System.out.println("Enter array size");
		ArraySize  = utility.InputInteger();
		System.out.println("Enter Array");
		int Array[] = new int[ArraySize];
		for(int i=0;i<ArraySize;i++)
			Array[i] = utility.InputInteger();
		utility.findTripletSum(Array);
		
	}

}
