package com.jda.objectOrientedPrograms;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.jda.utility.JSONUtility;
import com.jda.utility.Utility;

public class stockReport {
public static void main(String args[]) throws FileNotFoundException, IOException, ParseException
{
	JSONUtility<Object> utility = new JSONUtility<Object>();
	Utility utl=new Utility();
	System.out.println("****Microsoft stocks :******");
	utility.getStockInfo("Microsoft");
	
	System.out.println("*****Apple Stocks*****");
	utility.getStockInfo("Apple");
	
	//  Calculating each stock price and total stock price of each company
	System.out.println("*******Microsoft stocks :******");
	utility.calculateStock("Microsoft");
	System.out.println("*****Apple Stocks*****");
	utility.calculateStock("Apple");
	
	
	//writing into JSON file
	System.out.println("Enter the Stock name in which you want to enter element");
	System.out.println("1. Microsoft \n 2. Apple\n (press 1/2)");
	int input=utl.InputInteger();
	if(input==1)
 utility.writeIntoFile("Microsoft");
	else
		utility.writeIntoFile("Apple");
	
	System.out.println("enter the name to remove :");
}
}
