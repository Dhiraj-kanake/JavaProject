package com.jda.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Node <Generic>{
	public Generic data;
	public Node<Generic> next;
	public Node<Generic> prev;
	public Node(Generic data)
	{
		this.data=data;
		this.next=null;
		this.prev=null;
		//System.out.println("this.data :"+this.data); 
	}
	
	
	public Node() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return data.toString();
	}


	public static Node<Object> createLinkedList(String array[])
	{
		//Arrays.asList(array).forEach(System.out::println);
		Node<Object> Head=null;
		Node<Object> Temp=null;
		for(int i=0;i<array.length;i++)
		{
			Node<Object> NewNode = new Node<Object>(array[i]);
			if(Head==null)
			{
				Head=NewNode;
				Temp=Head;
			}
			else
			{
				while(Head.next!=null)
					Head=Head.next;
				Head.next=NewNode;
			}
		}
		return Temp;
	}
	public static void findWord(Node<Object> Head,String SearchWord,String FileName ) throws IOException
	{
		Node Temp=Head;
		FileReader filereader = new FileReader(FileName);
		BufferedReader bufferReader = new BufferedReader(filereader);
		String line=null;
		boolean flag=false;
		while(Temp!=null)
		{
			if(Temp.data.equals(SearchWord))
			{
				System.out.println("Found");
			//	while((line = bufferReader.readLine())!=null)
				 line =bufferReader.readLine();
				line = line.replace(SearchWord,"" );
				FileWriter FW=new FileWriter(FileName);
				BufferedWriter BW = new BufferedWriter(FW);
				BW.write(line);
				flag=true;
				BW.close();
				break;
			}
			Temp=Temp.next;
		}
		if(flag==false)
		{
			System.out.println(" Not Found");
			 line =bufferReader.readLine();
				FileWriter FW=new FileWriter(FileName);
				BufferedWriter BW = new BufferedWriter(FW);
				line =line+" "+SearchWord;
				BW.write(line);
				BW.close();
		}
		System.out.println("new string : "+line);
	}
	public static Node<Object> createOrderedLinkedList(Object array[])
	{
		//Arrays.asList(array).forEach(System.out::println);
		Node<Object> Head=null;
		Node<Object> Temp=null;
		for(int i=0;i<array.length;i++)
		{
			Node<Object> NewNode = new Node<Object>(array[i]);
			if(Head==null)
			{
				Head=NewNode;
				Temp=Head;
			}
			else
			{
				while(Head.next!=null)
				{
					Head=Head.next;
				}
				Head.next=NewNode;
			}
		}
		return Temp;
	}
	public static Node<Object> sortLinkedList(Node<Object> Head)
	{
		System.out.println("inside sort:");
		Node<Object> top = Head;
		if(Head.next==null || Head==null)
			return Head;
		while(Head.next!=null)
		{
			Node<Object> tempOne = Head;
			System.out.println("tempOne : "+tempOne.data);
			Node<Object> tempTwo = tempOne.next;
			while(tempTwo!=null)
			{
				System.out.println("tempTwo : "+tempTwo.data);
				if((int) tempOne.data > (int) tempTwo.data)
				{
					System.out.println("it is less"+tempOne.data +" "+tempTwo.data);
					int data = (int) tempOne.data;
					tempOne.data=tempTwo.data;
					tempTwo.data=data;
				}
				tempTwo=tempTwo.next;
			}
			Head=Head.next;
		}
		return top;
	}
	public void writeInFile(String line,String FileName) throws IOException
	{
		FileWriter FW=new FileWriter(FileName);
		BufferedWriter BW = new BufferedWriter(FW);
		BW.write(line);
		BW.close();
	}
	public void findNumber(Node<Object> list,int number)
	{
		boolean flag=false;
		while(list!=null)
		{
			if((int)list.data==number)
			{
				flag=true;
				break;
			}
			list=list.next;
		}
		if(flag)
			System.out.println("found:");
		else
			System.out.println("not found:");
	}
	public static  Node<Object> addNode(Node<Object> head,Node<Object> newNode)
	{
		Node<Object> temp=head;
		if(temp==null)
			return newNode;
		else
		{
			while(temp.next!=null)
				temp=temp.next;
			temp.next=newNode;
			return head;
		}
	}
}
