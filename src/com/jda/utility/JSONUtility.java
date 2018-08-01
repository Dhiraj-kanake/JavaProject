package com.jda.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
	@SuppressWarnings("unchecked")
	public void getCustomerFile() throws FileNotFoundException, IOException, ParseException
	{
		Utility utility = new Utility();
		
		
		String fileName = "/home/bridgelabz/Documents/StockAccount.json";      //filename
		Object object=parser.parse(new FileReader(fileName));      //reading file as object
		JSONObject obj=(JSONObject) object;             //reading JSONObject
		
		 
		
		String custFile="/home/bridgelabz/Documents/customers.json";         //reading customer file
		Object custObject=parser.parse(new FileReader(custFile));              
		JSONObject custObj=(JSONObject) custObject;
		JSONArray custList = (JSONArray) custObj.get("Customers");      //reading customer list
		Iterator itr=custList.iterator();
		System.out.println("Enter the name of the person who wants to buy");   //person name
		String buyer = utility.ScanString();         
		JSONArray tempList = new JSONArray();
		
		System.out.println("Enter Name of the company from which "+buyer+"  wants to buy stocks");
		System.out.println("1. Apple 2. Microsoft");
		int number = utility.InputInteger();
		String stockName=null;
		if(number ==1)
		 stockName = "Apple";
		else
			stockName = "Microsoft";
		JSONObject company = (JSONObject) obj.get(stockName);       //reading company name
		Long companyShares = (Long) company.get("ShareAvailable");         //reading company shares
	   JSONArray customersInCompany = (JSONArray)company.get("Customers");       //reading customers list
		Long SharePrice = (Long) company.get("SharePrice");             //reading share price
		System.out.println("Available Shares : "+company.get("ShareAvailable"));            //printing share available
		System.out.println("Share Price : "+company.get("SharePrice"));        
		
		while(itr.hasNext())
		{
			JSONObject custInfo = (JSONObject) itr.next();                 //reading json object
			System.out.println("cust name : "+custInfo.get("Name"));           
			String custName = (String)custInfo.get("Name");
			System.out.println("Balence amt : "+custInfo.get("BalenceAmount"));        //printing customer info
			System.out.println("shares  : "+custInfo.get("SharesRequested"));
			if(buyer.equals(custName))
					{
				Long BalenceAmount=(Long) custInfo.get("BalenceAmount");         
				Long shares = (Long) custInfo.get("SharesRequested");
				String name =(String)custInfo.get("Name");
				
				if( shares <= companyShares && BalenceAmount>= (SharePrice*shares))      //if shares are availabe in company
				{																																																	//and person has enough balence
					BalenceAmount=BalenceAmount - (SharePrice * shares);   //updating balence
					companyShares = companyShares-shares;         //updating shares of company
					
					Iterator custItr=customersInCompany.iterator();         //adding new customer
					while(custItr.hasNext())
					{
						JSONObject temp=(JSONObject) custItr.next();
						String duplicateName=(String)temp.get("Name");
						if(buyer.equals(duplicateName))
						{
							shares = shares+ (Long) temp.get("Shares");
							customersInCompany =deleteEntry(customersInCompany,buyer);    //deleting that customer entry
						}
					}
					
					JSONObject tempObject = new JSONObject();       //creating new object for customer
					tempObject.put("Name", name);            
					tempObject.put("AvailableBalence", BalenceAmount);
					tempObject.put("Shares", shares);
					customersInCompany.add(tempObject);           //adding that customer in customer list in company
					
					JSONObject updatedEntry=new JSONObject();       //creating entry for company
					updatedEntry.put("SharePrice",SharePrice );
					updatedEntry.put("ShareAvailable",companyShares );                
					updatedEntry.put("Customers", customersInCompany);
					
					 HashMap<String,JSONObject> hMap2=new HashMap<>();      //creating 2nd hashmap to store all the entries from file
					 if(stockName.equals("Apple")){                         //adding into hashmap
						
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
					 String transaction = "/home/bridgelabz/Documents/Transaction.json";
						Object object2=parser.parse(new FileReader(transaction));
						JSONObject obj2=(JSONObject) object2;
					 JSONObject record = (JSONObject)obj2.get("record");
					 JSONArray trans=(JSONArray)record.get("trans");
					 
					 JSONObject newTrans = new JSONObject();
					 newTrans.put("State", "buy");
					 newTrans.put("Seller", stockName);
					 newTrans.put("buyer", buyer);
					 
				 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
				LocalDateTime now = LocalDateTime.now();  
					  
					 newTrans.put("Time",dtf.format(now));
					 @SuppressWarnings("resource")
					FileWriter file2= new FileWriter(transaction);
					 trans.add(newTrans);
					 record.put("trans",trans );
					 HashMap<String,JSONObject> hMapForTrans=new HashMap<>();
					 hMapForTrans.put("record", record);
					 
					 JSONObject newTransition=new JSONObject(hMapForTrans);     //converting that hashmap2 into jasonobject	
						 file2.write(newTransition.toJSONString());
					 file2.flush();
				
				}
				break;
			}
			
		}
		
		
	}
	@SuppressWarnings("unchecked")
	public void buyStocks(String companyName,String person) throws FileNotFoundException, IOException, ParseException
	{
		String fileName = "/home/bridgelabz/Documents/StockAccount.json";      //reading file
		Object object=parser.parse(new FileReader(fileName));       //converting into object
		JSONObject obj=(JSONObject) object;        //reading JSONObject from file
		Utility utility = new Utility();
		JSONObject company = (JSONObject) obj.get(companyName);         //reading company name
		long companyShares = (long) company.get("ShareAvailable");         //reading company shares and price of shares
		long sharePrice = (long)company.get("SharePrice");
		JSONArray jArray = (JSONArray)company.get("Customers");
		Iterator  itr = jArray.iterator();                   //  applying iterator in array of customer
		while(itr.hasNext())
		{
			JSONObject customerInfo=(JSONObject)itr.next();              
			String name=(String) customerInfo.get("Name");
			if(name.equals(person))                                                       //comparing name of customer with given name
			{
				long availableBalence = (long) customerInfo.get("AvailableBalence");      //if person is available read its available balence
				long shares = (long)customerInfo.get("Shares");                                               // read its shares
				System.out.println("Enter the number of shares he/she wants to buy!");        //requested shares
				long requestedShares =utility.InputInteger();
				if((requestedShares * sharePrice) <= availableBalence)      //if that person has enogh balence
				{
					availableBalence=availableBalence - requestedShares * sharePrice;       //update its available balence
					shares=shares+requestedShares;           //update its shares
					JSONArray updatedArray = deleteEntry(jArray,person);       //delete the already present entry of that person
					JSONArray addedEntry = enterEntry(updatedArray,person,availableBalence,shares);     //enter new entry for that person
					companyShares=companyShares-requestedShares;      //decrease company shares
					JSONObject updatedEntry=new JSONObject();              //create new JSONObject
					updatedEntry.put("SharePrice",sharePrice );                     // create new entry for company
					updatedEntry.put("ShareAvailable",companyShares );
					updatedEntry.put("Customers", addedEntry);
					System.out.println("entry"+updatedEntry);                //printing new entry
					 HashMap<String,JSONObject> hMap2=new HashMap<>();      //creating 2nd hashmap to store all the entries from file
					 if(companyName.equals("Apple")){                  //if it is apple
						
						JSONObject company2 = (JSONObject) obj.get("Microsoft");         //reading other company as it is
						 hMap2.put("Apple", updatedEntry);               //updating apple 
						 hMap2.put("Microsoft",company2);}
						else{
							JSONObject company2 = (JSONObject) obj.get("Apple");          //reading apple as it is
							 hMap2.put("Microsoft", updatedEntry);         //updating microsoft
							 hMap2.put("Apple",company2);}
					 
					 JSONObject newObjectdemo=new JSONObject(hMap2);     //converting that hashmap2 into jasonobject
					 
					System.out.println("Object :: "+newObjectdemo);
					
					@SuppressWarnings("resource")
					FileWriter file = new FileWriter(fileName);     //writing into file
					 file.write(newObjectdemo.toJSONString());
					 file.flush();
					break;
				}
			}
		}
		
	}
	@SuppressWarnings("unchecked")
	public JSONArray deleteEntry(JSONArray jArray,String person)
	{
				Utility utility = new Utility();
				JSONArray tempArray=new JSONArray();              //new json array
				   @SuppressWarnings("rawtypes")
					Iterator itr = jArray.iterator(); 
				   while(itr.hasNext())
				   {
				   	JSONObject object=(JSONObject)itr.next();
						String check = (String) object.get("Name");
						if(!check.equals(person))
						{
							tempArray.add(object);                     //storing all entry except that person 
						}
				   }
				   return tempArray;
	}
	@SuppressWarnings("unchecked")
	public JSONArray enterEntry(JSONArray jArray,String name,Long balence,Long shares)
	{
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
		String fileName = "/home/bridgelabz/Documents/StockAccount.json";      //filename
		Object object=parser.parse(new FileReader(fileName));      //reading file as object
		JSONObject obj=(JSONObject) object;             //reading JSONObject
		Utility utility = new Utility();
		JSONObject company = (JSONObject) obj.get(stockName);       //reading company name
		Long companyShares = (Long) company.get("ShareAvailable");         //reading company shares
	   JSONArray customersInCompany = (JSONArray)company.get("Customers");       //reading customers list
		Long SharePrice = (Long) company.get("SharePrice");             //reading share price
		System.out.println("Available Shares : "+company.get("ShareAvailable"));            //printing share available
		System.out.println("Share Price : "+company.get("SharePrice"));         
		String custFile="/home/bridgelabz/Documents/customers.json";         //reading customer file
		Object custObject=parser.parse(new FileReader(custFile));              
		JSONObject custObj=(JSONObject) custObject;
		JSONArray custList = (JSONArray) custObj.get("Customers");      //reading customer list
		Iterator itr=custList.iterator();
		System.out.println("Enter the name of the person who wants to buy");   //person name
		String buyer = utility.ScanString();         
		JSONArray tempList = new JSONArray();
		while(itr.hasNext())
		{
			JSONObject custInfo = (JSONObject) itr.next();                 //reading json object
			System.out.println("cust name : "+custInfo.get("Name"));           
			String custName = (String)custInfo.get("Name");
			System.out.println("Balence amt : "+custInfo.get("BalenceAmount"));        //printing customer info
			System.out.println("shares  : "+custInfo.get("SharesRequested"));
			if(buyer.equals(custName))
					{
				Long BalenceAmount=(Long) custInfo.get("BalenceAmount");         
				Long shares = (Long) custInfo.get("SharesRequested");
				String name =(String)custInfo.get("Name");
				
				if( shares <= companyShares && BalenceAmount>= (SharePrice*shares))      //if shares are availabe in company
				{																																																	//and person has enough balence
					BalenceAmount=BalenceAmount - (SharePrice * shares);   //updating balence
					companyShares = companyShares-shares;         //updating shares of company
					
					Iterator custItr=customersInCompany.iterator();         //adding new customer
					while(custItr.hasNext())
					{
						JSONObject temp=(JSONObject) custItr.next();
						String duplicateName=(String)temp.get("Name");
						if(buyer.equals(duplicateName))
						{
							shares = shares+ (Long) temp.get("Shares");
							customersInCompany =deleteEntry(customersInCompany,buyer);    //deleting that customer entry
						}
					}
					
					JSONObject tempObject = new JSONObject();       //creating new object for customer
					tempObject.put("Name", name);            
					tempObject.put("AvailableBalence", BalenceAmount);
					tempObject.put("Shares", shares);
					customersInCompany.add(tempObject);           //adding that customer in customer list in company
					
					JSONObject updatedEntry=new JSONObject();       //creating entry for company
					updatedEntry.put("SharePrice",SharePrice );
					updatedEntry.put("ShareAvailable",companyShares );                
					updatedEntry.put("Customers", customersInCompany);
					
					 HashMap<String,JSONObject> hMap2=new HashMap<>();      //creating 2nd hashmap to store all the entries from file
					 if(stockName.equals("Apple")){                         //adding into hashmap
						
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
					 String transaction = "/home/bridgelabz/Documents/Transaction.json";
						Object object2=parser.parse(new FileReader(transaction));
						JSONObject obj2=(JSONObject) object2;
					 JSONObject record = (JSONObject)obj2.get("record");
					 JSONArray trans=(JSONArray)record.get("trans");
					 
					 JSONObject newTrans = new JSONObject();
					 newTrans.put("State", "sell");
					 newTrans.put("Seller", stockName);
					 newTrans.put("buyer", buyer);
					 
				 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
				LocalDateTime now = LocalDateTime.now();  
					  
					 newTrans.put("Time",dtf.format(now));
					 @SuppressWarnings("resource")
					FileWriter file2= new FileWriter(transaction);
					 trans.add(newTrans);
					 record.put("trans",trans );
					 HashMap<String,JSONObject> hMapForTrans=new HashMap<>();
					 hMapForTrans.put("record", record);
					 
					 JSONObject newTransition=new JSONObject(hMapForTrans);     //converting that hashmap2 into jasonobject	
						 file2.write(newTransition.toJSONString());
					 file2.flush();
				
				}
				break;
			}
			
		}
		
	}
	public void printReport() throws FileNotFoundException, IOException, ParseException
	{
		String fileName = "/home/bridgelabz/Documents/Transaction.json";
		Object object=parser.parse(new FileReader(fileName));
		JSONObject jObject =(JSONObject)object;
		JSONObject record = (JSONObject)jObject.get("record");
		 JSONArray trans=(JSONArray)record.get("trans");
		 System.out.println("trans : "+trans );
	}
	@SuppressWarnings("unchecked")
	public void sellStocksByPerson(String stockName) throws FileNotFoundException, IOException, ParseException
	{
		String fileName = "/home/bridgelabz/Documents/StockAccount.json";      //filename
		Object object=parser.parse(new FileReader(fileName));      //reading file as object
		JSONObject obj=(JSONObject) object;             //reading JSONObject
		Utility utility = new Utility();
		JSONObject company = (JSONObject) obj.get(stockName);       //reading company name
		
		System.out.println("enter person name who wants to sell :");
		String seller=utility.ScanString();
		
		
		Long companyShares = (Long) company.get("ShareAvailable");         //reading company shares
		 Long SharePrice = (Long) company.get("SharePrice");             //reading share price
		 
	   JSONArray customersInCompany = (JSONArray)company.get("Customers");       //reading customers list
	
	  System.out.println("How many shares "+seller +" wants to sell ?");
	 Long shareCount =utility.InputLong();
	 Long shareAvailableToSell=null;
	   Iterator iteratr = customersInCompany.iterator();
	   while(iteratr.hasNext())
	   {
	   	JSONObject objectToChange = (JSONObject) iteratr.next() ;
	   	String nameOfPerson = (String)objectToChange.get("Name");
	   	if(seller.equals(nameOfPerson))
	   	{
	   		System.out.println("Name : "+objectToChange.get("Name"));
	   		System.out.println("Available Shares : "+objectToChange.get("Shares"));
	   		System.out.println("Available balence : " +objectToChange.get("AvailableBalence"));
	   		Long availableBalence = (Long) objectToChange.get("AvailableBalence");
	   		Long availableShares = (Long) objectToChange.get("Shares");
	   		shareAvailableToSell = availableShares;
	   		String Name =(String)objectToChange.get("Name");
	   		if(shareCount < availableShares)
	   		{
	   			availableShares= availableShares-shareCount;
	   			availableBalence = availableBalence+(shareCount*SharePrice);
	   			JSONObject tempObject = new JSONObject();       //creating new object for customer
					tempObject.put("Name", Name);            
					tempObject.put("AvailableBalence", availableBalence);
					tempObject.put("Shares", availableShares);
					
					JSONArray updatedArray = deleteEntry(customersInCompany,Name);       //delete the already present entry of that person
					customersInCompany = enterEntry(updatedArray,Name,availableBalence,availableShares);     //enter new entry for that person
 
	   		}
	   		else if(shareCount==availableShares)
	   		{
	   			customersInCompany = deleteEntry(customersInCompany,Name);       //delete the already present entry of that person
	   		}
	   		else if(shareCount > availableShares )
	   		{
	   			System.out.println("not enpugh shares");
	   			break;
	   		}
	   		
	   	}
	   }
	 
		String custFile="/home/bridgelabz/Documents/customers.json";         //reading customer file
		Object custObject=parser.parse(new FileReader(custFile));              
		JSONObject custObj=(JSONObject) custObject;
		JSONArray custList = (JSONArray) custObj.get("Customers");      //reading customer list
		Iterator itr=custList.iterator();
		System.out.println("Enter the name of the person who wants to buy");   //person name
		String buyer = utility.ScanString();         
		JSONArray tempList = new JSONArray();
		while(itr.hasNext())
		{
			JSONObject custInfo = (JSONObject) itr.next();                 //reading json object
			System.out.println("cust name : "+custInfo.get("Name"));           
			String custName = (String)custInfo.get("Name");
			System.out.println("Balence amt : "+custInfo.get("BalenceAmount"));        //printing customer info
			//System.out.println("shares  : "+custInfo.get("SharesRequested"));
			if(buyer.equals(custName))
					{
				Long BalenceAmount=(Long) custInfo.get("BalenceAmount");         
				Long shares = shareCount;
				String name =(String)custInfo.get("Name");
				
				if( shareCount <=  shareAvailableToSell && BalenceAmount>= (SharePrice*shareCount))      //if shares are availabe in company
				{																																																	//and person has enough balence
					BalenceAmount=BalenceAmount - (SharePrice * shareAvailableToSell);   //updating balence
					Iterator custItr=customersInCompany.iterator();         //adding new customer
					while(custItr.hasNext())
					{
						JSONObject temp=(JSONObject) custItr.next();
						String duplicateName=(String)temp.get("Name");
						if(buyer.equals(duplicateName))
						{
							shares = shares+ (Long) temp.get("Shares");
							customersInCompany =deleteEntry(customersInCompany,buyer);    //deleting that customer entry
						}
					}
					
					JSONObject tempObject = new JSONObject();       //creating new object for customer
					tempObject.put("Name", name);            
					tempObject.put("AvailableBalence", BalenceAmount);
					tempObject.put("Shares", shares);
					customersInCompany.add(tempObject);           //adding that customer in customer list in company
					
					JSONObject updatedEntry=new JSONObject();       //creating entry for company
					updatedEntry.put("SharePrice",SharePrice );
					updatedEntry.put("ShareAvailable",companyShares );                
					updatedEntry.put("Customers", customersInCompany);
					
					 HashMap<String,JSONObject> hMap2=new HashMap<>();      //creating 2nd hashmap to store all the entries from file
					 if(stockName.equals("Apple")){                         //adding into hashmap
						
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
					 String transaction = "/home/bridgelabz/Documents/Transaction.json";
						Object object2=parser.parse(new FileReader(transaction));
						JSONObject obj2=(JSONObject) object2;
					 JSONObject record = (JSONObject)obj2.get("record");
					 JSONArray trans=(JSONArray)record.get("trans");
					 
					 JSONObject newTrans = new JSONObject();
					 newTrans.put("State", "sell");
					 newTrans.put("Seller", stockName);
					 newTrans.put("buyer", buyer);
					 
				 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
				LocalDateTime now = LocalDateTime.now();  
					  
					 newTrans.put("Time",dtf.format(now));
					 @SuppressWarnings("resource")
					FileWriter file2= new FileWriter(transaction);
					 trans.add(newTrans);
					 record.put("trans",trans );
					 HashMap<String,JSONObject> hMapForTrans=new HashMap<>();
					 hMapForTrans.put("record", record);
					 
					 JSONObject newTransition=new JSONObject(hMapForTrans);     //converting that hashmap2 into jasonobject	
						 file2.write(newTransition.toJSONString());
					 file2.flush();
				
				}
				break;
			}
			
		}
		
	}
	

}
