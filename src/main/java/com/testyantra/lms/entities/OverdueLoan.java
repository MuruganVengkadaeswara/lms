package com.testyantra.lms.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "overdue_loans")
public class OverdueLoan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long overDueLoanId;

	@Column(name = "overdue_period")
	private int overduePeriod;

	@Column(name = "priority")
	private String priority;

	@ManyToOne
	@JoinColumn(name = "loanId", referencedColumnName = "loanId",insertable = false,updatable = false)
	private Loan loan;

	@Column(name = "loanId")
	private long loanId;

	@Column(name = "due_date")
	private Date dueDate;

}
