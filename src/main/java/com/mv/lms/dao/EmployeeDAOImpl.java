package com.mv.lms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.mv.lms.entities.Client;
import com.mv.lms.entities.Loan;
import com.mv.lms.entities.LoanApplication;
import com.mv.lms.entities.LoanStatus;
import com.mv.lms.entities.LoanType;
import com.mv.lms.entities.OverdueLoan;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public LoanApplication getApplication(Long applicationId) {
		EntityManager manager = factory.createEntityManager();
		LoanApplication application = manager.find(LoanApplication.class, applicationId);
		manager.close();
		return application;
	}

	@Override
	public LoanStatus updateApplicationStatus(LoanStatus status) {
		EntityManager manager = factory.createEntityManager();
		LoanStatus status1 = manager.find(LoanStatus.class, status.getStatusId());
		if (status1 != null) {
			manager.getTransaction().begin();
			BeanUtils.copyProperties(status, status1, "loanStatusId");
			manager.getTransaction().commit();
			manager.close();
			return status1;

		} else {
			return null;
		}

	}

	@Override
	public List<LoanApplication> getPendingApplications() {

		EntityManager manager = factory.createEntityManager();
		TypedQuery<LoanStatus> query1 = manager.createQuery("FROM LoanStatus where status='pending'", LoanStatus.class);
		List<LoanStatus> statusList = query1.getResultList();
		List<LoanApplication> list = new ArrayList<>();
		TypedQuery<LoanApplication> query = manager.createQuery("FROM LoanApplication where statusid = :id",
				LoanApplication.class);
		for (LoanStatus status : statusList) {
			query.setParameter("id", status.getStatusId());
			list.add(query.getSingleResult());
		}
		manager.close();
		return list;
	}

	@Override
	public List<LoanApplication> getApprovedApplications() {

		EntityManager manager = factory.createEntityManager();
		TypedQuery<LoanStatus> query1 = manager.createQuery("FROM LoanStatus where status='approved'", LoanStatus.class);
		List<LoanStatus> statusList = query1.getResultList();
		List<LoanApplication> list = new ArrayList<>();
		TypedQuery<LoanApplication> query = manager.createQuery("FROM LoanApplication where statusid = :id",
				LoanApplication.class);
		for (LoanStatus status : statusList) {
			query.setParameter("id", status.getStatusId());
			list.add(query.getSingleResult());
		}
		manager.close();
		return list;
	}

	@Override
	public Loan addLoan(Loan loan) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
