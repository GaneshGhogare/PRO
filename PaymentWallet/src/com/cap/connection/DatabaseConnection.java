package com.cap.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
	public static Connection getConnection() {
		String url;
		String username;
		String pwd;
		String driver;
		Connection con=null;
		try 
		{
			FileInputStream file=new FileInputStream("./prop/Jdbc.properties");
			Properties pro=new Properties();
			pro.load(file);
			driver=pro.getProperty("driver");
			pwd=pro.getProperty("pwd");
			url=pro.getProperty("url");
			username=pro.getProperty("username");


			Class.forName(driver);
			con=DriverManager.getConnection(url, username, pwd);
			
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println("class not found");
		}
		catch(SQLException e)
		{
			System.out.println("Not connected to db");
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String args[]) {

		getConnection();
	}





}
