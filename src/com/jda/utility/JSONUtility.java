package com.jda.utility;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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

}
