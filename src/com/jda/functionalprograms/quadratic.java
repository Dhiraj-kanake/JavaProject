package com.jda.functionalprograms;
import com.jda.utility.Utility;
public class quadratic {
public static void main(String args[])
{
	Utility utility = new Utility();
	int a=utility.InputInteger();
	int b = utility.InputInteger();
	int c = utility.InputInteger();
	double Delta = utility.findDelta(a,b,c);
	utility.findRoot(Delta,a,b);
}
}
