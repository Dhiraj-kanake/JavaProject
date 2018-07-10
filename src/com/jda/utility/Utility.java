package com.jda.utility;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
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
	
	
	//  To take String as an input
	
public  String StringReplace (String UserName,String Template)  
{
	String result = Template.replace("<<UserName>>", UserName);
	return result;
}

//  To calculate prime factors of number 

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
			i=1;
		}
	}
	System.out.println(dividend);
}

//To find Harmonic Mean

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


//To find  power of N


public void PowerOfN(int Number)
{
	for(int i=0 ;i<Number;i++)
	{
		if(i<31)
		System.out.println( Math.pow(2, i));
	}
}

// To find leap year

public String FindLeapYear(int Year)
{
	if((Year%400==0)||(Year%4==0 && Year%100!=0))
		return "Yes";
	else
		return "No";
}

							/*  Gambler win or lose  */

public void FindWinLossOFGambler(double InitialAvailableCash,double Goal,double NumberOfChances)
{
	Random r = new Random();
	int Low = 1;        
	int High = 3;
	double win=0,lose=0;
	double AvailableCash = InitialAvailableCash;     // assigning 
	for(int i=0;i<NumberOfChances;i++)
	{
	//System.out.println("Random number is"+result);
AvailableCash = InitialAvailableCash;
		while(AvailableCash != Goal || AvailableCash !=0)
	{
			//System.out.println("1");
		int result = r.nextInt(High-Low) + Low;   //TO store  random number
	if(result==1)  //result=1 means gambler win
	{
		AvailableCash=AvailableCash+1;
	}
	else
	{
		AvailableCash=AvailableCash-1;
		
	}
	if(AvailableCash==Goal || AvailableCash ==0)
	{
		if(AvailableCash == Goal)
			win=win+1;
		else
			lose=lose+1;

		break;
	}
	}
	}
	
	double winp = (win/(win+lose)*100);
	System.out.println("Number of  wins : "+(int) win);
	System.out.println("Number of  lose : "+(int) lose);

	System.out.println("precentage of win  : "+winp);
	System.out.println("precentage of lose : "+(lose/(win+lose)*100));

}
public static double FindPercent(int number)    // Flip coin method to find percentage

{

		double HeadResult,TailResult;         // to store ratio of Head and  Tail

		int Head=0,Tail=0;         // variable to store number of heads and tails

		Random random = new Random();         //method to generate random number

		double arr[]=new double[number];        //array to store random numbers

		for(int i=0;i<number;i++)

		{

			arr[i]=random.nextDouble();

			//System.out.println("arr="+arr[i]);



		}

		

		for(int i=0;i<number;i++)

		{

			if(arr[i] < 0.5)

				Tail=Tail+1;

			else

				Head=Head+1;

		}

		

		//System.out.println(Head);

		//System.out.println(Tail);

			

		double d1=number;

		HeadResult=Head/d1;

		TailResult=Tail/d1;

				System.out.println("Head Percent : "+HeadResult*100);

		return TailResult;

}
public int[] enterArray(int NumberOfCoupons)
{
	int Coupons[] = new int[NumberOfCoupons]; 
	for(int i=0;i<NumberOfCoupons;i++)
		Coupons[i]=scanner.nextInt();
	return Coupons;
}

public void randomCouponNumbers(int Coupons[])
{
	List<Integer> GivenCouponList = new ArrayList();
	int MaxCouponNumber=Collections.max(GivenCouponList);           //highest coupon number
	int MinCouponNumber= Collections.min(GivenCouponList);
	Random RandomNumber = new Random();
	int Low =(int) MinCouponNumber;
	int High= (int) MaxCouponNumber;
	Set<Integer> TotalRandomNumber = new HashSet();
	int NextRandomNumber;
	while(true)
	{
		NextRandomNumber = RandomNumber.nextInt(High-Low)+Low;
		if(GivenCouponList.size()==0)
			break;
		TotalRandomNumber.add(NextRandomNumber);
		if(GivenCouponList.contains(NextRandomNumber))         //if given list contains random number then add it to new list
			GivenCouponList.remove(new Integer(NextRandomNumber));     //removing that element from the list
			
	}
	System.out.println("total random number : "+TotalRandomNumber.size());
	
}
public char[] formatString(String string)
{
	string= string.replaceAll("\\s", "");
	//System.out.println("after replace:"+string);
	string = string.toLowerCase();
	//System.out.println("after lowercase:"+string);

	char string1[] =  string.toCharArray();
//	System.out.println("after to char array:");
///for(int i=0;i<string1.length;i++)
//	System.out.print(+string1[i]);

			Arrays.sort(string1);
		//	System.out.println("after sort");
			//for(int i=0;i<string1.length;i++)
			//	System.out.print(+string1[i]);
	return string1;
}
}
