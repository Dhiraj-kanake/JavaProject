package com.jda.dataStructurePrograms;

import java.util.ArrayList;

import com.jda.utility.Utility;
import com.jda.utility.queueLinkedList;

public class anagramInQueue {
	public static void main(String args[])
	{
		Utility utility=new Utility();
		ArrayList<Integer> list=utility.findRangeOfPrimeNumbers(0,1000 );
		ArrayList<Integer> listOfAnagram=utility.findAnagram(list);
		queueLinkedList Queue=new queueLinkedList(listOfAnagram.size());
		for(int i=0;i<listOfAnagram.size();i++)
		{
			Queue.enque(listOfAnagram.get(i));
		}
		
		int length=Queue.size();
		for(int i=0;i<length;i++)
			System.out.println(Queue.deque());
	}

}
