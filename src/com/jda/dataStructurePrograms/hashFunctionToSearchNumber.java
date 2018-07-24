package com.jda.dataStructurePrograms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.jda.utility.Node;
import com.jda.utility.Utility;

public class hashFunctionToSearchNumber {
public static void main(String args[]) throws IOException
{
	Utility utility=new Utility();
	Node<Object> node = new Node<Object>(null);
	String FileName="/home/bridgelabz/Documents/integers.txt";
	String arr[] = utility.fileSetup(FileName);
	int ArrayOfInt[] =new int[arr.length];
	for(int i=0;i<arr.length;i++)
		ArrayOfInt[i] = Integer.parseInt(arr[i]);
	Node<Object> list = new Node<Object>(null);
	//System.out.println(ArrayOfInt[1]);
	HashMap<Integer,Node<Object>> hashmap = new HashMap<>();
	
	for(int i=0;i<11;i++)
	{
		list=createLinkedList(i,ArrayOfInt);      //creating linked list for each key
		hashmap.put(i,list);
		
	}
	System.out.println("Enter number to search :");
	int number=utility.InputInteger();
	Node<Object> lst=hashmap.get(number%11);
	Node<Object> temp=lst;
	while(temp!=null)
	{
		System.out.print(temp.data+" ");
		temp=temp.next;
	}
	temp=lst;
	System.out.println();
	node.findNumber(temp,number);
}
public static Node<Object> createLinkedList(int key,int arrayOfInt[])
{
	//Node<Object> node = new Node<Object>(null);
	Node<Object> linkedlist=new Node<Object>(null);
	ArrayList<Integer> arraylist = new ArrayList<>();
	for(int i=0;i<arrayOfInt.length;i++)
	{
		if(key==arrayOfInt[i]%11)
			arraylist.add(arrayOfInt[i]);
	}
	Object[] arr=arraylist.toArray();
	linkedlist = Node.createOrderedLinkedList(arr);
	return linkedlist;
}
}
