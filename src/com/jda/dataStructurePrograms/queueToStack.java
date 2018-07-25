package com.jda.dataStructurePrograms;

import com.jda.utility.Node;
import com.jda.utility.QueueUsingNode;
import com.jda.utility.Utility;
import com.jda.utility.stackLinkedList;

public class queueToStack {
public static void main(String args[])
{
	Utility utility = new Utility();
	int month=Integer.parseInt(args[0]);       //month
	int year = Integer.parseInt(args[1]);         //year
	int arr[][]=utility.calenderDays(month,year);       //storing all days in array
	String arrofday[]={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	stackLinkedList mainStack=new stackLinkedList(5);
	stackLinkedList tempStack=new stackLinkedList(5);
	QueueUsingNode queue=new QueueUsingNode(5);        //creating queue
	for(String j : arrofday)              //printing all the days
		System.out.print(j+"     ");
		System.out.println();
		
	for(int i=0;i<5;i++)              //storing each column in single queue
	{
		Node<Object> head=null;
		for(int j=0;j<7;j++)
		{
			Node<Object> newnode;
			if(arr[i][j]==0)
			newnode=new Node<Object>(44);    //arrays empty location filled by any number
			else
			newnode=new Node<Object>(arr[i][j]);       //creating new node with day
			head=Node.addNode(head,newnode);
		}
		queue.enque(head);
		mainStack.push(head);
		}
	Node<Object> newnode1=mainStack.pop();
	Node<Object> newnode=mainStack.pop();
	while(newnode!=null)
	{
		System.out.println("value : "+newnode.data);
		newnode=newnode.next;
	}
	/*for(int i=0;i<5;i++)
	{
	while(!mainStack.isEmpty())
	{
		tempStack.push(mainStack.pop());
	}
	Node<Object> temp=tempStack.pop();
	System.out.println("temp :"+temp.data);
	
	while(temp!=null)
	{
		System.out.println(temp.data);
		temp=temp.next;
	}
	while(!tempStack.isEmpty())
	{
		mainStack.push(tempStack.pop());
	}
}*/
}
}
