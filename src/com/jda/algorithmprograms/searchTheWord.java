package com.jda.algorithmprograms;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.jda.utility.Utility;

public class searchTheWord {
public static void main(String args[]) throws IOException
{
	Utility utility=new Utility();
	String stringarray[]=utility.fileSetup();
	System.out.println(Arrays.toString(stringarray));
	ArrayList<String> arraylist=new ArrayList<String>(Arrays.asList(stringarray));
	System.out.print("enter word : ");
	String GivenWord=utility.ScanString();
	if(arraylist.contains(GivenWord))
	{
		System.out.println("found");
	}
	else
		System.out.println("not found");
}
}
