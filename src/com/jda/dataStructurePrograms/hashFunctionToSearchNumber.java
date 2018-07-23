package com.jda.dataStructurePrograms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import com.jda.utility.Node;
import com.jda.utility.Utility;

public class hashFunctionToSearchNumber {
public static void main(String args[]) throws IOException
{
	Utility utility=new Utility();
	String FileName="/home/bridgelabz/Documents/integers.txt";
	String arr[] = utility.fileSetup(FileName);
	int ArrayOfInt[] =new int[arr.length];
	for(int i=0;i<arr.length;i++)
		ArrayOfInt[i] = Integer.parseInt(arr[i]);
	LinkedList<Integer> list=new LinkedList<>();
	System.out.println(ArrayOfInt[1]);
	HashMap<Integer,LinkedList<Integer>> hashmap = new HashMap<>();
	
	for(int i=0;i<11;i++)
	{
		list=createLinkedList(i,ArrayOfInt);
		hashmap.put(i,list);
		
	}
	System.out.println(hashmap.get(1));
}
public static LinkedList<Integer> createLinkedList(int key,int arrayOfInt[])
{
	Node linkedlist=new Node(null);
	ArrayList<Integer> arraylist = new ArrayList<>();
	for(int i=0;i<arrayOfInt.length;i++)
	{
		if(key==arrayOfInt[i]%11)
			arraylist.add(arrayOfInt[i]);
	}
	Object[] arr=arraylist.toArray();
	return list;
}
}
