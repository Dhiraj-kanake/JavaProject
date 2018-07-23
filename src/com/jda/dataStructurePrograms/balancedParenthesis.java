package com.jda.dataStructurePrograms;

import com.jda.utility.Utility;
import com.jda.utility.stack;

public class balancedParenthesis {
public static void main(String args[])
{
	Utility utility = new Utility();
	System.out.println("enter arithmetic expression :");
	String ArithmeticExpression=utility.ScanString();
	stack st =new stack(ArithmeticExpression.length());
	boolean flag=true;
	for(int i=0;i<ArithmeticExpression.length();i++)
	{
		if(ArithmeticExpression.charAt(i) == '(')
		{
			st.push(ArithmeticExpression.charAt(i));
		}
		else if(ArithmeticExpression.charAt(i) == ')')
		{
			char ch=st.pop();
			if(ch=='T');
			{
				//System.out.println("False");
				flag = false;
			break;
			}
		}
	}
	if(st.size() ==0 && flag ==true)
		System.out.println("True");
	else
		System.out.println("False");
}
}
