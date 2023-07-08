package com.contactus;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DeleteContactServlet
 */
@WebServlet("/DeleteContactServlet")
public class DeleteContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("contid");
		
		boolean isTrue;
		
		isTrue = ContactDBUtil.deletecontact(id);
		
		if(isTrue == true) {
			RequestDispatcher dis =request.getRequestDispatcher("contactusinsert.jsp");
			dis.forward(request, response);
		}
		else {
			
			List<ContactUs> contDetails = ContactDBUtil.getContactDetails(id);
			request.setAttribute("contDetails", contDetails);
			
			RequestDispatcher dis =request.getRequestDispatcher("contactus.jsp");
			dis.forward(request, response);
		}
	}

}
