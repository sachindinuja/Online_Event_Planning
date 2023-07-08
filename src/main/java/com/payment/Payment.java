package com.payment;

public class Payment {
	int paymentId;
	String cardHoldersName;
	String paymentMethod;
	String cardNumber;
	String expDate;
	String cvc;
	
	public Payment(int paymentId,String cardHoldersName,String paymentMethod,String cardNumber, String expDate, String cvc) {
		this.paymentId = paymentId;
		this.cardHoldersName = cardHoldersName;
		this.paymentMethod=paymentMethod;
		this.cardNumber = cardNumber;
		this.expDate = expDate;
		this.cvc = cvc;
	}
	

	public int getPaymentId() {
		return paymentId;
	}

	public String getCardHoldersName() {
		return cardHoldersName;
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getExpDate() {
		return expDate;
	}

	public String getCvc() {
		return cvc;
	}




	
	
}
