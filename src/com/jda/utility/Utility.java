package com.jda.utility;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.util.Arrays;
import java.util.Collections;

import java.io.PrintWriter;
import java.util.HashMap;

import java.util.Random;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	 return scanner.nextLine();
	}
	public String ScanStringForLoop()
	{
	 return scanner.next();
	}
	public int InputInteger()
	{
		return scanner.nextInt();
	}
	public double InputDouble()
	{
		return scanner.nextDouble();
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
public ArrayList<Integer> findRangeOfPrimeNumbers(int rangeLow,int rangeHigh)
{
	boolean flag=false;
	ArrayList<Integer> primeNumberList = new ArrayList<>();
		for(int i=rangeLow;i<=rangeHigh;i++)  //number to check whether it is prime or not
		{
			flag = false;
			for(int j=2;j<=i/2;j++)   //trying to divide that number with j==2 to j==number/2
			{
				if(i%j==0)
					flag=true;
			}
			if(flag ==false && i>=2)
				primeNumberList.add(i);
		}
		//System.out.println(primeNumberList);
		return (primeNumberList);
}
public ArrayList<Integer> findReverseOfNumbers(ArrayList<Integer> ListOfPrimeNumbers )
{
	ArrayList<Integer> ReverseList = new ArrayList<>();
	for(Integer number : ListOfPrimeNumbers)
	{
		int x,a=0;
		while(number>0)    //logic to swap numbers
		{
			x=number%10;
			a=a*10+x;
			number=number/10;
		}
		ReverseList.add(a);
	}
	return ReverseList;
}
public ArrayList<String> findAnagram(ArrayList<Integer> ListOfPrimeNumbers)
{
	ArrayList<String> TempList = new ArrayList<>();
	for(int i=0;i<ListOfPrimeNumbers.size();i++)          //converting one element into array
	{
		int Number = ListOfPrimeNumbers.get(i);        //getting each element
		int arr[]=new int[Integer.toString(Number).length()];     //getting array length
		int index=0;             // index of array to store each element
		while(Number>0)
		{
			arr[index++]=Number%10;
			Number=Number/10;
		}
		//System.out.print("before"+Arrays.toString(arr));
		Arrays.sort(arr);
		//System.out.print(Arrays.toString(arr));
	/*	int ArrLength=arr.length;
		int Element=0;
		for(int ArrIndex=0;ArrIndex<ArrLength;ArrIndex++)
		{
			Element=Element * 10 +arr[ArrIndex];
		}
		TempList.add(Element);
		*/
		TempList.add(Arrays.toString(arr));
	}
	for(int IndexOfElementToCheck=0;IndexOfElementToCheck<TempList.size()-1;IndexOfElementToCheck++)
	{
		Set<Integer> IndexOfDuplicateElements = new HashSet<>();
		IndexOfDuplicateElements.add(IndexOfElementToCheck);
		boolean flag=false;
		for(int NextIndex=IndexOfElementToCheck+1;NextIndex<TempList.size();NextIndex++)
		{
			if(TempList.get(NextIndex).equals(TempList.get(IndexOfElementToCheck)))
			{
				flag=true;
				IndexOfDuplicateElements.add(NextIndex);
			}
		}
		if(flag==true)
		{
			for(Integer Index : IndexOfDuplicateElements)
			{
				System.out.print(" "+ListOfPrimeNumbers.get(Index));
			}
			System.out.println("     ");
		}
		
	}
	return TempList;
}
public static <T> int compare(T t1,T t2)
{
	if(t1.getClass().toString().endsWith("Integer"))
	{
		Integer i1=(Integer) t1;
		Integer i2 = (Integer) t2;
		if(i1>i2)
			return 1;
		else if(i1<i2)
			return -1;
		else
			return 0;
	}
	else
	{
		String string1= (String) t1;
		String string2= (String) t2;
		if(string1.compareTo(string2)>0)
			return 1;
		else if(string1.compareTo(string2)<0)
			return -1;
		else
			return 0;
	}
}
public static <T> int binarySearch(T[] array,T Number,int start,int end)
{	
   if(start<end)
	{
   	int mid = (start+end)/2;
   	if(compare(array[mid],Number)==0)
   	{
   			return mid;
   	}
		if(compare(array[mid],Number) > 0){
		return binarySearch(array,Number,start,mid);
		}
		else{
		return binarySearch(array,Number,mid+1,end);
		}
	}
   return -1;
}

public static<T> T[] insertionSort(T arr[])
{
	for(int i=1;i<arr.length;i++)
	{
		T key=arr[i];
		int j=i-1;
		while(j>=0 && compare(arr[j],key) >0)
		{
			arr[j+1]=arr[j];
			j=j-1;
		}
		arr[j+1]=key;
		
	}
	return arr;
}

public static<T> T[] bubbleSort(T arr[])
{
	for(int i=0;i<arr.length-1;i++)
	{
		for(int j=i+1;j<arr.length;j++)
		{
			if(compare(arr[j],arr[i])>0)
			{
				T temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		
	}
	return arr;
}
public long stopwatch()
{
	long startTime=System.nanoTime();
	return startTime;
}
public long endwatch(long startTime)
{
	long endTime=System.nanoTime();
	return endTime-startTime;
}
public void searchNumber(double start,double end)
{
	if(start<end)
	{

   	double mid = (start+end)/2;
   	if((int)end-(int)start==1 ||(int) end-(int)start==0)
   	{
   			System.out.println("is your number is "+ (int)start+"?");
   			String answer=ScanString();
   			if(answer.equals("y"))
   			{
   				
   			}
   			else
   			{
      			System.out.println("so your number is "+ (int)end+" ");
      			//String answer2=ScanString();
   			}
   	}
   	else
   	{
		System.out.println("is your number is between "+(int)start +" and " +(int)mid +"  (y/n) ");
		String answer=ScanString();
		if(answer.equals("y")){
		searchNumber(start,mid);
		}
		else{
		 searchNumber(mid+1,end);
		}
	}
	}

}
public String[] fileSetup(String filename) throws IOException
{
	
	String line=null;
	String string = new String();
	try{
	FileReader filereader = new FileReader(filename);
	BufferedReader bufferreader = new BufferedReader(filereader);
	while((line=bufferreader.readLine())!=null)
		string=string+line;
	}
	catch(FileNotFoundException e)
	{
		 System.out.println("fine not found");
	}
	String stringarray[]=string.split("\\s");
	return stringarray;
}
public Integer[] arrayOfStringToInteger(String array[])
{
	Integer ArrayOfInt[]= new Integer[array.length];
	for(int i=0;i<array.length;i++)
	{
		ArrayOfInt[i]=Integer.valueOf(array[i]);
	}
	return ArrayOfInt;
}
public static  void findDayOfWeek()
{
	Utility utility=new Utility();
	System.out.println("Enter day : ");
	int day=utility.InputInteger();
	System.out.println("enter month : ");
	int month=utility.InputInteger();
	System.out.println("enter year : ");
	int year = utility.InputInteger();
	HashMap<Integer,String> map=new HashMap<>();
	map.put(0, "Sunday");
	map.put(1, "Monday");
	map.put(2, "Tuesday");
	map.put(3, "Wednesday");
	map.put(4, "Thursday");
	map.put(5, "Friday");
	map.put(6, "Saturday");

	year = year-(14-month)/12;
	int x=year +year/4-year/100+year/400;
	month = month+12 * ((14-month)/12)-2;
	day=(day + x + 31 * month /12) % 7;

System.out.println(map.get(day));
}
public void CToF(int temp)
{
	double value = (temp * 9/5)+32;
	System.out.println(value);
}
public void FToC(int temp)
{
	double value=(temp-32)*5/9;
	System.out.println(value);
}
public void findPayoff()
{
	System.out.println("enter number of Years : ");
	double year=InputInteger();
	System.out.println("enter  principle :");
	double principal=InputInteger();
	System.out.println("enter  interest : ");
	double interest = InputDouble();
	double n=12 * year;
	double r=interest/(12 * 100);
	double Payment =( principal*r)/(1-Math.pow((1+r), -n));
	System.out.println(Payment);
}

//programs from local system

public static void findSquareRoot(double Number)

{

	//newtons method

	double T=Number;  //initialising T

	while(Math.abs(T-(Number/T)) >(Math.pow(10,-15)*T) )

	{

		T=((Number/T)+T)/2;

	}

	System.out.println(T);

}

public static String convertToBinary(int Number)

{

	String string="";

	while(Number/2!=0)

	{

		string=Number%2 + string;

		Number=Number/2;

	}

	string=Number%2 + string;

	//System.out.println("length of string : "+string.length());

	int length = string.length();

	if(length%8 !=0)

	{

		for(int i=0;i<string.length()%4;i++)

			string = "0"+string;

	}

	//System.out.println("binary : "+string);

	//int number=Integer.parseInt(string);

	//System.out.println("number : "+number);

	return string;



}

public void afterSwap(String BinaryNumber)

{

	System.out.println("Before swap : "+BinaryNumber);

	

	for(int i=0;i<4;i++)

	{

		BinaryNumber = BinaryNumber + BinaryNumber.charAt(i);

	}

	StringBuilder sb=new StringBuilder(BinaryNumber);

	sb.delete(0, 4);

	System.out.println("After swap : "+sb);

	int Number=0;

	String AfterSwap=sb.toString();

	int k=AfterSwap.length()-1;

	for(int i=0;i<AfterSwap.length();i++)

	{

		int v=Integer.parseInt(String.valueOf(AfterSwap.charAt(i)));

	  Number = (int) (Number + (v * Math.pow(2, k--)));

	  //System.out.println("value : "+v);

		//System.out.println("Number : "+Number);

	}

	System.out.println("decimal Number : "+Number);

	double value=Math.log(Number)/Math.log(2);

	double floorvalue=Math.floor(value);

	System.out.println("value : "+value+" floor : "+floorvalue);

	if(value==floorvalue)

		System.out.println("in power of 2");

	else

		System.out.println("not in power of 2");

}

public void returnChange(int Money)

{

	int array[]= {1000,500,100,50,10,5,2,1};

	int index=0;

	int count[] =new int[8];

	while(true)

	{

		if(Money ==0)

			break;

		if(Money >= array[index])

		{

			count[index]=Money/array[index];

			Money=Money%array[index];

		}

		else

			index++;

			

	}

	//System.out.println("money = "+ Arrays.toString(count));

	int TotalNumberOfNotes=0;

	for(int i=0;i<count.length;i++)

	{

		if(count[i]*1!=0)

		{

			System.out.println(count[i] +" X "+array[i] +" rupee note");

		}

		TotalNumberOfNotes=TotalNumberOfNotes+count[i];

	}

	System.out.print("Total Number Of Notes : "+TotalNumberOfNotes);

}

public String[] merge(String Array[],int low,int mid,int high)

{

	String arrayOne[]=new String[mid-low+1];

	String arrayTwo[]=new String[high-mid];

	for(int i=0;i<arrayOne.length;i++)

		arrayOne[i]=Array[i+low];

	for(int j=0;j<arrayTwo.length;j++)

		arrayTwo[j]=Array[j+mid+1];

	int lengthOfArrayOne=arrayTwo.length;

	int lengthOfArrayTwo=arrayTwo.length;

	int i=0,j=0,k=low;

	while(i<lengthOfArrayOne && j<lengthOfArrayTwo)

	{

		if(arrayOne[i].compareTo(arrayTwo[j])<0)

		{

			Array[k]=arrayOne[i];

			i++;

		}

		else

		{

			Array[k]=arrayTwo[j];

			j++;

		}

		k++;

	}

	while(i<lengthOfArrayOne)

	{

		Array[k]=arrayOne[i];

		i++;

		k++;

	}

	while(j<lengthOfArrayTwo)

	{

		Array[k]=arrayTwo[j];

		j++;

		k++;

	}

	

	return Array;

}



public String[] mergeSortForString(String ArrayOfString[],int l,int r)

{

	if(l<r)

	{

	int mid= l +(r-l)/2;

	mergeSortForString(ArrayOfString,l,mid);

	mergeSortForString(ArrayOfString,mid+1,r);

	ArrayOfString=merge(ArrayOfString,l,mid,r);

	//System.out.println("Sorted array : "+Arrays.toString(array));

	}

	return ArrayOfString;

}






}









