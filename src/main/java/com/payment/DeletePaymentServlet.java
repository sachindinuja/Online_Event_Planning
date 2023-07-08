package com.payment;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DeletePaymentServlet
 */
@WebServlet("/DeletePaymentServlet")
public class DeletePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String paymentId = request.getParameter("pid");
		
		boolean isTrue;
		
		isTrue = PaymentDBUtil.deletepayment(paymentId);
		
		if(isTrue == true) {
			RequestDispatcher dis =request.getRequestDispatcher("paymentinsert.jsp");
			dis.forward(request, response);
		}
		else {
			
			List<Payment> paymentDetails = PaymentDBUtil.getPaymentDetails(paymentId);
			request.setAttribute("paymentDetails", paymentDetails);
			
			RequestDispatcher dis =request.getRequestDispatcher("payaccount.jsp");
			dis.forward(request, response);
		}
	}

}
