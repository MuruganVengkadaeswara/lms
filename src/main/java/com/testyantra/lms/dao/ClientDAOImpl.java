package com.testyantra.lms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.testyantra.lms.entities.Client;
import com.testyantra.lms.entities.Loan;
import com.testyantra.lms.entities.Payment;

@Repository
public class ClientDAOImpl implements ClientDAO {

	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public Loan getLoanDetails(long loanId) {

		EntityManager manager = factory.createEntityManager();
		Loan loan = manager.find(Loan.class, loanId);
		manager.close();
		return loan;
	}

	@Override
	public Client getClient(String email) {

		EntityManager manager = factory.createEntityManager();
		TypedQuery<Client> query = manager.createQuery("FROM Client c WHERE email = :mail", Client.class);
		query.setParameter("mail", email);
		List<Client> clientList = query.getResultList();
		if (clientList.isEmpty()) {
			manager.close();
			return null;
		} else {
			manager.close();
			return clientList.get(0);

		}

	}

	@Override
	public Payment makePayment(Payment payment) {
		EntityManager manager = factory.createEntityManager();
		Loan loan = manager.find(Loan.class, payment.getLoanId());
		manager.getTransaction().begin();
		manager.persist(payment);
		loan.setLoanAmount(loan.getLoanAmount() - payment.getAmountPaid());
		loan.setPendingEmis(loan.getPendingEmis() - 1);
		manager.getTransaction().commit();
		return payment;
	}

	@Override
	public Payment getPaymentDetails(long paymentId) {
		EntityManager manager = factory.createEntityManager();
		Payment payment = manager.find(Payment.class, paymentId);
		manager.close();
		return payment;
	}

	@Override
	public List<Loan> getAllLoans(Long clientId) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Loan> query = manager.createQuery("FROM Loan where clientId= :id", Loan.class);
		query.setParameter("id", clientId);
		List<Loan> loanList = query.getResultList();
		if (loanList.isEmpty()) {
			return null;
		} else {
			return loanList;
		}
	}

	@Override
	public List<Payment> getPayments(Long loanId) {

		EntityManager manager = factory.createEntityManager();
		TypedQuery<Payment> query= manager.createQuery("FROM Payment where loanid= :id",Payment.class);
		query.setParameter("id", loanId);
		List<Payment> paymentlist = query.getResultList();
		return paymentlist;
	}

}
