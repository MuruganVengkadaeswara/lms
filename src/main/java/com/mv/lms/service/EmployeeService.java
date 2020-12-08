package com.mv.lms.service;

import java.util.List;

import com.mv.lms.entities.Client;
import com.mv.lms.entities.Loan;
import com.mv.lms.entities.LoanApplication;
import com.mv.lms.entities.LoanStatus;
import com.mv.lms.entities.LoanType;
import com.mv.lms.entities.OverdueLoan;

public interface EmployeeService {

	// Application operations
	public LoanApplication getApplication(Long applicationId);

	public LoanStatus updateApplicationStatus(Long id);

	public List<LoanApplication> getPendingApplications();

	public List<LoanApplication> getApprovedApplications();
	
	public List<LoanApplication> getAllApplications();
	
	public LoanApplication deleteApplication(Long applicationId);



	// Loan Operations
	public Loan addLoan(Loan loan);

	public Loan getLoanDetails(long loanId);

	public Loan updateLoanDetails(Loan loan);
	
	public Loan deleteLoanDetails(long id);

	// Client operations
	public Client addClient(Client client);

	public Client updateClient(Client client);

	public Client deleteClient(long clientid);

	public Client getClient(long clientid);

	public List<Client> getAllClients();

	// Loan Types Operations

	public LoanType addLoanType(LoanType loantype);

	public LoanType updateLoanType(LoanType loantype);

	public LoanType removeLoanType(int loanTypeId);

	public LoanType getLoanType(int loanTypeId);
	
	public List<LoanType> getAllLoanTypes();

	// OverDueLoans operations

	public OverdueLoan getOverDueLoan(long loanId);

	public OverdueLoan addOverDueLoan(OverdueLoan overdueloan);

	public OverdueLoan updateOverDueLoan(OverdueLoan overdueloan);

	public OverdueLoan removeOverDueLoan(long loanId);

	public List<OverdueLoan> getAllOverDueLoans();
}
