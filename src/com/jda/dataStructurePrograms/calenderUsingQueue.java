package com.jda.dataStructurePrograms;

import com.jda.utility.Node;
import com.jda.utility.Utility;
import com.jda.utility.QueueUsingNode;

public class calenderUsingQueue {
public static void main(String args[])
{
	Utility utility = new Utility();
	int month=Integer.parseInt(args[0]);       //month
	int year = Integer.parseInt(args[1]);         //year
	int arr[][]=utility.calenderDays(month,year);       //storing all days in array
	String arrofday[]={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	QueueUsingNode queue=new QueueUsingNode(5);        //creating queue
	for(String j : arrofday)              //printing all the days
		System.out.print(j+"     ");
		System.out.println();
		
	for(int i=0;i<5;i++)              //storing each column in single queue
	{
		Node<Object> head=new Node<Object>(null);
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
		}
	for(int index=0;index<5;index++)
	{
		Node<Object> prin=queue.deque();
		while(prin!=null)
		{
			if(prin.data!=null)
			{
				if((int)prin.data==44)
					System.out.print("             ");
				else
			System.out.printf("    %3d    ",prin.data);
			}
			prin=prin.next;
	}
		System.out.println();
	}
}
}