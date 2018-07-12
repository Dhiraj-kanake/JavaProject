package com.jda.functionalprograms;

import com.jda.utility.Utility;

public class WindChill {
public static void main(double args[])
{
	Utility utility = new Utility();
 double windchill = utility.findWindChill(args);
 System.out.println(windchill);
}

}
