package com.testyantra.lms.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Table(name = "loans")
@Entity
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long loanId;

	@NotNull
	@Column(name = "loan_amount")
	private long loanAmount;

	@NotNull
	@Column(name = "emi_amount")
	private long emiAmount;

	@NotNull
	@Column(name = "collateral_type")
	private String collateralType;

	@NotNull
	@Column(name = "collateral_value")
	private long collateralValue;

//	@Pattern(regexp = "^[0-9]{1,6}$")
	@Column(name = "emi_duration")
	private int emiDuration;

//	@Pattern(regexp = "^[0-9]{1,6}$")
	@Column(name = "pending_emis")
	private int pendingEmis;

	@ManyToOne
	@JoinColumn(name = "loanTypeId", referencedColumnName = "loanTypeId", insertable = false, updatable = false)
	private LoanType loantype;

	@Column(name = "loanTypeId")
	private Integer loanTypeId;

	@ManyToOne
	@JoinColumn(name = "clientId", referencedColumnName = "client_id", insertable = false, updatable = false)
	private Client client;

	@Column(name = "clientId")
	private long clientId;

	@JsonIgnore
	@OneToMany(mappedBy = "loan")
	private List<OverdueLoan> overdues;

	@JsonIgnore
	@OneToMany(mappedBy = "loan")
	private List<Payment> payment;

}
