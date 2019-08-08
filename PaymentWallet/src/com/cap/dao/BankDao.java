package com.cap.dao;

import com.cap.bean.Bank;
import com.cap.exception.*;

import java.sql.SQLException;
import java.util.List;

public interface BankDao {
	
	
	public Bank AddCustomer(Bank bk) throws BankException;
//	public List<Bank> GetCustomer() throws BankException;
	
	public boolean Deposit(double amount,int accno) throws BankException, SQLException;
	public boolean Withdraw(double amount,int accno) throws BankException, SQLException;
	
//	public Bank getCustomer(int acc_no) throws BankException;
	public double showBalance(int accno) throws BankException, SQLException;
	
	
//	public List<String> printTransactions(Bank bk)throws BankException;
	boolean fundtrans(double amt, int frm, int to) throws BankException, SQLException;
	public String printTransactions(int accno) throws BankException, SQLException;
	public int lastacc() throws BankException, SQLException;
	public boolean isnotexist(int accno) throws BankException, SQLException;
	
	
}
