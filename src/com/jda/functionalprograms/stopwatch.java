package com.jda.functionalprograms;
import com.jda.utility.Utility;
public class stopwatch {
	public static void main(String args[])
	{
		Utility utility = new Utility();
		System.out.println("Start the timer by pressing any alphabet : ");
		int x=utility.InputInteger();
		System.out.println("End the timer by pressing any alphabet : ");
		double start = utility.startStopwatch();
		int y = utility.InputInteger();
		double end = utility.endStopwatch();
		
		double elapsedTime = (end-start)/1000;
		System.out.println("elapsed time : "+elapsedTime+"  second");
	}

}
