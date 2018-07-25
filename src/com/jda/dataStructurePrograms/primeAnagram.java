package com.jda.dataStructurePrograms;

import java.util.ArrayList;

import com.jda.utility.Utility;

public class primeAnagram {
public static void main(String args[])
{
Utility utility=new Utility();
	
	int i=100;
	ArrayList<ArrayList<Integer>> twoDArray=new ArrayList<ArrayList<Integer>>();
	ArrayList<ArrayList<Integer>> notAnagram=new ArrayList<ArrayList<Integer>>();
	while(i<=1000)
	{
		ArrayList<Integer> list=utility.findRangeOfPrimeNumbers(i-100,i );
		ArrayList<Integer> listTwo=utility.findAnagram(list);
		ArrayList<Integer> listNotAnagram=new ArrayList<Integer>();
		for(int k=0;k<list.size();k++)
		{
			if(!listTwo.contains(list.get(k)))
			{
				listNotAnagram.add(list.get(k));
			}
		}
		notAnagram.add(listNotAnagram);
		twoDArray.add(listTwo);
		i=i+100;
	}
	int index1;
	for( index1=0;index1<twoDArray.size();index1++)
	{
		if(twoDArray.get(index1)!=null)
		{
		for(int j=0;j<twoDArray.get(index1).size();j++)
			System.out.print(twoDArray.get(index1).get(j)+"  ");
		System.out.println(" ");
		}
		
	}
	int index2;
	 for(index2=0;index2<notAnagram.size();index2++)
	 {
		 for(int j=0;j<notAnagram.get(index2).size();j++)
		 {
			 System.out.print(notAnagram.get(index2).get(j)+"  " );
		 }
		 System.out.println();
	 }
	
	
}
}