//		manager.persist(loan.getLoantype());
//		manager.persist(loan.getClient());
		manager.persist(loan);
		manager.getTransaction().commit();
		return loan;
	}

	// query with other than primary key (auto generated)

	@Override
	public Loan getLoanDetails(long loanId) {
		EntityManager manager = factory.createEntityManager();
		Loan loan = manager.find(Loan.class, loanId);
		manager.close();
		return loan;
	}

	@Override
	public Loan updateLoanDetails(Loan loan) {
		EntityManager manager = factory.createEntityManager();
		Loan loan1 = manager.find(Loan.class, loan.getLoanId());
		if (loan1 != null) {
			manager.getTransaction().begin();
			BeanUtils.copyProperties(loan, loan1);
			manager.getTransaction().commit();
			return loan1;
		} else {
			return null;
		}
	}

	@Override
	public Client addClient(Client client) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(client);
		manager.getTransaction().commit();
		manager.close();
		return client;
	}

	@Override
	public Client updateClient(Client client) {
		EntityManager manager = factory.createEntityManager();
		Client client1 = manager.find(Client.class, client.getClientId());
		if (client1 != null) {
			manager.getTransaction().begin();
			BeanUtils.copyProperties(client, client1, "clientId");
			manager.getTransaction().commit();
			return client1;
		} else {
			return null;
		}

	}

	@Override
	public Client deleteClient(long clientid) {
		EntityManager manager = factory.createEntityManager();
		Client client = manager.find(Client.class, clientid);
		if (client != null) {
			manager.getTransaction().begin();
			manager.remove(client);
			manager.getTransaction().commit();
			manager.close();
			return client;
		} else {
			return null;
		}

	}

	@Override
	public Client getClient(long clientid) {
		EntityManager manager = factory.createEntityManager();
		Client client = manager.find(Client.class, clientid);
		manager.close();
		return client;
	}

	@Override
	public List<Client> getAllClients() {

		EntityManager manager = factory.createEntityManager();
		TypedQuery<Client> query = manager.createQuery("FROM Client", Client.class);
		List<Client> clientList = query.getResultList();
		manager.close();
		return clientList;
	}

	@Override
	public LoanType addLoanType(LoanType loantype) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(loantype);
		manager.getTransaction().commit();
		return loantype;
	}

	@Override
	public LoanType updateLoanType(LoanType loantype) {
		EntityManager manager = factory.createEntityManager();
		LoanType type = manager.find(LoanType.class, loantype.getLoanTypeId());
		if (type != null) {
			manager.getTransaction().begin();
			BeanUtils.copyProperties(loantype, type,"LoanTypeId");
			manager.getTransaction().commit();
			manager.close();
			return type;
		} else {
			return null;
		}

	}

	@Override
	public LoanType removeLoanType(int loanTypeId) {
		EntityManager manager = factory.createEntityManager();
		LoanType loanType = manager.find(LoanType.class, loanTypeId);
		if (loanType != null) {
			manager.getTransaction().begin();
			manager.remove(loanType);
			manager.getTransaction().commit();
			return loanType;
		} else {
			return null;
		}
	}

	@Override
	public LoanType getLoanType(int loanTypeId) {
		EntityManager manager = factory.createEntityManager();
		LoanType loanType = manager.find(LoanType.class, loanTypeId);
		manager.close();
		return loanType;
	}

	@Override
	public OverdueLoan getOverDueLoan(long loanId) {
		EntityManager manager = factory.createEntityManager();
		OverdueLoan odLoan = manager.find(OverdueLoan.class, loanId);
		manager.close();
		return odLoan;
	}

	@Override
	public OverdueLoan addOverDueLoan(OverdueLoan overdueloan) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(overdueloan);
		manager.getTransaction().commit();
		manager.close();
		return overdueloan;
	}

	@Override
	public OverdueLoan updateOverDueLoan(OverdueLoan overdueloan) {
		EntityManager manager = factory.createEntityManager();
		OverdueLoan odLoan = manager.find(OverdueLoan.class, overdueloan.getOverDueLoanId());
		if (odLoan != null) {
			manager.getTransaction().begin();
			BeanUtils.copyProperties(overdueloan, odLoan);
			manager.getTransaction().commit();
			manager.close();
			return odLoan;
		} else {
			return null;
		}
	}

	@Override
	public OverdueLoan removeOverDueLoan(long loanId) {
		EntityManager manager = factory.createEntityManager();
		OverdueLoan odLoan = manager.find(OverdueLoan.class, loanId);
		if (odLoan != null) {
			manager.getTransaction().begin();
			manager.remove(odLoan);
			manager.getTransaction().commit();
			manager.close();
			return odLoan;

		} else {
			return null;
		}
	}

	@Override
	public List<OverdueLoan> getAllOverDueLoans() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<OverdueLoan> query = manager.createQuery("From OverDueLoan", OverdueLoan.class);
		List<OverdueLoan> list = query.getResultList();
		manager.close();
		return list;
	}

	@Override
	public Loan deleteLoanDetails(long id) {
		EntityManager manager = factory.createEntityManager();
		Loan loan = manager.find(Loan.class, id);
		if (loan != null) {
			manager.getTransaction().begin();
			manager.remove(loan);
			manager.getTransaction().commit();
			return loan;
		} else {
			return null;
		}

	}

	@Override
	public List<LoanType> getAllLoanTypes() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<LoanType> query = manager.createQuery("FROM LoanType", LoanType.class);
		List<LoanType> list = query.getResultList();
		manager.close();
		return list;
	}

}
