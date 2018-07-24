package com.jda.dataStructurePrograms;

import java.io.IOException;

import com.jda.utility.Node;
import com.jda.utility.Utility;

public class orderedLinkedList {
	public static void main(String args[]) throws IOException
	{
		Utility utility = new Utility();
		String FileName=new String();;
		try {
			FileName = "/home/bridgelabz/Documents/integers.txt";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Node node = new Node(null);
		String ArrayOfString[]=utility.fileSetup(FileName);
		Integer ArrayOfInteger[]=new Integer[ArrayOfString.length];
		for(int i=0;i<ArrayOfString.length;i++)
		{
			ArrayOfInteger[i]=Integer.parseInt(ArrayOfString[i]);
		}
		//Arrays.asList(ArrayOfString).forEach(System.out::println);
		Node Head = node.createOrderedLinkedList(ArrayOfInteger);
		Head=node.sortLinkedList(Head);
		Node Temp=Head;
		
		while(Temp!=null)
		{
			System.out.println("Head->data : "+Temp.data);
			Temp=Temp.next;
		}
		System.out.println("Enter element : ");
		int inputValue = utility.InputInteger();
		boolean flag =false;
		Temp=Head;
		while(Temp!=null)
		{
			if((int) Temp.data == inputValue)
			{
				System.out.println("Found : "+Temp.data);
				flag=true;
			}
			Temp=Temp.next;
		}
		Temp=Head;
		if(flag==false)
		{
			int ArrayOfIntegerTwo[]=new int[ArrayOfString.length+1];
			System.out.println("Not Found : ");
			Node<Object> newNode = new Node<Object>(inputValue);
			while(Temp.next!=null)
				Temp=Temp.next;
			Temp.next=newNode;
			
			Temp=node.sortLinkedList(Head);
			System.out.println("Sorted : ");
			int k=0;
			String line =new String();
			while(Temp!=null)
			{
				line=line +Temp.data +" ";
				ArrayOfIntegerTwo[k]=(int) Temp.data;
				System.out.println("Head->data : "+Temp.data);
				Temp=Temp.next;
				k=k+1;
			}
			System.out.println("line :"+line);
			node.writeInFile(line,FileName);
		}
	}

}
