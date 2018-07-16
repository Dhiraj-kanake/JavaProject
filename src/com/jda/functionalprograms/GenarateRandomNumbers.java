/*Problem statement : generate N coupon numbers 
 * author : Dhiraj Kanake
 * Date : 6-jul-2018
 * */

package com.jda.functionalprograms;

import com.jda.utility.Utility;

public class GenarateRandomNumbers{
public static void main(String args[])
{
	Utility utility = new Utility();
	System.out.println("Enter Number of Coupons : ");
	int NumberOfCoupons = utility.InputInteger();
	//System.out.println("Enter Coupons : ");
	//int CouponNumbers []= utility.enterArray(NumberOfCoupons);
	//System.out.println("out"+CouponNumbers[1]);
	
	utility.generateRandomCouponNumbers(NumberOfCoupons);
	
}
}
