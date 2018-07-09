package com.jda.functionalprograms;
import com.jda.utility.Utility;
public class distance {
	public static void main(String args[])
	{
		Utility utility = new Utility();
		int x=Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		utility.euclideanDistance(x,y);
	}

}
