package com.jda.objectOrientedPrograms;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.jda.utility.JSONUtility;
import com.jda.utility.Utility;

public class regexDemonstration {
public static void main(String args[]) throws FileNotFoundException, IOException, ParseException
{
	JSONUtility utility=new JSONUtility();
   Utility utl=new Utility();
	String fileName="/home/bridgelabz/Documents/msg.txt";
	Object object=utility.readJasonFile(fileName);
	JSONObject jObj = (JSONObject) object;
	String message =(String)jObj.get("message");
	String name = "<<name>>";
	String fullName = "<<full name>>";
	String number = "91-xxxxxxxxxx";
	String date = "01/01/2016";
	
	System.out.println("Enter Name : ");
	String nameToReplace=utl.ScanString();
	System.out.println("Enter Sirname : ");
	String fullNameToReplace=utl.ScanString();
	fullNameToReplace=nameToReplace + " "+fullNameToReplace;
	System.out.println("Enter number : ");
	String numberToReplace = utl.ScanString();
	String dateToReplace = "26/07/2018";
	
	message=utility.replace(message, name,nameToReplace );
	message=utility.replace(message, fullName, fullNameToReplace);
	message=utility.replace(message, number,numberToReplace );
	message=utility.replace(message, date,dateToReplace );
	System.out.println(message);
}
}
