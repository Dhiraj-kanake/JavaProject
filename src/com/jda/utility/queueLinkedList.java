package com.jda.utility;

public class queueLinkedList {
	Node<Object> main;
	Node<Object> temp;
	int size;
	int index = 0;
	public queueLinkedList(int size)
	{
		this.size=size;
		main=null;
	}
	public void enque(Integer integer)
	{
		if(isFull())
		{
			throw new StackOverflowError("queue is full : ");
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
	public int deque()
	{
		if(isEmpty())
		{
			return 12;
		}
	if(index==size)
	{
		index--;
		return (int)main.data;

	}
	 main=main.next;
		index--;
		return (int)main.data;
	}
	public boolean isEmpty()
	{
		if(main.next==null)
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
