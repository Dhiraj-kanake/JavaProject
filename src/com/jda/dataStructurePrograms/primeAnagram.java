package com.jda.dataStructurePrograms;

import java.util.ArrayList;

import com.jda.utility.Utility;

public class primeAnagram {
public static void main(String args[])
{
Utility utility=new Utility();
	
	int i=100;
	ArrayList<ArrayList<Integer>> twoDArray=new ArrayList<ArrayList<Integer>>();
	while(i<=1000)
	{
		ArrayList<Integer> list=utility.findRangeOfPrimeNumbers(i-100,i );
		//System.out.println("for " +(i-100)+" to "+i);
	//	Integer array[]=list.toArray(new Integer[list.size()]);
		ArrayList<Integer> listTwo=utility.findAnagram(list);
		//System.out.println("list : "+listTwo);
		twoDArray.add(listTwo);
		//System.out.println(list);
		i=i+100;
	}
	int index1;
	for( index1=0;index1<twoDArray.size();index1++)
	{
		if(twoDArray.get(index1)!=null)
		{
		for(int j=0;j<twoDArray.get(index1).size();j++)
		{
		
			//System.out.print(twoDArray.get(index1).get(j)+"  ");
		}
		//System.out.println();
		}
	}
	
	
}
}
