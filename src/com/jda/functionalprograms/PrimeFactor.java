/*Problem statement :  find prime factor
 * auther : Dhiraj Kanake
 * Date : 5-jul-2018
 * */
package com.jda.functionalprograms;
import com.jda.utility.Utility;
public class PrimeFactor {
	public static void main(String args[])
	{
Utility utility = new Utility();
int Number = utility.InputInteger();
utility.PrimeFactors(Number);
}
}
