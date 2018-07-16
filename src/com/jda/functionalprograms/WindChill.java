package com.jda.functionalprograms;

import com.jda.utility.Utility;

public class WindChill {
public static void main(String args[])
{
	double arr[]=new double[2];
	arr[0] = Double.parseDouble(args[0]);
	arr[1] = Double.parseDouble(args[1]);
	Utility utility = new Utility();
 double windchill = utility.findWindChill(arr);
 System.out.println("windchill : "+windchill);
}

}
