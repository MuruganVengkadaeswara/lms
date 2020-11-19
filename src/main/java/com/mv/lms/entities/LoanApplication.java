package com.mv.lms.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;


import lombok.Data;

@Data
@Entity
@Table(name = "loan_applications")
public class LoanApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long applicationId;

//	@Pattern(regexp = "/^[a-z ,.'-]+$/i\n")
	@Column(name = "first_name")
	private String firstName;

//	@Pattern(regexp = "/^[a-z ,.'-]+$/i\n")
	@Column(name = "last_name")
	private String lastName;

	@Column(name = "middle_name")
	private String middleName;

	@NotNull
	private String gender;
	
	private String email;
	
	@Column(name="loan_amount")
	private double loanAmount;
	
	@Column(name="comp_name")
	private String compName;

//	@Past
	@NotNull
	private Date dob;

	@Column(name = "address_1")
	private String address1;

	@Column(name = "address_2")
	private String address2;
 
//	@Pattern(regexp = "/^[a-zA-Z ]*$/")
	private String state;

//	@Pattern(regexp = "/^[a-zA-Z ]*$/")
	private String city;

//	@Pattern(regexp = "^[0-9]{6,6}$")
	private int pincode;

//	@NotNull
	@Column(name = "applicant_job")
	private String applicantJob;

//	@NotNull
	@Column(name = "applicant_salary")
	private String appicantSalary;

//	@Pattern(regexp = "/^(\\+\\d{1,3}[- ]?)?\\d{10}$/")
	@Column(name = "mobile_no")
	private long mobileNo;

//	@NotNull
	@Column(name = "identity_type")
	private String identityType;

//	@NotNull
	@Column(name = "identity_no")
	private long identityNo;

//	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}")
	@Column(name = "pan_no")
	private String panNo;
	
	@Column(name="empl_type")
	private String emplType;

	@OneToOne
	@JoinColumn(name = "statusId")
	private LoanStatus status;

	@ManyToOne
	@JoinColumn(name = "loanTypeId", referencedColumnName = "loanTypeId", insertable = false, updatable = false)
	private LoanType loantype;

	@Column(name = "loanTypeId")
	private Integer loanTypeId;

}
