package com.jda.algorithmprograms;

import com.jda.utility.Utility;

public class numberGuess {
public static void main(String args[])
{
	Utility utility=new Utility();
	double Number= Integer.parseInt(args[0]);
	double chances=Math.ceil(Math.log(Number)/Math.log(2));
	System.out.println("Guess a number between 0 to "+Number);
	System.out.println(" we have "+(int) chances +" chances");
	utility.searchNumber(0,Number);
}
}
