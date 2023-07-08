package com.payment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.contactus.ContactDBUtil;

/**
 * Servlet implementation class PaymentInsert
 */
@WebServlet("/PaymentInsert")
public class PaymentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String cardHoldersName = request.getParameter("Cardholder's Name");
		String paymentMethod = request.getParameter("ctype");
		String cardNumber = request.getParameter("Card Number");
		String expDate = request.getParameter("expiry");
		String cvc  = request.getParameter("code");
		
		boolean isCorrect;
		
		isCorrect = PaymentDBUtil.insertpayment(cardHoldersName, paymentMethod, cardNumber, expDate,cvc);
		
		if(isCorrect == true) {
			RequestDispatcher dis = request.getRequestDispatcher("paymentsuccess.jsp");
			dis.forward(request, response);
		}else
		{
			RequestDispatcher dis2 =request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
		
		
	}

}
