package com.jda.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtility {
	JSONParser parser;
	public JSONUtility()
	{
		parser=new JSONParser();
	}
	
	public void getInfo(String value)
	{
		try
		{
			Object object=parser.parse(new FileReader("/home/bridgelabz/Documents/grainInfo.txt"));
			JSONObject obj=(JSONObject) object;
			JSONArray rice = (JSONArray) obj.get(value);
			Iterator itr = rice.iterator();
			while(itr.hasNext())
			{
				JSONObject riceObject=(JSONObject)itr.next();
				System.out.println("Name : "+riceObject.get("Name"));
				System.out.println("Weight : "+riceObject.get("Weight"));
				System.out.println("PricePerKG : "+riceObject.get("PricePerKG"));
				System.out.println();
			}
				
		}catch(Exception e)
		{e.printStackTrace();}
	}
	public void getStockInfo(String value)
	{
		try
		{
			Object object=parser.parse(new FileReader("/home/bridgelabz/Documents/stockReport.txt"));
			JSONObject obj=(JSONObject) object;
			JSONArray rice = (JSONArray) obj.get(value);
			Iterator itr = rice.iterator();
			while(itr.hasNext())
			{
				JSONObject riceObject=(JSONObject)itr.next();
				System.out.println("Name : "+riceObject.get("Name"));
				System.out.println("Shares : "+riceObject.get("Shares"));
				System.out.println("Share Price : "+riceObject.get("SharePrice"));
				System.out.println();
			}
				
		}catch(Exception e)
		{e.printStackTrace();}
	}
	public void calculateStock(String value)
	{
		try
		{
			Object object=parser.parse(new FileReader("/home/bridgelabz/Documents/stockReport.txt"));
			JSONObject obj=(JSONObject) object;
			JSONArray rice = (JSONArray) obj.get(value);
			Iterator itr = rice.iterator();
			long totalSharePriceOfCompany=0;
			while(itr.hasNext())
			{
				JSONObject riceObject=(JSONObject)itr.next();
				System.out.println("For : "+riceObject.get("Name"));
				
				long shares =(long) riceObject.get("Shares");
				long sharePrice=(long)riceObject.get("SharePrice");
				long sharePriceForPerson = shares * sharePrice;
				System.out.println("total share price : "+sharePriceForPerson);
				totalSharePriceOfCompany += sharePriceForPerson;
				System.out.println();
			}
			System.out.println("Total Stock price for "+value +" is "+totalSharePriceOfCompany);
		}catch(Exception e)
		{e.printStackTrace();}
	}
	
	public Object readJasonFile(String fileName) throws FileNotFoundException, IOException, ParseException
	{
		Object object=parser.parse(new FileReader(fileName));
		return object;
		
	}
	public String replace(String message,String from,String to)
	{
		Pattern p1=Pattern.compile(from);
		Matcher m1=p1.matcher(message);
		message=m1.replaceAll(to);
		return message;
	}

}
