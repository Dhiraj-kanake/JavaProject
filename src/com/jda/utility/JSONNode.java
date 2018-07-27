package com.jda.utility;

import java.util.ArrayList;

public class JSONNode {
	String Name;
	String Stocks;
	long sharePrice;
	ArrayList<String> companyList=new ArrayList<>();
	JSONNode next;
	public JSONNode(String Name,String Stocks,long sharePrice,ArrayList<String> companyList)
	{
		this.Name=Name;
		this.Stocks=Stocks;
		this.sharePrice=sharePrice;
		this.companyList.addAll(companyList);
		this.next=null;
	}
	
	public static Node<Object> Node(String array[])
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
