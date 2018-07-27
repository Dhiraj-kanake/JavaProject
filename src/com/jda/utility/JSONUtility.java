package com.jda.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtility<Generic> {
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
			JSONArray stocks = (JSONArray) obj.get(value);
			Iterator itr = stocks.iterator();
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
			JSONArray stocks = (JSONArray) obj.get(value);
			Iterator itr = stocks.iterator();
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
	public void writeIntoFile(String StockName) throws FileNotFoundException, IOException, ParseException
	{
		String fileName = "/home/bridgelabz/Documents/stockReport.txt";
		Object object = readJasonFile(fileName);
		JSONObject  obj = (JSONObject) object;
		JSONArray appleStocks = (JSONArray)obj.get("Apple");
		JSONArray microsoftStocks = (JSONArray)obj.get("Microsoft");
		if(StockName.equals("Apple")){
		appleStocks = writeIntoJSONArray(appleStocks);}
		else{
		microsoftStocks = writeIntoJSONArray(microsoftStocks);}
				
	 HashMap<String,JSONArray> hMap2=new HashMap<>();      //creating 2nd hashmap to store all the entries from file
	 hMap2.put("Apple", appleStocks);          //storing array of appple and microsoft into hashmap
	 hMap2.put("Microsoft",  microsoftStocks);
	 
	 JSONObject newObjectdemo=new JSONObject(hMap2);     //converting that hashmap2 into jasonobject
	 
	System.out.println("jason"+newObjectdemo);
	@SuppressWarnings("resource")
	FileWriter file = new FileWriter(fileName);     //writing into file
	 file.write(newObjectdemo.toJSONString());
	 file.flush();
	 
	}
	@SuppressWarnings("unchecked")
	public JSONArray writeIntoJSONArray(JSONArray jArray)
	{
		//Adding values into hashmap
				Utility utility = new Utility();
				HashMap<String,Generic> hMap = new HashMap<String,Generic>(); 
				System.out.println("Enter your name : ");
				String name = utility.ScanString();
				System.out.println("Enter number of shares : ");
				Long shares = (long) utility.InputInteger();
				JSONObject ob =(JSONObject) jArray.get(0);    //reading first entry to get shareprice
				Long sharePrice =(long)ob.get("SharePrice");
				hMap.put("Name", (Generic) name);         //storing elements into hashmap
				hMap.put("Shares", (Generic) shares);
			hMap.put("SharePrice", (Generic) sharePrice);
		   
				JSONObject newObject=new JSONObject(hMap);     // converting hashmap to jasonobject
			 jArray.add(newObject);          //adding that object into existing array

			 return jArray;
	}

}
