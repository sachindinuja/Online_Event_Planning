package com.contactus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.customer.Customer;

public class ContactDBUtil {
	
	
	public static boolean/*List<ContactUs>*/ validate(String username, String password) {
		
		//ArrayList<ContactUs> cont=new ArrayList<>();
		
		//create db connection
		String url ="jdbc:mysql://localhost:3306/plan";
		String user ="root";
		String pass= "CHAmod12";
		
		boolean isSuccess = true;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user,pass);
			Statement stmt = con.createStatement();
			String sql = "select * from contact where userName='"+username+"' and password='"+password+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			/*if(rs.next()) {
				int id = rs.getInt(1);
				String name= rs.getString(2);
				String email= rs.getString(3);
				String phone= rs.getString(4);
				String subject= rs.getString(5);
				String userU= rs.getString(6);
				String passU= rs.getString(7);
				
				ContactUs c= new ContactUs(id,name,email,phone,subject,userU,passU);
				cont.add(c);
				
			}*/
			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
		//return cont;
		return isSuccess;
	}
	
	
	public static List<ContactUs> getcontactus(String userName) {
		
		ArrayList<ContactUs> contactus = new ArrayList<ContactUs>();
		
		
		//create db connection
		String url ="jdbc:mysql://localhost:3306/plan";
		String user ="root";
		String pass= "CHAmod12";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,user,pass);
			Statement stmt = con.createStatement();
			String sql = "select * from contact where userName='"+userName+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String subject = rs.getString(5);
				String username=rs.getString(6);
				String password=rs.getString(7);
			
				
				ContactUs cont = new ContactUs(id,name,email,phone,subject,username,password);
				contactus.add(cont);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return contactus;	
	}
	
	public static boolean insertcontactus(String name, String email, String phone, String subject,String userName,String password) {
		
		boolean isSuccess = false;
		
		//create db connection
		String url ="jdbc:mysql://localhost:3306/plan";
		String user ="root";
		String pass= "CHAmod12";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url, user, pass);
			Statement stmt =con.createStatement();
			String sql = "insert into contact values(0,'"+name+"','"+email+"','"+phone+"','"+subject+"','"+userName+"','"+password+"')";
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
	
	public static boolean updatecontactus(String id,String name, String email, String phone, String subject,String username,String password) {
		
		boolean isSuccess = true;
		
		
		
		//create db connection
		String url ="jdbc:mysql://localhost:3306/plan";
		String user ="root";
		String pass= "CHAmod12";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user, pass);
			Statement stmt=con.createStatement();
			String sql = "update contact set name='"+name+"',email='"+email+"',phone='"+phone+"',subject='"+subject+"',userName='"+username+"',password='"+password+"'"+ "where id='"+id+"'";
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
	
	
	
	public static List<ContactUs> getContactDetails(String Id){
		
		int convertedID =  Integer.parseInt(Id);
		
		ArrayList<ContactUs> cont=new ArrayList<ContactUs>();
		
		
		//create db connection
		String url ="jdbc:mysql://localhost:3306/plan";
		String user ="root";
		String pass= "CHAmod12";
		
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user, pass);
			Statement stmt=con.createStatement();
			String sql="select * from contact where id='"+convertedID+"'";
			ResultSet rs= stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int id=rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String subject = rs.getString(5);
				String username = rs.getString(6);
				String password = rs.getString(7);
				
				ContactUs cs=new ContactUs(id,name,email,phone,subject,username,password);
				cont.add(cs);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cont;
				
				
	}
	
	public static boolean deletecontact(String id) {
		
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
			String sql = "delete from contact where id='"+converterId+"'";
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
