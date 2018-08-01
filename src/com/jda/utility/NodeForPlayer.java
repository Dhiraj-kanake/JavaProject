package com.jda.utility;

import java.util.Map;
import java.util.TreeMap;

public class NodeForPlayer {
	public Map<Integer,String> data;
	NodeForPlayer head=null;
public NodeForPlayer next;
int index =0;
public NodeForPlayer(Map<Integer,String> t)
{
	data=t;
	next = null;
}

public void enque(Map<Integer,String> value)
{
	NodeForPlayer newNode = new NodeForPlayer(value);
	if(head==null)
	{
		head=newNode;
	}
	else
	{
		NodeForPlayer temp = new NodeForPlayer(null);
		temp=head;
		while(temp.next!=null)
			temp=temp.next;
		temp.next=newNode;
	}
	
}
public NodeForPlayer deque()
{
	if(!isEmpty())
	{
		NodeForPlayer temp = head;
		head=head.next;
	return temp;
	}
	else
		return null;
}
public boolean isEmpty()
{
	if(head==null)
		return true;
	return false;
}
public int size()
{
	return index;
}

}
