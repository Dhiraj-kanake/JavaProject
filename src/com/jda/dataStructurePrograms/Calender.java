package com.jda.dataStructurePrograms;

import java.util.Arrays;

import com.jda.utility.Utility;

public class Calender {
public static void main(String args[])
{
	Utility utility =new Utility();
	int month=Integer.parseInt(args[0]);
	int year = Integer.parseInt(args[1]);
	int arr[][] = utility.calenderDays(month, year);
	String arrofday[]={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	int k;
	//spaces=(arrOfMonth[month-1]+spaces)%7;
	
	//for(int sp=0;sp<spaces;sp++)
	//	System.out.print("     ");
	
	for(String j : arrofday)
	System.out.print(j+"   ");
	System.out.println();
	for(k=0;k<5;k++)
	{
		for(int j=0;j<7;j++)
		{
			if(arr[k][j]==0)
				System.out.print("           ");
			else
			System.out.printf("    %3d ",arr[k][j]);
		}
		System.out.println();
	}
	
}
}
