package com.jda.objectOrientedPrograms;

import com.jda.utility.JSONUtility;

public class stockReport {
public static void main(String args[])
{
	JSONUtility utility = new JSONUtility();
	System.out.println("Microsoft stocks :");
	utility.getStockInfo("Microsoft");
	System.out.println("Apple Stocks");
	utility.getStockInfo("Apple");
	
	//  Calculating each stock price and total stock price of each company

	utility.calculateStock("Microsoft");
	utility.calculateStock("Apple");
}
}
