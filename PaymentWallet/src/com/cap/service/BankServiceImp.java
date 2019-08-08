package com.cap.service;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;

import com.cap.bean.Bank;
import com.cap.dao.BankDao;
import com.cap.dao.BankDaoImp;
import com.cap.exception.BankException;


public class BankServiceImp implements BankService{
	BankDao dao=new BankDaoImp();
	Bank bk=new Bank();
	Validation valid=new Validation();
	

	@Override
	public Bank addCustomer(Bank bk) throws BankException {
		if(!valid.validateCustname(bk.getName()))
		{
			try {
				throw new BankException("Invalid Name");
			}
			catch(BankException ex)
			{
				throw ex;
			}
		}
		else if(!valid.validateMobile(bk.getMobile_number()))
		{
			try {
				throw new BankException("Invalid Phone number");
			}
			catch(BankException ex) {
				throw ex;
			}
			catch(InputMismatchException eex) {
				System.out.println("Invalid number");
				
			}
		}
		else if(!valid.validatePassword(bk.getPasswrd()))
		{
			try {
				throw new BankException("Invalid Password");
			}
			catch(BankException ex) {
				throw ex;
			}
		}
		else {
			if(!valid.validateConfirmPass(bk.getPasswrd(),bk.getConfirmpass()))
			{
				try {
					throw new BankException(" Password dont match");
				}
				catch(BankException ex) {
					throw ex;
				}
			}
		}
		
		
		return dao.AddCustomer(bk);
	}

//	@Override
//	public List<Bank> getCustomer() throws BankException {
//		
//		return dao.GetCustomer();
//	}

//	@Override
//	public boolean deposit(double amount,int accno) throws BankException {
//	if(!valid.validateAccNo(bk.getAcc_no()))
//		{
//			try {
//				throw new BankException("Invalid Account number"+"(should be of 6 digits, numbers only)");
//			}
//			catch(BankException ex)
//			{
//				throw ex;
//			}
//			
//		}
//		
//		return dao.Deposit(amount, bk);
//	}

//	@Override
//	public Bank withdraw(double amount, Bank bk) throws BankException {
//		if(!valid.validateAccNo(bk.getAcc_no()))
//		{
//			try {
//				throw new BankException("Invalid Account number"+"(should be of 6 digits, numbers only)");
//			}
//			catch(BankException ex)
//			{
//				throw ex;
//			}
//			
//		}
//		
//		
//		return dao.Withdraw(amount, bk);
//	}

//	@Override
//	public Bank login(Bank bk, int accountno, String passwrd) throws BankException {
//		if(bk.getPasswrd().equals(passwrd))
//		{
//			return bk;
//		}
//		
//		return null;
//	}
//
//	@Override
//	public double showbal(Bank bk) throws BankException {
//		if(!valid.validateAccNo(bk.getAcc_no()))
//		{
//			try {
//				throw new BankException("Invalid Account number"+"(should be of 6 digits, numbers only)");
//			}
//			catch(BankException ex)
//			{
//				throw ex;
//			}
//			catch(NullPointerException e)
//			{
//				throw e;
//			}
//		}
//			else
//			{
//		
//		return dao.showBalance(bk);
//	}
//	}
//
//	@Override
//	public Bank GetCustomer(int acc_no) throws BankException {
//		if(!valid.validateAccNo(acc_no))
//		{
//			try {
//				throw new BankException("Invalid Account number"+"(should be of 6 digits, numbers only)");
//			}
//			catch(BankException ex)
//			{
//				throw ex;
//			}
//			
//		}
//			
//		
//		return dao.getCustomer(acc_no);
//	}
//
//	@Override
//	public boolean transFund(double amount, Bank frm, Bank to) throws BankException {
//		if(!valid.validateAccNo(to.getAcc_no()))
//		{
//			try {
//				throw new BankException("Invalid Account number"+"(should be of 6 digits, numbers only)");
//			}
//			catch(BankException ex)
//			{
//				throw ex;
//			}
//			
//		}
//		else if(!valid.validateAccNo(frm.getAcc_no()))
//		{
//			try {
//				throw new BankException("Invalid Account number"+"(should be of 6 digits, numbers only)");
//			}
//			catch(BankException ex)
//			{
//				throw ex;
//			}
//			
//		}
//		
//		return dao.transFund(amount, frm, to);
//	}
//
//	@Override
//	public List<String> printTransactions(Bank bk) throws BankException {
//		if(!valid.validateAccNo(bk.getAcc_no()))
//		{
//			try {
//				throw new BankException("Invalid Account number"+"(should be of 6 digits, numbers only)");
//			}
//			catch(BankException ex)
//			{
//				throw ex;
//			}
//			
//		}
//		
//		return dao.printTransactions(bk);
//	}

	@Override
	public boolean deposit(double amt, int accno) throws BankException, SQLException {
		if(!valid.validateAccNo(accno))
		{
			try {
				throw new BankException("Invalid Account number"+"(should be of 6 digits, numbers only)");
			}
			catch(BankException ex)
			{
				throw ex;
			}
			
		}
		
		return dao.Deposit(amt, accno);
		
	}

	@Override
	public boolean withdraw(double amt, int accno) throws BankException, SQLException {
		if(!valid.validateAccNo(accno))
		{
			try {
				throw new BankException("Invalid Account number"+"(should be of 6 digits, numbers only)");
			}
			catch(BankException ex)
			{
				throw ex;
			}
			
		}
		
		
		return dao.Withdraw(amt, accno);
		
	}

	@Override
	public double showbal(int accno) throws BankException, SQLException {
		if(!valid.validateAccNo(accno))
		{
			try {
				throw new BankException("Invalid Account number"+"(should be of 6 digits, numbers only)");
			}
			catch(BankException ex)
			{
				throw ex;
			}
			catch(NullPointerException e)
			{
				throw e;
			}
		}
			else
			{
		
		return dao.showBalance(accno);
	}	
	}

	@Override
	public boolean Fundtrans(double amt, int frm, int to) throws BankException, SQLException {
		if(!valid.validateAccNo(to))
		{
			try {
				throw new BankException("Invalid Account number"+"(should be of 6 digits, numbers only)");
			}
			catch(BankException ex)
			{
				throw ex;
			}
			
		}
		else if(!valid.validateAccNo(frm))
		{
			try {
				throw new BankException("Invalid Account number"+"(should be of 6 digits, numbers only)");
			}
			catch(BankException ex)
			{
				throw ex;
			}
			
		}
		
		return dao.fundtrans(amt, frm, to);
		
	}

	@Override
	public String printTransactions(int accno) throws BankException, SQLException {
		if(!valid.validateAccNo(accno))
			{
				try {
					throw new BankException("Invalid Account number"+"(should be of 6 digits, numbers only)");
				}
				catch(BankException ex)
				{
					throw ex;
				}
				
			}
			
			return dao.printTransactions(accno);
		
	}

	@Override
	public int lastacc() throws BankException, SQLException {
		return dao.lastacc();
	}

//	@Override
//	public Bank login(Bank bk, int accountno, String pswrd) throws BankException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	

}
