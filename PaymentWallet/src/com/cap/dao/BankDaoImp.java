package com.cap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import com.cap.bean.Bank;
import com.cap.connection.DatabaseConnection;
import com.cap.exception.BankException;


public class BankDaoImp  implements BankDao{
	Bank bk=new Bank();
	private static Map<Integer,Bank> banks=new HashMap<>();
	static DatabaseConnection db=new DatabaseConnection();
	static Connection conn=db.getConnection();
	
	public void SaveTransaction(int accno,String history,double amount)
	{

		try {
			PreparedStatement ps=conn.prepareStatement("insert into transaction values(?,?,?,?,?)");
			ps.setInt(1, Math.abs(new Random().nextInt()));
			ps.setDouble(2, amount);
			ps.setString(3, gettime());
			ps.setString(4,history);
			ps.setDouble(5,accno);
			int hist=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	
	
   //method to add customer
	@Override
	public Bank AddCustomer(Bank bk) throws BankException {
		try {
			Scanner sc=new Scanner(System.in);
			PreparedStatement ps=conn.prepareStatement("insert into bank22(Name,Mobile_number,Address,User_name,password,retype_password,acc_no)"
					+ "values(?,?,?,?,?,?,?)");
			ps.setString(1, bk.getName());
			ps.setDouble(2, bk.getMobile_number());
			ps.setString(3, bk.getAddress());
			ps.setString(4, bk.getUsername());
			ps.setString(5, bk.getPasswrd());
			ps.setString(6, bk.getConfirmpass());
			ps.setInt(7, bk.getAcc_no());

			int rc=ps.executeUpdate();
			System.out.println(rc+" record inserted successfully");
			System.out.println("Customer added");
			System.out.println("Account number is "+bk.getAcc_no());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return bk;
	}
     
	
//	@Override
//	public List<Bank> GetCustomer() throws BankException {
//		Collection<Bank>list=banks.values();
//		List<Bank>banklist=new ArrayList<>(list);
//		return banklist;
//	}

	@Override
	public boolean Deposit(double amount, int accno) throws BankException, SQLException {
		double current_bal=showBalance(accno);
		double new_bal=current_bal+amount;
		PreparedStatement ps=conn.prepareStatement("update bank22 set balance=? where acc_no=?");
		ps.setDouble(1, new_bal);
		ps.setInt(2,accno);
		int res=ps.executeUpdate();
		SaveTransaction(accno,"Deposit", amount);
		return true;
	}

	@Override
	public boolean Withdraw(double amount, int accno) throws BankException, SQLException {
		double current_bal=showBalance(accno);
		double new_bal=current_bal-amount;
		if(current_bal>amount) 
		{
			PreparedStatement ps=conn.prepareStatement("update bank22 set balance=? where acc_no=?");
			ps.setDouble(1, new_bal);
			ps.setInt(2,accno);
			ps.executeUpdate();
			SaveTransaction(accno,"Withdraw", amount);
			return true;
		}
		else 
		{
			throw new BankException("Not Enough Amount");
		}
	}

//	public Bank getCustomer(int acc_no) throws BankException {
//	
//		return banks.get(acc_no);
//	}

	@Override
	public double showBalance(int accno) throws BankException, SQLException {

		PreparedStatement show=conn.prepareStatement("select balance from bank22 where acc_no=?");
		Bank bk=new Bank();
		double bal=0;
		show.setInt(1, accno);
		ResultSet rs=show.executeQuery();
		if(rs.next()) {

			bal=rs.getInt("balance");
			return bal;
		}
		else
		{
			throw new BankException("Invalid Account");
		}
	}

	@Override
	public boolean fundtrans(double amt, int frm , int to) throws BankException, SQLException {
		if(Withdraw(amt, frm) && Deposit(amt, to))
		{


			return true;
		}
		return false;


	}
		
	public String gettime() 
	{
		DateFormat df=new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj=new Date();
		Calendar cal=Calendar.getInstance();
		return df.format(cal.getTime());
	}
	
	@Override
	public String printTransactions(int accno) throws BankException, SQLException {
		String Transaction_done="";
		if(isnotexist(accno))
		{
			PreparedStatement ps=conn.prepareStatement("Select * from transaction where ACC_NO=?");
			ps.setInt(1, accno);
			ResultSet rs=ps.executeQuery();

			System.out.println("Transaction_Id \t Date \t Time \t     Transaction_Type  \tAmount");
			while(rs.next())
			{

				Transaction_done=Transaction_done+rs.getInt("TRANSACTION_ID") + " \t";
				Transaction_done=Transaction_done+rs.getString("DATE_AND_TIME") + " \t";
				Transaction_done=Transaction_done+rs.getString("TRANCATION_TYPE") + " \t";
				Transaction_done=Transaction_done+rs.getDouble("Amount") + " \n";

			}
			return Transaction_done;
		}
		else 
		{
			throw new BankException("Invalid Account");

		}
	}
		
		@Override
		public int lastacc() throws BankException, SQLException {
			int acc_num=987654;
			Statement st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql="select acc_no from bank22";
			ResultSet rs=st.executeQuery(sql);

			while(rs.next()) {}
			if(rs.isAfterLast())
			{
				rs.previous();
				acc_num=rs.getInt(1);
			}

			return acc_num;
		}


		@Override
		public boolean isnotexist(int accno) throws BankException, SQLException {
			PreparedStatement cust=conn.prepareStatement("Select * from bank22 where acc_no=?");
			cust.setInt(1, accno);
			ResultSet rs=cust.executeQuery();


			if(rs.next())
			{
				return true;
			}
			return false;

		}


	
//
//	@Override
//	public List<String> printTransactions(Bank bk) throws BankException {
//		
//		return bk.getTransactions();
//	}

	


}
