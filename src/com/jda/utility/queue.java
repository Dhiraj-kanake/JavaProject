package com.jda.utility;


public class queue {
	int size;
int Queue[];
int index=0;
int front=0;
public queue(int size)
{
	this.size=size;
	Queue=new int[size];
}
public void enqueue(int money)
{
if(isFull())
{
	throw new StackOverflowError("Queue is full");
}
Queue[index]=money;
index++;
}
public int dequeue()
{
	return Queue[front++];
}
public boolean isFull()
{
	if(index==size)
		return true;
	else
		return false;		
}

}
