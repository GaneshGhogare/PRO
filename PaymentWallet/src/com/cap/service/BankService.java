package com.cap.service;

import java.sql.SQLException;
import java.util.List;

import com.cap.bean.Bank;
import com.cap.exception.BankException;



public interface BankService {
	public Bank addCustomer(Bank bk) throws BankException;

	public boolean deposit(double amt, int accno) throws BankException, SQLException;
	public boolean withdraw(double amt,int accno) throws BankException, SQLException;

//	public Bank login(Bank bk,int accountno, String pswrd) throws BankException;

	public double showbal(int accno) throws BankException, SQLException;

	public boolean Fundtrans(double amt, int frm, int to)throws BankException, SQLException;
	public String printTransactions(int accno) throws BankException, SQLException;

	public int lastacc() throws BankException, SQLException;
}
