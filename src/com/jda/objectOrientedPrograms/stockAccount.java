package com.jda.objectOrientedPrograms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.jda.utility.JSONUtility;
import com.jda.utility.Utility;

public class stockAccount {
	public static void main(String args[]) throws FileNotFoundException, IOException, ParseException
	{
		JSONUtility<Object> utility = new JSONUtility<Object>();
		Utility utl=new Utility();
		
		System.out.println("*****Apple Stocks*****");
		utility.getStockInfoForEachCustomer("Apple");	
		System.out.println("****Microsoft stocks :******");
		utility.getStockInfoForEachCustomer("Microsoft");
		//writing into JSON file
		System.out.println("***Inventory Management***\n 1. Buy Shares\n 2. Sell Shares \n3. Print Report\n Enter your choice ");
		int choice=utl.InputInteger();
		switch(choice)
		{
		case 1:
		{
		System.out.println("Is that person is already a customer of company 1. YES 2. NO ( press1/2)");
		int entry=utl.InputInteger();
		if(entry==1)
		{
			System.out.println("Enter the Stock name in which that person has invested");
			System.out.println("1. Microsoft \n 2. Apple\n (press 1/2)");
			int input=utl.InputInteger();
			System.out.println("Enter the person Name");
			String person=utl.ScanString();
			if(input==1)
		 utility.buyStocks("Microsoft",person);
			else
				utility.buyStocks("Apple",person);	
			break;
		}
		else
		{
			utility.getCustomerFile();
		}
		break;
		}
		case 2:
		{
			System.out.println("Enter the stock name");      
			System.out.println("1. Microsoft \n 2. Apple\n (press 1/2)");
			int input=utl.InputInteger();
			System.out.println("Who wants to sell? \n 1. person 2. company (press 1/2)");
			int seller=utl.InputInteger();
			if(seller == 2)
			{
			if(input==1)
				 utility.sellStocks("Microsoft");
					else
						utility.sellStocks("Apple");
			}
			else
			{
				if(input==1)
					 utility.sellStocksByPerson("Microsoft");
						else
							utility.sellStocksByPerson("Apple");
			}
			break;
		}
		case 3:
		{
			utility.printReport();
		}
		}
		
	}
}
