package com.jda.algorithmprograms;
import java.util.ArrayList;
import java.util.Collections;

import com.jda.utility.Utility;
public class anagramPalindrome {
	public static void main(String args[])
	{
		
		//primeNumbers p = new primeNumbers();
		//String x[]={"a","b","c"};
		//p.main(x);
		Utility utility = new Utility();
		ArrayList<Integer> ListOfPrimeNumber = utility.findRangeOfPrimeNumbers(0, 900);
		ArrayList<Integer> ReverseList = utility.findReverseOfNumbers(ListOfPrimeNumber);
		System.out.print("palindrome  : ");

		for(int i=0;i<ListOfPrimeNumber.size();i++)
		{
			if(ReverseList.get(i).equals(ListOfPrimeNumber.get(i) ))
			{
				//System.out.print("inside");
				//System.out.print("List : "+ListOfPrimeNumber.get(i));
				//System.out.print("reverse  :"+ReverseList.get(i));
				System.out.print("  "+ReverseList.get(i));

			}
			//System.out.print("value of i  :"+i);
			//System.out.print("List : "+ListOfPrimeNumber.get(i));
			//System.out.println("reverse  :"+ReverseList.get(i));
		}
		
		/// To find Anagram
		System.out.println("");
		System.out.println("Anagram");
		ArrayList<String> SortedElement = utility.findAnagram(ListOfPrimeNumber);
		//Collections.sort(SortedElement);
		//System.out.println(ListOfPrimeNumber);
		//System.out.println(SortedElement);
	}
}
