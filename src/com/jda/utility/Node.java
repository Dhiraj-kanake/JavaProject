package com.jda.utility;

import java.util.Arrays;

public class Node <Generic>{
	public Generic data;
	public Node<Generic> next;
	public Node(Generic data)
	{
		this.data=data;
		this.next=null;
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
}
