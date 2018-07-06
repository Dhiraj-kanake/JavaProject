package com.jda.functionalprograms;

import com.jda.utility.Utility;

public class Gambler {
	public static void main(String args[])
	{
		Utility utility = new Utility();
		double AvailableCash, Goal,NumberOfChances;             // variables to store input values
		
		System.out.println("Enter Available Cash : ");
		AvailableCash=utility.InputInteger();
		System.out.println("Enter Goal : ");
		Goal=utility.InputInteger();
		System.out.println("Enter Number of Chances : ");
		NumberOfChances=utility.InputInteger();
		utility.FindWinLossOFGambler(AvailableCash,Goal,NumberOfChances);
		
	}

}
