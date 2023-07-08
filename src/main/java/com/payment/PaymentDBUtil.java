package com.payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.contactus.ContactUs;

public class PaymentDBUtil {
	
	
	public static List<Payment> validate (String expDate, String cvc){
		
		ArrayList<Payment> paym = new ArrayList<>();
		
		//create db connection
		String url ="jdbc:mysql://localhost:3306/plan";
		String user ="root";
		String pass= "CHAmod12";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user,pass);
			Statement stmt = con.createStatement();
			String sql = "select * from payment where expDate = '"+expDate+"' and cvc = '"+cvc+"'";
			ResultSet rs = stmt.executeQuery(sql);
		
			if (rs.next()) {
				int paymentId = rs.getInt(1);
				String cardHoldersName = rs.getString(2);
				String paymentMethod = rs.getString(3);
				String cardNumber = rs.getString(4);
				String expDatep = rs.getString(5);
				String cvcp = rs.getString(6);
				
				Payment p = new Payment (paymentId, cardHoldersName,paymentMethod, cardNumber, expDatep, cvcp);
				paym.add(p);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return paym;
	}
	
	public static boolean insertpayment(String cardholdersName, String paymentMethod,String cardNumber, String expDate, String cvc) {
		
		boolean isSuccess = true;
		
		//create db connection
		String url ="jdbc:mysql://localhost:3306/plan";
		String user ="root";
		String pass= "CHAmod12";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url, user, pass);
			Statement stmt =con.createStatement();
			String sql = "insert into payment values(0,'"+cardholdersName+"','"+paymentMethod+"','"+cardNumber+"','"+expDate+"','"+cvc+"')";
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
		return  isSuccess;
	}
	
	
	public static boolean updatepayment(String paymentId,String cardHoldersName, 
			String paymentMethod,String cardNumber, String expDate, String cvc) {
		
		boolean isSuccess = true;
		
		
		
		//create db connection
		String url ="jdbc:mysql://localhost:3306/plan";
		String user ="root";
		String pass= "CHAmod12";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user, pass);
			Statement stmt=con.createStatement();
			String sql = "update payment set cardHoldersName='"+cardHoldersName+"',paymentMethod='"+paymentMethod+"',cardNumber='"+cardNumber+"',expDate='"+expDate+"',cvc='"+cvc+"'"
			+ "where paymentId='"+paymentId+"'";
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
	
	
	public static List<Payment> getPaymentDetails(String paymentid){
		
		int convertedID =  Integer.parseInt(paymentid);
		
		ArrayList<Payment> paym=new ArrayList<Payment>();
		
		
		//create db connection
		String url ="jdbc:mysql://localhost:3306/plan";
		String user ="root";
		String pass= "CHAmod12";
		
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user, pass);
			Statement stmt=con.createStatement();
			String sql="select * from payment where paymentId='"+convertedID+"'";
			ResultSet rs= stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int paymentId=rs.getInt(1);
				String cardHoldersName = rs.getString(2);
				String paymentMethod = rs.getString(3);
				String cardNumber = rs.getString(4);
				String expDate = rs.getString(5);
				String cvc = rs.getString(6);
			
				
				Payment pay=new Payment(paymentId,cardHoldersName,paymentMethod,cardNumber,expDate,cvc);
				paym.add(pay);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return paym;
				
				
	}
	
	public static boolean deletepayment(String paymentId) {
		
		boolean isSuccess = true;
		
		int converterId = Integer.parseInt(paymentId);
		
		
		//create db connection
		String url ="jdbc:mysql://localhost:3306/plan";
		String user ="root";
		String pass= "CHAmod12";
			
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user, pass);
			Statement stmt=con.createStatement();
			String sql = "delete from payment where paymentId='"+converterId+"'";
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
