package com.cap.bean;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	private String username,passwrd,name,confirmpass,address;
	private long mobile_number;
	private double amount;
	private static int acc_no=987632;
	private List<String> transactions;
	
public Bank() {
		
		transactions=new ArrayList<String>();
		
	}

	//getter setter 
	public List<String> getTransactions(){
		return transactions;
		
	}
	
	public static void setAcc_no(int acc_no) {
		Bank.acc_no=acc_no;
	}
	
	
	
	public void setTransaction(String transaction) {
		this.transactions.add(transaction);
	}
	
	

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPasswrd() {
		return passwrd;
	}


	public void setPasswrd(String passwrd) {
		this.passwrd = passwrd;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getConfirmpass() {
		return confirmpass;
	}


	public void setConfirmpass(String confirmpass) {
		this.confirmpass = confirmpass;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public long getMobile_number() {
		return mobile_number;
	}


	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public static int getAcc_no() {
		return acc_no;
	}

	public static void setAcc_no() {
		Bank.acc_no=acc_no+1;
	}
	@Override
public String toString() {
		return "Bank[username="+username+",passwrd="+passwrd+",name="+name+",ConfirmPassword="+confirmpass+",address="+address+",mobile_number="+mobile_number+",amount="+amount+",Account_number="+acc_no+"]";
		
	}
}

