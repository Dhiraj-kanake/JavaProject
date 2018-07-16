package com.jda.dataStructurePrograms;

import java.io.IOException;

import com.jda.utility.Utility;

public class unOrderedList {
public static<T> void main(String args[]) throws IOException
{
	Utility utility=new Utility();
	
	String FileName=new String();;
	try {
		FileName = "/home/bridgelabz/Documents/file.txt";
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String ArrayOfString[]=utility.fileSetup(FileName);
	utility.createLinkedList(ArrayOfString);
	
}
}
