package com.jda.utility;
import java.util.Scanner;
import java.util.Random;
public class Utility {
	Scanner scanner;
	public Utility()
	{
		scanner = new Scanner(System.in);
		
	}
	public String ScanString()
	{
	 return scanner.next();
	}
	public int InputInteger()
	{
		return scanner.nextInt();
	}
public  String StringReplace (String UserName,String Template)
{
	String result = Template.replace("<<UserName>>", UserName);
	return result;
}
public void PrimeFactors(int Number)
{
	int dividend=Number;
	int i;
	for(i=2;i*i<=dividend;i++)
	{
		if(dividend%i==0)
		{
			System.out.println(i);
			dividend=dividend/i;
			i=2;
		}
	}
	System.out.println(dividend);
}
public double FindHarmonicMean(int Number)
{
	double result = 0;
	for(float i=1;i<=Number;i++)
	{
		result=result+(1/i);
		//System.out.println(1/i);
	}
	return result;
}
public void PowerOfN(int Number)
{
	for(int i=0 ;i<Number;i++)
	{
		if(i<31)
		System.out.println( Math.pow(2, i));
	}
}
public String FindLeapYear(int Year)
{
	if(Year%4 ==0 || Year%100 ==0)
		return "Yes";
	else
		return "No";
}
public void FindWinLossOFGambler(double AvailableCash,double Goal,double NumberOfChances)
{
	Random r = new Random();
	int Low = 1;
	int High = 3;
	double win=0,lose=0;
	for(int i=0;i<NumberOfChances;i++)
	{
	int result = r.nextInt(High-Low) + Low;
	//System.out.println("Random number is"+result);
	if(result==1)  //result=1 means gambler won
	{
		AvailableCash=AvailableCash+1;
		win=win+1;
		if(AvailableCash>=Goal)
		{
			//System.out.println("Gambler reached the Goal");
			break;
		}
		
	}
	else
	{
		AvailableCash=AvailableCash-1;
		lose=lose+1;
		if(AvailableCash==0)
		{
			//System.out.println("Gambler lost all money");
			break;
		}
	}
	}
	
	double winp = (win/NumberOfChances*100);
	System.out.println("Number of  wins : "+(int) win);
	System.out.println("Number of  lose : "+(int) lose);

	System.out.println("precentage of win"+winp);
	System.out.println("precentage of lose"+(lose/NumberOfChances*100));

}
}
