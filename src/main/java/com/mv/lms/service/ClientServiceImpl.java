package com.mv.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mv.lms.dao.ClientDAO;
import com.mv.lms.entities.Client;
import com.mv.lms.entities.Loan;
import com.mv.lms.entities.Payment;
import com.mv.lms.exceptions.LoanException;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	public ClientDAO clientdao;

	@Override
	public Loan getLoanDetails(long loanId) {
		Loan loan = clientdao.getLoanDetails(loanId);
		if (loan != null) {
			return loan;
		} else {
			throw new LoanException("Unable to get loan details");
		}
	}

	@Override
	public Client getClient(String email) {
		Client client = clientdao.getClient(email);
		if (client != null) {
			return client;
		} else {
			throw new LoanException("unable to get client");
		}
	}

	@Override
	public Payment makePayment(Payment payment) {
		Payment paymentDto = clientdao.makePayment(payment);
		if (paymentDto != null) {
			return paymentDto;
		} else {
			throw new LoanException("Unable to make payment");
		}
	}

	@Override
	public Payment getPaymentDetails(long paymentId) {
		Payment paymentDto = clientdao.getPaymentDetails(paymentId);
		if (paymentDto != null) {
			return paymentDto;
		} else {
			throw new LoanException("Unable to get Payment details");
		}
	}

}
