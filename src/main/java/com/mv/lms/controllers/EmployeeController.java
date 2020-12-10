package com.mv.lms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mv.lms.dto.ResponseDTO;
import com.mv.lms.entities.Client;
import com.mv.lms.entities.Loan;
import com.mv.lms.entities.LoanStatus;
import com.mv.lms.entities.LoanType;
import com.mv.lms.entities.OverdueLoan;
import com.mv.lms.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin("http://localhost:3000")
public class EmployeeController {

	@Autowired
	public EmployeeService service;

	@GetMapping(value = "/application/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO getApplication(@PathVariable Long id) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getApplication(id));
		return response;
	}

	@GetMapping(value = "/applications", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO getAllApplications() {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getAllApplications());
		return response;
	}

	@DeleteMapping(value = "/application/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO deleteApplication(@PathVariable Long id) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.deleteApplication(id));
		return response;
	}

	@PutMapping(value = "/manage-loanstatus/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO updateApplicationStatus(@PathVariable Long id, @RequestBody LoanStatus status) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.updateApplicationStatus(id, status));
		return response;
	}

	@GetMapping(value = "/applications-pending", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO getPendingApplications() {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getPendingApplications());
		return response;
	}

	@GetMapping(value = "/applications-approved", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO getApprovedApplications() {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getApprovedApplications());
		return response;
	}

	// Loan operations

	@PostMapping(value = "/loans", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO addLoan(@RequestBody Loan loan) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.addLoan(loan));
		return response;
	}

	@GetMapping(value = "/loans/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO getLoanDetails(@PathVariable Long id) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getLoanDetails(id));
		return response;
	}

	@PutMapping(value = "/loans", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO updateLoanDetails(@RequestBody Loan loan) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.updateLoanDetails(loan));
		return response;
	}

	@DeleteMapping(value = "/loans/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO deleteLoanDetails(@PathVariable Long id) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.deleteLoanDetails(id));
		return response;
	}
	// client operations

	@PostMapping(value = "/client", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO addClient(@RequestBody Client client) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.addClient(client));
		return response;
	}

	@PutMapping(value = "/client", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO updateClient(@RequestBody Client client) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.updateClient(client));
		return response;

	}

	@DeleteMapping(value = "/clients/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO deleteClient(@PathVariable Long id) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.deleteClient(id));
		return response;
	}

	@GetMapping(value = "/clients/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO getClient(@PathVariable long id) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getClient(id));
		return response;
	}

	@GetMapping(value = "/clients", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO getAllClients() {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getAllClients());
		return response;

	}

	@GetMapping(value = "/client", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO getClientByEmail(String email) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getClientByEmail(email));
		return response;

	}

	// Loan types operations

	@PostMapping(value = "/loantype", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO addLoanType(@RequestBody LoanType type) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.addLoanType(type));
		return response;
	}

	@PutMapping(value = "/loantype", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO updateLoanType(@RequestBody LoanType type) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.updateLoanType(type));
		return response;
	}

	@DeleteMapping(value = "/loantypes/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO removeLoanType(@PathVariable Integer id) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.removeLoanType(id));
		return response;
	}

	@GetMapping(value = "/loantype", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO getLoanType(Integer id) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getLoanType(id));
		return response;
	}

	@GetMapping(value = "/loantypes", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO getAllLoanTypes() {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getAllLoanTypes());
		return response;
	}

	// OverDueLoan operations

	@GetMapping(value = "/overdueloans/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO getOverDueLoan(@PathVariable Long id) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getOverDueLoan(id));
		return response;
	}

	@PostMapping(value = "/overdueloan", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO addOverDueLoan(OverdueLoan odloan) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.addOverDueLoan(odloan));
		return response;
	}

	@PutMapping(value = "/overdueloan", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO updateOverDueLoan(OverdueLoan odloan) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.updateOverDueLoan(odloan));
		return response;
	}

	@DeleteMapping(value = "/overdueloan/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO deleteOverDueLoan(@PathVariable Long id) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.removeOverDueLoan(id));
		return response;
	}

	@GetMapping(value = "/overdueloans", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO getAllOverDueLoans() {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getAllOverDueLoans());
		return response;
	}
}
