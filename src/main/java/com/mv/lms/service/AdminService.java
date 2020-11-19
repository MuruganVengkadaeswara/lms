package com.mv.lms.service;

import java.util.List;

import com.mv.lms.entities.Employee;
import com.mv.lms.entities.Role;

public interface AdminService {

	// Employee Operations

	public Employee addEmployee(Employee employee);

	public Employee getEmployee(String searchText);

	public Employee updateEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee deleteEmployee(int employeeId);

	// Roles operations

	public Role addRole(Role role);

	public Role updateRole(Role role);
	
	public Role getRole(int id);

}
