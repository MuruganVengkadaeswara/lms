package com.mv.lms.service;

import com.mv.lms.entities.Client;
import com.mv.lms.entities.Loan;
import com.mv.lms.entities.Payment;

public interface ClientService {

	// client operations
	public Loan getLoanDetails(long loanId);

	public Client getClient(String email);

	// payment operations
	public Payment makePayment(Payment payment);

	public Payment getPaymentDetails(long paymentId);
}
