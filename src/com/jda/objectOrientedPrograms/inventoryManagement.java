package com.jda.objectOrientedPrograms;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.jda.utility.JSONUtility;
import com.jda.utility.Utility;

public class inventoryManagement {
	public static void main(String args[]) throws FileNotFoundException, IOException, ParseException
	{
		JSONUtility<Object> utility = new JSONUtility<Object>();
		Utility utl=new Utility();
		System.out.println("****Microsoft stocks :******");
		utility.getStockInfo("Microsoft");
		
		System.out.println("*****Apple Stocks*****");
		utility.getStockInfo("Apple");	
		//writing into JSON file
		System.out.println("***Inventory Management***\n 1. enter entry\n 2. Delete Entry\n Enter your choice ");
		int choice=utl.InputInteger();
		switch(choice)
		{
		case 1:
		{
			System.out.println("Enter the Stock name in which you want to enter element");
			System.out.println("1. Microsoft \n 2. Apple\n (press 1/2)");
			int input=utl.InputInteger();
			if(input==1)
		 utility.writeIntoFile("Microsoft");
			else
				utility.writeIntoFile("Apple");	
		}
		case 2:
		{
			System.out.println("Enter the Stock name from which you want to delete an entry");
			System.out.println("1. Microsoft \n 2. Apple\n (press 1/2)");
			int input=utl.InputInteger();
			if(input==1)
				 utility.deleteFromFile("Microsoft");
					else
						utility.deleteFromFile("Apple");
		}
		}
		
	}
}