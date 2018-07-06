/*Problem statement : Flip coin and print percentage of Head vs Tail
 * auther  : Dhiraj Kanak
 * Date :  5-jul-2018
 * */
package com.jda.functionalprograms;       //package name
import com.jda.utility.Utility;                       // package which contains all the methods



public class FlipCoin {													//main class

		public static void main(String args[])

		{

			Utility utility = new Utility();               //creating object of utility

			System.out.println("Enter Number of Times to Flip Coin : ");
			int Number_Of_times_To_Flip_Coin = utility.InputInteger();           //calling InputInteger to take input number

			double PercentageOfFlipCoin = Utility.FindPercent(Number_Of_times_To_Flip_Coin);  //calling method to calculate percent

			System.out.println("Tail percent : "+PercentageOfFlipCoin*100);    //

			

		}

}


