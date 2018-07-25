package com.jda.utility;

public class QueueUsingNode {
	int size;
	int index=0;
	int front=0;
	Node<Object> queue[];
	Node<Object> node=new Node<Object>();
	int rear;	
public QueueUsingNode(int size)
{
	this.size=size;
	queue=new Node[size];
}
public void enque(Node<Object> head)
{
if(isFull())
{
	throw new StackOverflowError("Queue is full");
}
queue[index]=head;
index++;
}
public Node<Object> deque()
{
	
	return queue[front++];
}
public boolean isFull()
{
	if(index==size)
		return true;
	else
		return false;		
}
public int size()
{
	return size;
}
}
