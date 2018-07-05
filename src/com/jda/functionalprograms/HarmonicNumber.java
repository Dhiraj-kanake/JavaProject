/*Proble statement :  find harmonic mean
 * auther : Dhiraj Kanake
 * Date : 5-jul-2018
 * */

package com.jda.functionalprograms;
import com.jda.utility.Utility;
public class HarmonicNumber {
public static void main (String args[])
{
	Utility utility = new Utility();
	int Number = utility.InputInteger();
	double output=utility.FindHarmonicMean(Number);
	System.out.println(output);
}
	

}
