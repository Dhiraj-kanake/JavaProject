package com.jda.utility;

public class book {
Utility utility = new Utility();
public class entry{
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private Long pincode;
	private String state;
	private Long mobileNumber;
	public entry()
	{
		firstName =""; lastName=""; address = ""; city = ""; pincode=null;	state="";	mobileNumber=null;
	}
	public entry(String name,String sirname, String address,String city,Long pincode,String state,Long number)
	{
		this.firstName=name;
		this.lastName=sirname;
		this.address=address;
		this.city=city;
		this.pincode=pincode;
		this.state=state;
		this.mobileNumber=number;
	}
	public void printEntry()
	{
		System.out.println("first name :"+firstName);
		System.out.println(""+lastName);
		System.out.println(""+address);
		System.out.println(""+city);
		System.out.println(""+pincode);
		System.out.println(""+state);
		System.out.println(""+mobileNumber);
	}
}
entry details[];




}
