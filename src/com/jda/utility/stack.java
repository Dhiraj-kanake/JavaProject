package com.jda.utility;
import java.util.EmptyStackException;
public class stack {
char Array[];
int size;
int index = 0;
public stack(int size)
{
	this.size=size;
	Array=new char[size];
}
public void push(char ch)
{
	if(isFull())
	{
		throw new StackOverflowError("stck is full : ");
	}
	Array[index]=ch;
	index++;
}
public char pop()
{
	if(isEmpty())
	{
		return 'T';
	}
	return Array[--index];
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
