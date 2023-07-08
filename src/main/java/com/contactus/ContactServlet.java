package com.contactus;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.customer.Customer;
//import com.customer.CustomerDBUtil;


@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		/*try {
			
			List<ContactUs> contDetails =ContactDBUtil.validate(userName, password);
			request.setAttribute("contDetails",contDetails);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("contactus.jsp");
		dis.forward(request, response);*/
		
		boolean isTrue;
		
		isTrue = ContactDBUtil.validate(userName, password);
		
		if (isTrue == true) {
			List<ContactUs> contDetails = ContactDBUtil.getcontactus(userName);
			request.setAttribute("contDetails", contDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("contactus.jsp");
			dis.forward(request, response);
		} else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect');");
			out.println("location='contact.jsp'");
			out.println("</script>");
		}
		
	}

}
