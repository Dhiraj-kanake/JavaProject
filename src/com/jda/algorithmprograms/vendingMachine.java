package com.jda.algorithmprograms;

import com.jda.utility.Utility;

public class vendingMachine {
public static void main(String args[])
{
	Utility utility = new Utility();
	int Money = utility.InputInteger();
	utility.returnChange(Money);
}
}
