package com.testyantra.lms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.testyantra.lms.dto.ResponseDTO;
import com.testyantra.lms.entities.Payment;
import com.testyantra.lms.service.ClientService;

@RestController
@RequestMapping(value = "/client")
@CrossOrigin("http://localhost:3000")
public class ClientController {

	@Autowired
	public ClientService service;

	@GetMapping(value = "/loan/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO getLoanDetails(@PathVariable Long id) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getLoanDetails(id));
		return response;
	}
	
	@GetMapping(value = "/loans/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO getAllLoans(@PathVariable Long id) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getAllLoans(id));
		return response;
	}
	
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO getClient(String email) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getClient(email));
		return response;
	}

	// payment operations

	@PostMapping(value = "/payment", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO makePayment(@RequestBody Payment payment) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.makePayment(payment));
		return response;
	}

	@GetMapping(value = "/payment/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO getPaymentDetails(@PathVariable Long id) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getPaymentDetails(id));
		return response;
	}
	
	@GetMapping(value = "/payments/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO getAllPaymentDetails(@PathVariable Long id) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getPayments(id));
		return response;
	}

}
