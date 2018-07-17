package com.jda.algorithmprograms;

import com.jda.utility.Utility;

public class toBinary {
public static void main(String args[])
{
	Utility utility=new Utility();
	int Number = utility.InputInteger();
	String Binary = Utility.convertToBinary(Number);
	System.out.println("binary : "+Binary);
}
}
