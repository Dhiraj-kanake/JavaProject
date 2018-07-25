package com.jda.dataStructurePrograms;

import java.util.ArrayList;

import com.jda.utility.Utility;
import com.jda.utility.stackAnagram;

public class anagramInStack {
public static void main(String args[])
{
	Utility utility=new Utility();
	ArrayList<Integer> list=utility.findRangeOfPrimeNumbers(0,1000 );
	ArrayList<Integer> listOfAnagram=utility.findAnagram(list);
	stackAnagram stackanagram=new stackAnagram(listOfAnagram.size());
	
	System.out.println("listofanagram"+listOfAnagram.size());
	
	for(int i=0;i<listOfAnagram.size();i++)
		stackanagram.push(listOfAnagram.get(i));
	
	System.out.println("Stact Size :"+stackanagram.size());
	int length=stackanagram.size();
	for(int i=0;i<length-1;i++)
	{
		int data=stackanagram.pop();
		if(data!=12)
		System.out.println(data+" ");
		else
			break;
	}
	//System.out.println("Stact Size after :"+stackanagram.size());
}
}
