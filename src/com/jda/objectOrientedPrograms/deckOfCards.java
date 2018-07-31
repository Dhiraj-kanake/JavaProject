package com.jda.objectOrientedPrograms;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.jda.utility.Utility;

public class deckOfCards {
public static void main(String args[])
{
	Utility utility = new Utility();
	String arr[]={"2D","3D","4D","5D","6D","7D","8D","9D","10D","JACK_D","QUEEN_D","KING_D","ACE_D","2C","3C","4C","5C","6C","7C","8C","9C","10C","JACK_C","QUEEN_C","KING_C","ACE_C","2H","3H","4H","5H","6H","7H","8H","9H","10H","JACK_H","QUEEN_H","KING_H","ACE_H","2S","3S","4S","5S","6S","7S","8S","9S","10S","JACK_S","QUEEN_S","KING_S","ACE_S"};

	 Random rnd = ThreadLocalRandom.current();
	 for(int repeat=0;repeat<2;repeat++)
	 {
    for (int i = arr.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      String a = arr[index];
      arr[index] = arr[i];
      arr[i] = a;
    }
	 }
	 String people[][] = new String[4][9];
	 int index=0;
	 for(int i=0;i<4;i++)
	 {
		 for(int j=0;j<9;j++)
		 {
			 people[i][j]=arr[index];
			 index=index+1;
		 }
	 }
	 for(int i=0;i<4;i++)
	 {
		 System.out.println("Player "+(i+1));
		 for(int j=0;j<9;j++)
		 {
			 System.out.print("  "+people[i][j]);
		 }
		 System.out.println();
	 }
	 
   // System.out.println("arrayt: "+Arrays.toString(arr));
}
}
