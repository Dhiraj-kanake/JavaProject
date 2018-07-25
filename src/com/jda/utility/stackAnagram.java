package com.jda.utility;

public class stackAnagram {
	Node<Object> main;
	Node<Object> temp;
	int size;
	int index = 0;
	public stackAnagram(int size)
	{
		this.size=size;
		main=null;
	}
	public void push(Integer integer)
	{
		if(isFull())
		{
			throw new StackOverflowError("stck is full : ");
		}
		Node<Object> newNode = new Node<Object>(integer);
		if(main==null)
		{
			main=newNode;
		}
		else
		{
			temp=main;
			while(temp.next!=null)
				temp=temp.next;
			newNode.prev=temp;
			temp.next=newNode;
		}
		index++;
		
	}
	public int pop()
	{
		if(isEmpty())
		{
			return 12;
		}
	
		temp=temp.prev;
		index--;
		return (int)temp.data;
	}
	public boolean isEmpty()
	{
		if(temp.prev==null)
			return true;
		return false;
	}
	public boolean isFull()
	{
		if(index==size)
			return true;
		return false;
	}
	public int size()
	{
		return index;
	}

}
