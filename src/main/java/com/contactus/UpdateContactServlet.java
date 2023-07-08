package com.contactus;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/UpdateContactServlet")
public class UpdateContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("contid");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String subject = request.getParameter("subj");
		String username = request.getParameter("uname");
		String password= request.getParameter("pass");
		
		boolean isTrue;
		
		//upadatecontact method eken asign wana values pass karanawa
		isTrue = ContactDBUtil.updatecontactus(id, name, email, phone, subject,username, password);
		
		if(isTrue == true) {
			
			List<ContactUs> contDetails = ContactDBUtil.getContactDetails(id);
			request.setAttribute("contDetails", contDetails);

			
			RequestDispatcher dis = request.getRequestDispatcher("contactus.jsp");
			dis.forward(request, response);
		}
		else {
			List<ContactUs> contDetails = ContactDBUtil.getContactDetails(id);
			request.setAttribute("contDetails", contDetails);

			RequestDispatcher dis = request.getRequestDispatcher("contactus.jsp");
			dis.forward(request, response);
		}
		
	}

}
