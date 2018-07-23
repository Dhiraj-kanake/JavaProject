package com.jda.dataStructurePrograms;

import java.util.ArrayList;

import com.jda.utility.Utility;

public class primeNumbers {
public static void main(String args[])
{
	Utility utility=new Utility();
	
	int i=100;
	while(i<=1000)
	{
		ArrayList<Integer> list=utility.findRangeOfPrimeNumbers(i-100,i );
		System.out.println("for " +(i-100)+" to "+i);
		System.out.println(list);
		i=i+100;
	}
	
}
}
