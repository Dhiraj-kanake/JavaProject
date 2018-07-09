package com.jda.functionalprograms;

import com.jda.utility.Utility;
public class twoDArray {
	public static void main(String args[])
	{
		Utility utility = new Utility();
		int NumberOfRows,NumberOfColumns;
		System.out.println("Enter number of rows : ");
		NumberOfRows = utility.InputInteger();
		System.out.println("Enter number of columns");
		NumberOfColumns = utility.InputInteger();
		System.out.println("Enter Two Dimensional Array");
		String TwoDArray[][]= new String[NumberOfRows][NumberOfColumns];
		 for(int RowNumber=0;RowNumber<NumberOfRows;RowNumber++)
		 {
			 for(int ColumnNumber =0;ColumnNumber<NumberOfColumns;ColumnNumber ++)
			 {
				 TwoDArray[RowNumber][ColumnNumber] = utility.InputString();
			 }
		 }
		 utility.printWriterMethod(TwoDArray,NumberOfRows,NumberOfColumns);
	}

}
