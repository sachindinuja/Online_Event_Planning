package com.payment;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactus.ContactDBUtil;
import com.contactus.ContactUs;

@WebServlet("/UpdatePaymentServlet")
public class UpdatePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paymentId = request.getParameter("pid");
		String cardHoldersName = request.getParameter("chname");
		String paymentMethod = request.getParameter("pm");
		String cardNumber = request.getParameter("cno");
		String expDate = request.getParameter("exp");
		String cvc = request.getParameter("cvc");
		
		boolean isTrue;
		
		isTrue = PaymentDBUtil.updatepayment(paymentId, cardHoldersName, 
				paymentMethod, cardNumber, expDate, cvc);
		
		if(isTrue == true) {
			
			List<Payment> paymentDetails = PaymentDBUtil.getPaymentDetails(paymentId);
			request.setAttribute("paymentDetails", paymentDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("payaccount.jsp");
			dis.forward(request, response);
		}
		else {
			
			List<Payment> paymentDetails = PaymentDBUtil.getPaymentDetails(paymentId);
			request.setAttribute("paymentDetails", paymentDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("payaccount.jsp");
			dis.forward(request, response);
		}
	}

}
