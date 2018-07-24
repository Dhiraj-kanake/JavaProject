package com.jda.dataStructurePrograms;

import com.jda.utility.Node;
import com.jda.utility.Utility;
import com.jda.utility.QueueUsingNode;

public class calenderUsingQueue {
public static void main(String args[])
{
	Utility utility = new Utility();
//	Node<Object> node=new Node<Object>(null);
	int month=Integer.parseInt(args[0]);
	int year = Integer.parseInt(args[1]);
	int arr[][]=utility.calenderDays(month,year);
	String arrofday[]={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	QueueUsingNode queue=new QueueUsingNode(5);
	for(String j : arrofday)
		System.out.print(j+"     ");
		System.out.println();
	for(int i=0;i<5;i++)              //storing each column in single queue
	{
		Node<Object> head=new Node<Object>(null);
		for(int j=0;j<7;j++)
		{
			Node<Object> newnode;
		//	System.out.println(arr[j][i]);
			if(arr[i][j]==0)
			newnode=new Node<Object>(44);
			else
			newnode=new Node<Object>(arr[i][j]);
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
			System.out.printf("   %3d   ",prin.data);
			}
			prin=prin.next;
	}
		System.out.println();
	}
}
}
