package com.jda.dataStructurePrograms;

import java.util.Arrays;

import com.jda.utility.Utility;

public class Calender {
public static void main(String args[])
{
	Utility utility =new Utility();
	int arrOfMonth[] = {31,28,31,30,31,30,31,31,30,31,30,31};
	int month=Integer.parseInt(args[0]);
	int year = Integer.parseInt(args[1]);
	int arr[][] = new int[5][7];
	int day=utility.findDayOfWeekToPrintCalender(1,month,year);
	System.out.println("day : "+day);
	int number=1;
	int i;
	int spaces =day;
	if("Yes".equals(utility.FindLeapYear(year)) && month ==2)
	{
		for(i=0;i<5;i++)
		{
			for(int j=0;j<7;j++)
			{
				if(i==0)
				{
					j=day;
				arr[i][j]=number;
				day=day+1;
				}
				else
				arr[i][j+day]=number;
				number=number+1;
				if(number==30)
					break;
			}
			if(number==30)
				break;
		}
	}
	else
	{
		for(i=0;i<5;i++)
		{
			for(int j=0;j<7;j++)
			{
				if(i==0)
				{
					j=day;
				arr[i][j]=number;
				day=day+1;
				}
				else
					arr[i][j]=number;
				number=number+1;
				if(number==arrOfMonth[month-1]+1)
					break;
			}
			if(number==arrOfMonth[month-1]+1)
				break;
		}
	}
	String arrofday[]={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	int k;
	spaces=(arrOfMonth[month-1]+spaces)%7;
	
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
