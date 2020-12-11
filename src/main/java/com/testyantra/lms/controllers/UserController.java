package com.testyantra.lms.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import com.testyantra.lms.dto.ResponseDTO;
import com.testyantra.lms.entities.LoanApplication;
import com.testyantra.lms.entities.User;
import com.testyantra.lms.service.UserService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin("http://localhost:3000")
public class UserController {

	@Autowired
	public UserService service;

	
	@PostMapping(value = "/login", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@SessionScope
	public ResponseDTO login(@RequestBody User user,HttpServletRequest req,HttpServletResponse resp,HttpSession session) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.authenticate(user.getUserEmail(), user.getPassword()));
		session.invalidate();
//		 req.getSession().setAttribute("response", "resp");
		HttpSession newsession = req.getSession();
		newsession.setAttribute("username", "1234");
		return response;
	}

	@PostMapping(value = "/register", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO register(@RequestBody User user) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.registerUser(user));
		return response;
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO getUser(String userEmail) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getUser(userEmail));
		return response;
	}

	@PutMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO updateUser(@RequestBody User user) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.updateUser(user));
		return response;
	}

	@PostMapping(value = "/apply", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO applyLoan(@RequestBody LoanApplication application) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.applyLoan(application));
		return response;
	}

	@GetMapping(value = "/applicationstatus/{appid}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO getApplicationStatus(@PathVariable Long appid) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getApplicationStatus(appid));
		return response;
	}

	@GetMapping(value = "/loantypes", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseDTO getLoanTypes() {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getLoanTypes());
		return response;
	}

}
