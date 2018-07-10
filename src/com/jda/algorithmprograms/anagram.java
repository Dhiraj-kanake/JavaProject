package com.jda.algorithmprograms;
import java.util.Arrays;

import com.jda.utility.Utility;
public class anagram {
public static void main(String args[])
{
	Utility utility = new Utility();
	String stringOne = utility.ScanString();
	String stringTwo = utility.ScanString();
	char stringOne1[] = utility.formatString(stringOne);
	char stringTwo2[] = utility.formatString(stringTwo);
	//String s1=new String(stringOne1);
	//System.out.println("StringOne : "+Arrays.toString(stringOne1));
	//System.out.println("stringTwo : "+Arrays.toString(stringTwo2));
 	if(stringOne.length()!=stringTwo.length())
 		System.out.println("Not an Anagran");
 	if(Arrays.toString(stringOne1).equals(Arrays.toString(stringTwo2)))
 		System.out.println("Anagram");
 	else
 		System.out.println("Not an Anagram");
 	
}
}
