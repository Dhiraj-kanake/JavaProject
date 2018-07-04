package com.jda.utility;
import java.util.Scanner;
public class Utility {
	Scanner scanner;
	public Utility()
	{
		scanner = new Scanner(System.in);
		
	}
	public String ScanString()
	{
	 return scanner.next();
	}
public  String StringReplace (String UserName,String Template)
{
	String result = Template.replace("<<UserName>>", UserName);
	return result;
}
}
