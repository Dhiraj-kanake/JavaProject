package com.jda.algorithmprograms;

import com.jda.utility.Utility;

public class Binary {
public static void main(String args[]) {
	Utility utility=new Utility();
	System.out.println("enter decimal number :");
	int Number = utility.InputInteger();
	String BinaryNumber = Utility.convertToBinary(Number);
	utility.afterSwap(BinaryNumber);
	
}
}
