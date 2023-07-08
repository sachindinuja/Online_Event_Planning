package com.contactus;

public class ContactUs {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String subject;
    private String userName;
    private String password;
    
    
    public ContactUs(int id, String name, String email, String phone, 
    		 String subject, String userName,String password) {
	this.id = id;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.subject = subject;
	this.userName=userName;
	this.password=password;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
    
    public String getsubject() {
    	return subject;
    }

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
    
    

}
