package com.jda.functionalprograms;

import java.util.Scanner;
import com.jda.utility.Utility;
public class ReplaceString {
  public static void main(String args[])
  {
	  Utility utility = new Utility();
	  String Template = "Hello <<UserName>> ,How are you?";
       String UserName = utility.ScanString();
	  String output =utility.StringReplace(UserName,Template);
  }
}
