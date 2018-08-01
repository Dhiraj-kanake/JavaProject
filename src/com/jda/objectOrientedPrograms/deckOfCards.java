package com.jda.objectOrientedPrograms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;
import com.jda.utility.NodeForPlayer;
public class deckOfCards {
public static void main(String args[])
{
	NodeForPlayer Node = new NodeForPlayer(null);
	String arr[]={"2D","2H","2S","2C","3D","3H","3S","3C","4D","4H","4S","4C","5D","5H","5S","5C","6D","6H","6S","6C","7D","7H","7S","7C","8D","8H","8S","8C","9D","9H","9S","9C","10D","10H","10S","10C","JACK_D","JACK_H","JACK_S","JACK_C","QUEEN_D","QUEEN_H","QUEEN_S","QUEEN_C","KING_D","KING_H","KING_S","KING_C","ACE_D","ACE_H","ACE_S","ACE_C",};
	String arr2[]={"2D","2H","2S","2C","3D","3H","3S","3C","4D","4H","4S","4C","5D","5H","5S","5C","6D","6H","6S","6C","7D","7H","7S","7C","8D","8H","8S","8C","9D","9H","9S","9C","10D","10H","10S","10C","JACK_D","JACK_H","JACK_S","JACK_C","QUEEN_D","QUEEN_H","QUEEN_S","QUEEN_C","KING_D","KING_H","KING_S","KING_C","ACE_D","ACE_H","ACE_S","ACE_C",};
	 Random rnd = ThreadLocalRandom.current();       //random function to shuffle cards
	 for(int repeat=0;repeat<2;repeat++){
    for (int i = arr.length - 1; i > 0; i--) {
      int index = rnd.nextInt(i + 1);
      String a = arr[index];
      arr[index] = arr[i];
      arr[i] = a;
    }}
	 
	 System.out.println("array: "+Arrays.toString(arr));   //shuffled array of cards
	 String people[][] = new String[4][9];         //distributing it to 4 players
	 int index=0;
	 for(int i=0;i<4;i++){
		 for(int j=0;j<9;j++){
			 people[i][j]=arr[index];
			 index=index+1;
		 }}
	 for(int i=0;i<4;i++)
	 {
		 System.out.println("Player "+(i+1));
		 for(int j=0;j<9;j++)
		 {
			 System.out.print("  "+people[i][j]);           // printing cards of each player
		 }
		 System.out.println();
	 }
	 /* ******* sorting cards of each players ********/
	 
	 int sortedIndex[]=new int[36];       //arrays to store sorted index
	 int indexArray=0;
	 for(int i=0;i<4;i++)
	 {
		 HashMap<Integer,String> hMap=new HashMap<>();        
		 for(int j=0;j<9;j++)
		 {
			 for(int indexOfSortedArray=0;indexOfSortedArray<52;indexOfSortedArray++)
			 {
				 if(arr2[indexOfSortedArray].equals(people[i][j]))           //if value is equal then store its index
				 {
					 sortedIndex[indexArray] = indexOfSortedArray;
					 hMap.put(indexOfSortedArray,people[i][j] );
					 indexArray+=1;
				 } }	 }
		 Map<Integer,String> tMap=new TreeMap<>(hMap);           // put sorted array of each player into map
		 Node.enque(tMap);                   //storing into queue
	 }
	 NodeForPlayer head = Node.deque();
	 while(head!=null)																												//printing queue
	 {
		System.out.println("For player :");
		 TreeMap<Integer,String> temp = (TreeMap<Integer, String>) head.data;
		 for(Map.Entry<Integer, String> entry : temp.entrySet())
			{
				System.out.print("  "+entry.getValue());
			}
		 head=head.next;
		 System.out.println("");
	 }}}
