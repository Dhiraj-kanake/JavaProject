package com.jda.algorithmprograms;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.List;
import com.jda.utility.Utility;

public class primeNumbers {
public static void main(String args[])
{
	Utility utility = new Utility();
	
	ArrayList<Integer> PrimeNumberList =  new ArrayList<Integer>();
	System.out.println("Enter start of range");
	int startOfRange = utility.InputInteger();

	System.out.println("Enter end of range");
	int endOfRange = utility.InputInteger();
	if(startOfRange > 0 && endOfRange<1000)
	{
		PrimeNumberList = utility.findRangeOfPrimeNumbers(startOfRange,endOfRange);
		System.out.println("prime numbers"+PrimeNumberList);
	}
	
	else
	{
		System.out.println("Enter Valid Input");
		String  retry[]= {"a","b","c"};
		main(retry);
	}
}
}
