package com.cap.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	
	//validate name of customer 
	public boolean validateCustname(String custname) {
		Pattern pattern=Pattern.compile("[A-Za-z]{4,}");
		Matcher mat=pattern.matcher(custname);
		return mat.matches();
	}
	
	//validate user name 
	public boolean validateUName(String uname) {
		Pattern pattern=Pattern.compile("[A-Za-z0-9]{2,12}");
		Matcher mat=pattern.matcher(uname);
		return mat.matches();
		
	}
	
	//validate password
	public boolean validatePassword(String password)
	{
		Pattern pattern=Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}");
		Matcher mat=pattern.matcher(password);
		
		return mat.matches();
		
	}
	
	//validate whether password and retyped password is same
	public boolean validateConfirmPass(String pwd1,String pwd2) {
		if(pwd1.equals(pwd2))
		{
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	//validate address of customer
	public boolean validateAddress(String address) {
		Pattern pattern=Pattern.compile("[A-Za-z0-9](2,}");
		Matcher mat=pattern.matcher(address);
		return mat.matches();
		
	}

	
    //validate mobile number(10 is maxmium size of phone numbers) 
	public boolean validateMobile(long mobile_no) {
		String str=String.valueOf(mobile_no);
		Pattern pattern=Pattern.compile("[0-9]{10}");
		Matcher mat=pattern.matcher(str);
		
		
		return mat.matches();
	}
	
    //validate account number
	public boolean validateAccNo(int acc_no) {
		Pattern pattern=Pattern.compile("[0-9]{6}");
		Matcher m=pattern.matcher(Integer.toString(acc_no));
		return m.matches();
	}
	
	//validate account balance
	public boolean validateAccBal(Double account_bal) {
		String str2=Double.toString(account_bal);
		Pattern pattern=Pattern.compile("[0-9]{2,}");
		Matcher mat=pattern.matcher(str2);
		
		
		return mat.matches();
		
	}
	
	

}
