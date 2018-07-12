package com.jda.utility;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;
import java.io.PrintWriter;
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

public void randomCouponNumbers(int Coupons[],int NumberOfCoupons)
{
	ArrayList<Integer> GivenCouponList = new ArrayList<>();
	for(int i=0;i<NumberOfCoupons;i++)
	{
		GivenCouponList.add(Coupons[i]);
	}
	int MaxCouponNumber=Collections.max(GivenCouponList);           //highest coupon number
	int MinCouponNumber= Collections.min(GivenCouponList);
	Random RandomNumber = new Random();
	int Low =(int) MinCouponNumber;
	int High= (int) MaxCouponNumber+1;
	Set<Integer> TotalRandomNumber = new HashSet<Integer>();
	int NextRandomNumber;
	while(true)
	{
		NextRandomNumber = RandomNumber.nextInt(High-Low)+Low;
		System.out.println("size  = "+GivenCouponList.size());
		System.out.println("random number :"+NextRandomNumber);
		if(GivenCouponList.size()==0)
			break;
		TotalRandomNumber.add(NextRandomNumber);
		if(GivenCouponList.contains(NextRandomNumber))         //if given list contains random number then add it to new list
			GivenCouponList.remove(new Integer(NextRandomNumber));     //removing that element from the list
			
	}
	System.out.println("total random number : "+TotalRandomNumber.size());
	
}

public void generateRandomCouponNumbers(int NumberOfCoupons)
{
	ArrayList<Integer> GivenCouponList = new ArrayList<>();
	for(int i=1;i<=NumberOfCoupons;i++)
	{
		GivenCouponList.add(i);
	}
	int MaxCouponNumber=Collections.max(GivenCouponList);           //highest coupon number
	int MinCouponNumber= Collections.min(GivenCouponList);
	Random RandomNumber = new Random();
	int Low =(int) MinCouponNumber;
	int High= (int) MaxCouponNumber+1;
	List<Integer> TotalRandomNumber = new ArrayList<Integer>();
	int NextRandomNumber;
	int array[]=new int[NumberOfCoupons];
	int count=0;
	while(true)
	{
		if(GivenCouponList.size()==0)
			break;
		NextRandomNumber = RandomNumber.nextInt(High-Low)+Low;
		//System.out.println("size  = "+GivenCouponList.size());
		//System.out.println("random number :"+NextRandomNumber);
		
		TotalRandomNumber.add(NextRandomNumber);
		if(GivenCouponList.contains(NextRandomNumber))         //if given list contains random number then add it to new list
		{
			array[count++]=NextRandomNumber;
			GivenCouponList.remove(new Integer(NextRandomNumber));     //removing that element from the list
		}
	}
	System.out.println("total random number : "+TotalRandomNumber.size());
	for(int i=0;i<NumberOfCoupons;i++)
	System.out.println(array[i]);
}
public String InputString()
{
	String s = scanner.next();
	//char c= s.charAt(0);
	return s;
}
public void printWriterMethod(String TwoDArray[][], int NumberOfRows,int NumberOfColumns)
{
	PrintWriter writer = new PrintWriter(System.out);
	for(int RowNumber=0;RowNumber<NumberOfRows;RowNumber++)
	{
		for(int ColumnNumber = 0;ColumnNumber<NumberOfColumns;ColumnNumber++)
		{
			//if(Character.isDigit(TwoDArray[RowNumber][ColumnNumber].charAt(0)))
			writer.print( TwoDArray[RowNumber][ColumnNumber]);
			//else
			//	writer.print(TwoDArray[RowNumber][ColumnNumber]);
			writer.write("  ");

		}
		writer.write("\n");
		
	}
	writer.flush();
	writer.close();
}
public void findTripletSum(int Array[])
{
	boolean flag=false;
	for(int i=0;i<Array.length-1;i++)
	{
		List<Integer> ArrayOfInteger = new ArrayList<Integer>();
		for(int j=i+1;j<Array.length;j++)
		{
			int x = -(Array[i] + Array[j]);
			if(ArrayOfInteger.contains(x))
			{
				System.out.println(x+" "+Array[i]+" "+Array[j]);
				flag=true;
			}
			else
				ArrayOfInteger.add(Array[j]);
		}
		
	}
	if(flag==false)
		System.out.println("triplets are not available");
}
public void euclideanDistance(int x,int y)
{
	System.out.println("Euclidean Distance = " + Math.pow((x*x + y*y),0.5));
}
public double findDelta(int a,int b,int c)
{
	double result = b*b - 4*a*c;
	//System.out.println("result"+result);
	return result;
}
public void findRoot(double Delta,int a,int b)
{
	double sqrt=Math.pow(Delta, 1/2);
			double root_1= (-b+sqrt)/2*a;
			double root_2=(-b-sqrt)/2*a;
	System.out.println("Root_1 : "+root_1);
	System.out.println("Root_2 : "+root_2);

}
public double startStopwatch()
{
	double TimingOfStopwatch = System.currentTimeMillis();
	return TimingOfStopwatch;
}
public double endStopwatch()
{
	double EndTime = System.currentTimeMillis();
	return EndTime;
}
public void iterativeMethodForPermutaion(String string)
{
	String ArrayOfString[] = string.split("");
	int lengthOfString = string.length();
	for(int i=0;i<lengthOfString;i++)
	{
		
	}
}
public double findWindChill(double args[])
{
	double t=args[0];
	double v=args[1];
	double windchill = 35.74 +0.6215 * t + (0.4275 * t - 35.75) * Math.pow(v, 0.16);	
	return windchill;
}
}









