package com.jda.dataStructurePrograms;

import com.jda.utility.Utility;
import com.jda.utility.deque;

public class palindromeCheck {
public static void main(String args[])
{
	Utility utility = new Utility();
	System.out.println("enter string");
	String string=utility.ScanString();
	deque Deque = new deque(string.length());
	for(int i=0;i<string.length();i++)
	{
		Deque.addRear(string.charAt(i));
	}
	boolean flag=false;
	for(int i=0;i<string.length();i++)
	{
		char ch=Deque.removeFront();
		if(ch!=string.charAt(i))
		{
			System.out.println("Not a palindrome");
			flag=true;
			break;
		}
	}
	if(flag==false)
		System.out.println("It is a palindrome");
}
}
