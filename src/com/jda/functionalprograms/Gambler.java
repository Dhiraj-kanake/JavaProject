package com.jda.functionalprograms;

import com.jda.utility.Utility;

public class Gambler {
	public static void main(String args[])
	{
		Utility utility = new Utility();
		double AvailableCash,  Goal,NumberOfChances;
		AvailableCash=utility.InputInteger();
		Goal=utility.InputInteger();
		NumberOfChances=utility.InputInteger();
		utility.FindWinLossOFGambler(AvailableCash,Goal,NumberOfChances);
		
	}

}
