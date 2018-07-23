package com.jda.dataStructurePrograms;

import com.jda.utility.Utility;
import com.jda.utility.queue;

public class queueAbstract {
public static void main(String args[])
{
	Utility utility = new Utility();
	System.out.println("Enter bank balance : ");
	int bankBalence = utility.InputInteger();
	System.out.println("Enter number of people");
	int people = utility.InputInteger();
	queue Queue=new queue(people);
	for(int i=0;i<people;i++)
	{
		System.out.println("For  person : "+(i+1));
		System.out.println("Enter 1 for Deposit and 2 for Withdraw :");
		int input = utility.InputInteger();
		System.out.println("Enter amount :");
		int amount= utility.InputInteger();
		if(input==2)
			Queue.enqueue(amount*-1);
		else
			Queue.enqueue(amount);
	}
	System.out.println();
	System.out.println("Initial Balence : "+bankBalence);
	for(int i=1;i<=people;i++)
	{
		System.out.println("For person :"+i);
		int amt=Queue.dequeue();
		if(amt>0)
		{
			System.out.println("Service : Deposit");
			bankBalence=bankBalence+amt;
			System.out.println(" Bank Balence : "+bankBalence);
			System.out.println("person wants to deposit :  "+amt);
			System.out.println("Transaction successful ");
			System.out.println("Bank balence : "+bankBalence);
			System.out.println("\n");
			
		}
		else
		{
			System.out.println("Service : withdraw");
			if(amt*-1>bankBalence)
			{
				System.out.println(" Bank Balence : "+bankBalence);
				System.out.println("person wants to withdraw :  "+(-1*amt));
				System.out.println("Transaction unsuccessful ");
				System.out.println("\n");
			}
			else
			{
				bankBalence=bankBalence+amt;
				System.out.println(" Bank Balence : "+bankBalence);
				System.out.println("person wants to withdraw :  "+(-1*amt));
				System.out.println("Transaction successful ");
				System.out.println("Bank balence : "+bankBalence);
				System.out.println("\n");
			}
		}
			
	}
}
}
