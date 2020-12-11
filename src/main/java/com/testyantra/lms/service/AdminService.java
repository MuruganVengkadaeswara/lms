package com.testyantra.lms.service;

import java.util.List;

import com.testyantra.lms.entities.Employee;
import com.testyantra.lms.entities.Role;

public interface AdminService {

	// Employee Operations

	public Employee addEmployee(Employee employee);

	public List<Employee> getEmployee(String searchText);

	public Employee updateEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee deleteEmployee(int employeeId);
	
	public Employee getEmployeeById(int employeeId);

	// Roles operations

	public Role addRole(Role role);

	public Role updateRole(Role role);
	
	public Role getRole(int id);
	
	public List<Role> getAllRoles();

}
