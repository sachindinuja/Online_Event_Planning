package com.contactus;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.CustomerDBUtil;

/**
 * Servlet implementation class ContactInsert
 */
@WebServlet("/ContactInsert")
public class ContactInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String subject = request.getParameter("subj");
		String userName = request.getParameter("uname");
		String password= request.getParameter("pass");
		
		boolean isTrue;
		
		isTrue = ContactDBUtil.insertcontactus(name, email, phone,subject,userName,password);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("contactsuccess.jsp");
			dis.forward(request, response);
		}else
		{
			RequestDispatcher dis2 =request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
	}

}
