package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDBUtil {
	
	public static List<Customer> validate(String userName, String password){
		
		ArrayList<Customer> cus =new ArrayList<>();
		
		//create database connection
		String url ="jdbc:mysql://localhost:3306/plan";
		String user ="root";
		String pass= "CHAmod12";
		
		//validate
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url, user, pass);
			Statement stmt =con.createStatement();
			String sql ="select * from customer where username='"+userName+"' and password='"+password+"'";
			ResultSet rs =stmt.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String name= rs.getString(2);
				String email= rs.getString(3);
				String phone= rs.getString(4);
				String userU= rs.getString(5);
				String passU= rs.getString(6);
				
				Customer c= new Customer(id,name,email,phone,userU,passU);
				cus.add(c);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		return cus;
	}
	
	public static boolean insertcustomer(String name, String email, String phone, String username, String password) {
		
		boolean isSuccess = false;
		
		//create db connection
		String url ="jdbc:mysql://localhost:3306/plan";
		String user ="root";
		String pass= "CHAmod12";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url, user, pass);
			Statement stmt =con.createStatement();
			String sql = "insert into customer values(0,'"+name+"','"+email+"','"+phone+"','"+username+"','"+password+"')";
			int rs =stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	
	public static boolean updatecustomer(String id, String name, String email, String phone, String username, String password) {
		
		boolean isSuccess = true;
		
		
		
		//create db connection
		String url ="jdbc:mysql://localhost:3306/plan";
		String user ="root";
		String pass= "CHAmod12";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user, pass);
			Statement stmt=con.createStatement();
			String sql = "update customer set name='"+name+"',email='"+email+"',phone='"+phone+"',username='"+username+
					"',password='"+password+"'"+ "where id='"+id+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}else
			{
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	
	public static List<Customer> getCustomerDetails(String Id){
		
		int convertedID =  Integer.parseInt(Id);
		
		ArrayList<Customer> cus=new ArrayList<>();
		
		
		//create db connection
		String url ="jdbc:mysql://localhost:3306/plan";
		String user ="root";
		String pass= "CHAmod12";
		
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user, pass);
			Statement stmt=con.createStatement();
			String sql="select * from customer where id='"+convertedID+"'";
			ResultSet rs= stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int id=rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String username = rs.getString(5);
				String password = rs.getString(6);
				
				Customer c=new Customer(id,name,email,phone,username,password);
				cus.add(c);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cus;
				
				
	}
	
	public static boolean deletecustomer(String id) {
		
		boolean isSuccess = true;
		
		int converterId = Integer.parseInt(id);
		
		
		//create db connection
		String url ="jdbc:mysql://localhost:3306/plan";
		String user ="root";
		String pass= "CHAmod12";
			
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user, pass);
			Statement stmt=con.createStatement();
			String sql = "delete from customer where id='"+converterId+"'";
			int r = stmt.executeUpdate(sql);
			
			if(r > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}
}
