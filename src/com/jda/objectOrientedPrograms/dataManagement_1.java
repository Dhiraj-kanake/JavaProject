package com.jda.objectOrientedPrograms;

import com.jda.utility.JSONUtility;

public class dataManagement_1 <T>{
public static void main(String args[])
{
	JSONUtility utility=new JSONUtility();
	System.out.println("*****Rice  Varities******");
	utility.getInfo("Rice");
	System.out.println("*****Pulse  Varities******");
	utility.getInfo("Pulse");
	System.out.println("*****Wheat  Varities******");
	utility.getInfo("Wheat");
}
}
