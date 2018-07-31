package com.jda.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	public void deleteFromFile(String StockName) throws FileNotFoundException, IOException, ParseException
	{
		String fileName = "/home/bridgelabz/Documents/stockReport.txt";
		Object object = readJasonFile(fileName);
		JSONObject  obj = (JSONObject) object;
		JSONArray appleStocks = (JSONArray)obj.get("Apple");
		JSONArray microsoftStocks = (JSONArray)obj.get("Microsoft");
		if(StockName.equals("Apple")){
		appleStocks = deleteFromJSONArray(appleStocks);}
		else{
		microsoftStocks = deleteFromJSONArray(microsoftStocks);}
				
	 HashMap<String,JSONArray> hMap2=new HashMap<>();      //creating 2nd hashmap to store all the entries from file
	 hMap2.put("Apple",appleStocks);          //storing array of appple and microsoft into hashmap
	 hMap2.put("Microsoft",microsoftStocks);
	 
	 JSONObject newObjectdemo=new JSONObject(hMap2);     //converting that hashmap2 into jasonobject
	 
	System.out.println("jason"+newObjectdemo);
	@SuppressWarnings("resource")
	FileWriter file = new FileWriter(fileName);     //writing into file
	 file.write(newObjectdemo.toJSONString());
	 file.flush();
	 
	}
	@SuppressWarnings("unchecked")
	public JSONArray deleteFromJSONArray(JSONArray jArray)
	{
		//Adding values into hashmap
				Utility utility = new Utility();
				System.out.println("Enter entryName :");
				String entryName = utility.ScanString();
				JSONArray tempArray=new JSONArray();
				System.out.println("entruname : "+entryName);
				   Iterator itr = jArray.iterator();
				   while(itr.hasNext())
				   {
				   	JSONObject object=(JSONObject)itr.next();
						String check = (String) object.get("Name");
						System.out.println("check : "+check);
						if(!check.equals(entryName))
						{
							tempArray.add(object);
						}
				   }
			// jArray.add(tempArray);          //adding that object into existing array

			 //return jArray;
				   return tempArray;
	}
	public void getStockInfoForEachCustomer(String value)
	{
			try
			{
				Object object=parser.parse(new FileReader("/home/bridgelabz/Documents/StockAccount.json"));
				JSONObject obj=(JSONObject) object;
				JSONObject company = (JSONObject) obj.get(value);
				System.out.println("Available Shares : "+company.get("ShareAvailable"));
				System.out.println("Share Price : "+company.get("SharePrice"));
				JSONArray jArray = (JSONArray)company.get("Customers");
				Iterator itr = jArray.iterator();
				while(itr.hasNext())
				{
					JSONObject riceObject=(JSONObject)itr.next();
					System.out.println("Name : "+riceObject.get("Name"));
					System.out.println("Available balence : "+riceObject.get("AvailableBalence"));
					System.out.println("Shares : "+riceObject.get("Shares"));
					System.out.println();
				}
					
			}catch(Exception e)
			{e.printStackTrace();}
	}
	public void getCustomerFile() throws FileNotFoundException, IOException, ParseException
	{
		Object object=parser.parse(new FileReader("/home/bridgelabz/Documents/customers.json"));
		JSONObject obj=(JSONObject) object;
		Utility utility = new Utility();
		JSONArray jArray =(JSONArray) obj.get("Customers");
		System.out.println("Enter the person Name");
		String person=utility.ScanString();
		
	}
	@SuppressWarnings("unchecked")
	public void buyStocks(String companyName,String person) throws FileNotFoundException, IOException, ParseException
	{
		String fileName = "/home/bridgelabz/Documents/StockAccount.json";
		Object object=parser.parse(new FileReader("/home/bridgelabz/Documents/StockAccount.json"));
		JSONObject obj=(JSONObject) object;
		Utility utility = new Utility();
		JSONObject company = (JSONObject) obj.get(companyName);
		long companyShares = (long) company.get("ShareAvailable");
		long sharePrice = (long)company.get("SharePrice");
		JSONArray jArray = (JSONArray)company.get("Customers");
		Iterator  itr = jArray.iterator();
		while(itr.hasNext())
		{
			JSONObject customerInfo=(JSONObject)itr.next();
			String name=(String) customerInfo.get("Name");
			if(name.equals(person))
			{
				long availableBalence = (long) customerInfo.get("AvailableBalence");
				long shares = (long)customerInfo.get("Shares");
				System.out.println("Enter the number of shares he/she wants to buy!");
				long requestedShares =utility.InputInteger();
				if((requestedShares * sharePrice) <= availableBalence)
				{
					availableBalence=availableBalence - requestedShares * sharePrice;
					shares=shares+requestedShares;
					JSONArray updatedArray = deleteEntry(jArray,person);
					JSONArray addedEntry = enterEntry(updatedArray,person,availableBalence,shares);
					companyShares=companyShares-requestedShares;
					JSONObject updatedEntry=new JSONObject();
					updatedEntry.put("SharePrice",sharePrice );
					updatedEntry.put("ShareAvailable",companyShares );
					updatedEntry.put("Customers", addedEntry);
					System.out.println("entry"+updatedEntry);
					 HashMap<String,JSONObject> hMap2=new HashMap<>();      //creating 2nd hashmap to store all the entries from file
					 if(companyName.equals("Apple")){
						
						JSONObject company2 = (JSONObject) obj.get("Microsoft");
						 hMap2.put("Apple", updatedEntry);
						 hMap2.put("Microsoft",company2);}
						else{
							JSONObject company2 = (JSONObject) obj.get("Apple");
							 hMap2.put("Microsoft", updatedEntry);
							 hMap2.put("Apple",company2);}
					 
					 JSONObject newObjectdemo=new JSONObject(hMap2);     //converting that hashmap2 into jasonobject
					 
					System.out.println("jason"+newObjectdemo);
					
					@SuppressWarnings("resource")
					FileWriter file = new FileWriter(fileName);     //writing into file
					 file.write(newObjectdemo.toJSONString());
					 //System.out.println("passed"+companyName);
					 file.flush();
					
					
					break;
				}
			}
		}
		
	}
	public JSONArray deleteEntry(JSONArray jArray,String person)
	{
		//Adding values into hashmap
				Utility utility = new Utility();
				JSONArray tempArray=new JSONArray();
				   Iterator itr = jArray.iterator();
				   while(itr.hasNext())
				   {
				   	JSONObject object=(JSONObject)itr.next();
						String check = (String) object.get("Name");
						if(!check.equals(person))
						{
							tempArray.add(object);
						}
				   }
			// jArray.add(tempArray);          //adding that object into existing array

			 //return jArray;
				   //System.out.println(tempArray);
				   return tempArray;
	}public JSONArray enterEntry(JSONArray jArray,String name,Long balence,Long shares)
	{
		//Adding values into hashmap
				Utility utility = new Utility();
				HashMap<String,Generic> hMap = new HashMap<String,Generic>(); 
				hMap.put("Name", (Generic) name);         //storing elements into hashmap
				hMap.put("AvailableBalence", (Generic) balence);
			hMap.put("Shares", (Generic) shares);
		   
				JSONObject newObject=new JSONObject(hMap);     // converting hashmap to jasonobject
			 jArray.add(newObject);          //adding that object into existing array
//System.out.println(jArray);
			 return jArray;
	}
	@SuppressWarnings("unchecked")
	public void sellStocks(String stockName) throws FileNotFoundException, IOException, ParseException
	{
		String fileName = "/home/bridgelabz/Documents/StockAccount.json";
		Object object=parser.parse(new FileReader(fileName));
		JSONObject obj=(JSONObject) object;
		Utility utility = new Utility();
		JSONObject company = (JSONObject) obj.get(stockName);
		Long companyShares = (Long) company.get("ShareAvailable");
	   JSONArray customersInCompany = (JSONArray)company.get("Customers");
		Long SharePrice = (Long) company.get("SharePrice");
		System.out.println("Available Shares : "+company.get("ShareAvailable"));
		System.out.println("Share Price : "+company.get("SharePrice"));
		String custFile="/home/bridgelabz/Documents/customers.json";
		Object custObject=parser.parse(new FileReader(custFile));
		JSONObject custObj=(JSONObject) custObject;
		JSONArray custList = (JSONArray) custObj.get("Customers");
		Iterator itr=custList.iterator();
		System.out.println("Enter the name of the person who wants to buy");
		String buyer = utility.ScanString();
		JSONArray tempList = new JSONArray();
		while(itr.hasNext())
		{
			JSONObject custInfo = (JSONObject) itr.next();
			System.out.println("cust name : "+custInfo.get("Name"));
			String custName = (String)custInfo.get("Name");
			System.out.println("Balence amt : "+custInfo.get("BalenceAmount"));
			System.out.println("shares  : "+custInfo.get("SharesRequested"));
			if(buyer.equals(custName))
					{
				System.out.println("entry");
				//person detail
				Long BalenceAmount=(Long) custInfo.get("BalenceAmount");
				Long shares = (Long) custInfo.get("SharesRequested");
				String name =(String)custInfo.get("Name");
				
				if( shares <= companyShares && BalenceAmount>= (SharePrice*shares))
				{
					System.out.println("again");
					BalenceAmount=BalenceAmount - (SharePrice * shares);
					companyShares = companyShares-shares;
					
					JSONObject tempObject = new JSONObject();
					tempObject.put("Name", name);
					tempObject.put("AvailableBalence", BalenceAmount);
					tempObject.put("Shares", shares);
					customersInCompany.add(tempObject);
					
					
					JSONObject updatedEntry=new JSONObject();
					updatedEntry.put("SharePrice",SharePrice );
					updatedEntry.put("ShareAvailable",companyShares );
					updatedEntry.put("Customers", customersInCompany);
					//System.out.println("entry"+updatedEntry);
					 HashMap<String,JSONObject> hMap2=new HashMap<>();      //creating 2nd hashmap to store all the entries from file
					 if(stockName.equals("Apple")){
						
						JSONObject company2 = (JSONObject) obj.get("Microsoft");
						 hMap2.put("Apple", updatedEntry);
						 hMap2.put("Microsoft",company2);}
						else{
							JSONObject company2 = (JSONObject) obj.get("Apple");
							 hMap2.put("Microsoft", updatedEntry);
							 hMap2.put("Apple",company2);}
					 
					 JSONObject newObjectdemo=new JSONObject(hMap2);     //converting that hashmap2 into jasonobject
					 
					System.out.println("jason"+newObjectdemo);
					
					@SuppressWarnings("resource")
					FileWriter file = new FileWriter(fileName);     //writing into file
					
					 file.write(newObjectdemo.toJSONString());
					 //System.out.println("passed"+companyName);
					 
					 String transaction = "/home/bridgelabz/Documents/Transaction.json";
						Object object2=parser.parse(new FileReader(transaction));
						JSONObject obj2=(JSONObject) object2;
					 JSONArray trans = (JSONArray)obj2.get("Record");
					 
					 JSONObject newTrans = new JSONObject();
					 newTrans.put("State", "sell");
					 newTrans.put("Seller", stockName);
					 newTrans.put("buyer", buyer);
					 
					 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
					   LocalDateTime now = LocalDateTime.now();  
					   System.out.println(dtf.format(now));  
					 newTrans.put("Time", dtf.format(now));
					 FileWriter file2= new FileWriter(transaction);
					 
					 
					 trans.add(newTrans);
					 HashMap<String,JSONArray> hMapForTrans=new HashMap<>();
					 hMapForTrans.put("record", trans);
					 
					 JSONObject newTransition=new JSONObject(hMapForTrans);     //converting that hashmap2 into jasonobject	
						 file2.write(newTransition.toJSONString());
					 file2.flush();
					 file.flush();
					
					
				}
				break;
			}
			
		}
		
	}
	

}
