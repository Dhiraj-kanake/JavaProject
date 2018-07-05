/*Problem statement : Flip coin and print percentage of Head vs Tail
 * auther  : Dhiraj Kanake
 * version : 
 * Date :  5-jul-2018
 * */
package com.jda.functionalprograms;
import com.jda.utility.Utility;



public class FlipCoin {

		public static void main(String args[])

		{

			Utility utility = new Utility();

			int number = utility.InputInteger();

			double PercentageOfFlipCoin = Utility.FindPercent(number);

			System.out.println("Tail percent"+PercentageOfFlipCoin*100);

			

		}

}


