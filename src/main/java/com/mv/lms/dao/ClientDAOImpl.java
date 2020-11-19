package com.mv.lms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mv.lms.entities.Client;
import com.mv.lms.entities.Loan;
import com.mv.lms.entities.Payment;

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

		manager.getTransaction().begin();
		manager.persist(payment);
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

}
