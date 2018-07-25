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
	boolean flag=false;
	boolean flagone=false;
	for(int i=0;i<ArithmeticExpression.length();i++)
	{
		flag=false;
		if(ArithmeticExpression.charAt(i) == '(')
		{
			st.push(ArithmeticExpression.charAt(i));
		}
		else if(ArithmeticExpression.charAt(i) == ')')
		{
			char ch=st.pop();
			if(ch=='(');
			{
				//System.out.println("inside");
				flag = true;
			}
			if(ch=='T')
			{
				flagone=true;
			}
		}
	}
	if(st.size() ==0 && flag ==true && flagone==false)
		System.out.println("True");
	else
		System.out.println("False");
}
}
