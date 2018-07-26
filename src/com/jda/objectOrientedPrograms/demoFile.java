package com.jda.objectOrientedPrograms;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class demoFile {
public static void main(String args[])
{
	JSONParser parser=new JSONParser();
	try
	{
		Object object=parser.parse(new FileReader("/home/bridgelabz/Documents/jsonFile.txt"));
		JSONObject jobj=(JSONObject) object;       //taking that file as object, file is starting with object 
		String name=  (String)jobj.get("Name");
		String auther= (String)jobj.get("Author");
	JSONArray jarray=(JSONArray)jobj.get("Company List");
	System.out.println("Name : "+name);
	System.out.println("Auther :"+auther);
	@SuppressWarnings("unchecked")
	Iterator<String> itr=jarray.iterator();
	System.out.println("Company List : ");
	while(itr.hasNext())
		System.out.println(itr.next());
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
