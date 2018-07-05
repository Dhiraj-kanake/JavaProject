/* Problem statement  : Find leap year
 * Auther : Dhiraj Kanake
 * Date : 5-jul-2018
 */
package com.jda.functionalprograms;        //Package name

import com.jda.utility.Utility;       // importing method class from package

public class LeapYear {
		public static void main(String args[])
		{
			Utility utility = new Utility();      //object creation of utility
			int Year = utility.InputInteger();
			int length = Integer.toString(Year).length();  // finding length of input integer
			if(length == 4)
			{
				String result = utility.FindLeapYear(Year);     //calling method to find leap year
				System.out.println(result);
			}
			else
				System.out.println("Invalid Input");
		}
}
