package com.jda.dataStructurePrograms;

import java.io.IOException;
import java.util.Arrays;

import com.jda.utility.Node;
import com.jda.utility.Utility;

public class unOrderedListUsingGenerics {
public static void main(String args[]) throws IOException
{
	Utility utility = new Utility();
	String FileName=new String();;
	try {
		FileName = "/home/bridgelabz/Documents/file.txt";
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Node node = new Node(null);
	String ArrayOfString[]=utility.fileSetup(FileName);
	Arrays.asList(ArrayOfString).forEach(System.out::println);
	Node Head = node.createLinkedList(ArrayOfString);
	
	//while(Head.next!=null)
		//System.out.println("Head->data : "+Head.data);
}
}
