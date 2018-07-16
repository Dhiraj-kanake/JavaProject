package com.jda.algorithmprograms;

import com.jda.utility.Utility;

public class temperatureConversion {
public static void main(String args[])
{
	Utility utility = new Utility();
	System.out.println("1.Celsius to Fehrenheit \n 2. Fehrenheit to Celsius \n Enter Your Choice : ");
	int choice=utility.InputInteger();
	
	switch(choice)
	{
	case 1:
		{
			System.out.println("Enter Temperature : ");
			int temp = utility.InputInteger();
			utility.CToF(temp);
		break;
		}
	case 2:
	{
		System.out.println("Enter Temperature : ");
		int temp = utility.InputInteger();
		utility.FToC(temp);
		break;
		}
	default :
	{
		System.out.println("what is this?");
		break;
	}
	}
	
	
}
}
