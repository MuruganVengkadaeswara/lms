package com.mv.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mv.lms.dao.AdminDAO;
import com.mv.lms.entities.Employee;
import com.mv.lms.entities.Role;
import com.mv.lms.exceptions.LoanException;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	public AdminDAO admindao;

	@Override
	public Employee addEmployee(Employee employee) {
		Employee empDto = admindao.addEmployee(employee);
		if (empDto != null) {
			return empDto;
		} else {
			throw new LoanException("Unable to add Employee");
		}

	}

	@Override
	public List<Employee> getEmployee(String searchText) {
		List<Employee> empDto = admindao.getEmployee(searchText);
		if (empDto != null) {
			return empDto;
		} else {
			throw new LoanException("unable to get employee");
		}
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee empDto = admindao.updateEmployee(employee);
		if (empDto != null) {
			return empDto;
		} else {
			throw new LoanException("unable to update employee");
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emplist = admindao.getAllEmployees();
		if (!emplist.isEmpty()) {
			return emplist;
		} else {
			throw new LoanException("Unable to fetch all employees please try after some time");
		}

	}

	@Override
	public Employee deleteEmployee(int employeeId) {
		Employee empDto = admindao.deleteEmployee(employeeId);
		if (empDto != null) {
			return empDto;
		} else {
			throw new LoanException("Unable to Delete");
		}
	}

	@Override
	public Role addRole(Role role) {
		Role roleDto = admindao.addRole(role);
		if (roleDto != null) {
			return roleDto;
		} else {
			throw new LoanException("Unable to add Role please try after some time");
		}
	}

	@Override
	public Role updateRole(Role role) {
		Role roleDto = admindao.updateRole(role);
		if (roleDto != null) {
			return roleDto;
		} else {
			throw new LoanException("Unable to update Role please try after some time");
		}
	}
	
	@Override
	public Role getRole(int id) {
		Role roleDto = admindao.getRole(id);
		if(roleDto != null) {
			return roleDto;
		}
		else {
			throw new LoanException("unable to get role");
		}
	}
}
