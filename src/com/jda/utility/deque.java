package com.jda.utility;

public class deque {
int front;
int rear;
int size;
int index=0;
char Deque[];
public deque(int size)
{
	this.size=size;
	this.rear=size-1;
	this.front=0;
	Deque=new char[size];
}
public void addFront(char ch)
{
	if(isFull())
	{
		throw new StackOverflowError("Deque is full");
	}
	Deque[front]=ch;
	front++;
}
public void addRear(char ch)
{
	if(isFull())
	{
		throw new StackOverflowError("Deque is full");
	}
	Deque[rear]=ch;
	rear--;
}
public char removeFront()
{
	return Deque[index++];
}
public boolean isFull()
{
	if(front==size)
		return true;
	if(rear==-1)
		return true;
	return false;
}

}
