package com.jda.algorithmprograms;

import com.jda.utility.Utility;

public class temperatureConversion {
public static void main(String args[])
{
	Utility utility = new Utility();
	System.out.println("1.Celsius to Fehrenheit \n 2. Fehrenheit to Celsius \n Enter Your Choice : ");
	int choice=utility.InputInteger();
	System.out.println("Enter Temperature : ");
	int temp = utility.InputInteger();
	switch(choice)
	{
	case 1:
		{utility.CToF(temp);
		break;
		}
	case 2:
	{
		utility.FToC(temp);
		}
	}
	
	
}
}
