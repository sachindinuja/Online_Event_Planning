package com.payment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String expDate = request.getParameter("expd");
		String cvc = request.getParameter("cvc");
		
		try {
			
			List<Payment> paymentDetails = PaymentDBUtil.validate(expDate, cvc);
			request.setAttribute("paymentDetails", paymentDetails);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("payaccount.jsp");
		dis.forward(request, response);
		
		
	}

}
