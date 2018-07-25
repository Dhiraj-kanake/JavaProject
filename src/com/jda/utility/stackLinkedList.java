package com.jda.utility;

public class stackLinkedList {
	Node<Object> main[];
	Node<Object> temp;
	int size;
	int index = 0;
	public stackLinkedList(int size)
	{
		this.size=size;
		main=new Node[size];
	}
	public void push(Node<Object> newNode)
	{
		if(isFull())
		{
			throw new StackOverflowError("stack is full : ");
		}
		main[index]=newNode;
		index++;
	}
	public Node<Object> pop()
	{
		if(isEmpty())
		{
			return null;
		}
		return main[--index];
	}
	public boolean isEmpty()
	{
		if(index==0)
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
