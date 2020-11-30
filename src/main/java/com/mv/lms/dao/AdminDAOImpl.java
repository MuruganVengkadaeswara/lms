package com.mv.lms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.mv.lms.entities.Employee;
import com.mv.lms.entities.Role;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public Employee addEmployee(Employee employee) {

		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(employee);
		manager.getTransaction().commit();
		return employee;
	}

	@Override
	public List<Employee> getEmployee(String searchText) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Employee> query = manager.createQuery(
				"FROM Employee e WHERE email LIKE : pattern OR lastname LIKE : pattern OR firstname LIKE : pattern",
				Employee.class);
		query.setParameter("pattern", "%" + searchText + "%");
		List<Employee> employeeList = query.getResultList();
		if (employeeList.isEmpty()) {
			return null;
		} else {
			return employeeList;
		}

	}

	@Override
	public Employee updateEmployee(Employee employee) {

		EntityManager manager = factory.createEntityManager();
		Employee employee1 = manager.find(Employee.class, employee.getEmployeeId());
		if (employee1 != null) {
			manager.getTransaction().begin();
			BeanUtils.copyProperties(employee, employee1);
			manager.getTransaction().commit();
			manager.close();
			return employee1;
		} else {
			return null;
		}

	}

	@Override
	public List<Employee> getAllEmployees() {

		EntityManager manager = factory.createEntityManager();
		List<Employee> empList = manager.createQuery("FROM Employee", Employee.class).getResultList();
		manager.close();
		return empList;
	}

	@Override
	public Employee deleteEmployee(int employeeId) {

		EntityManager manager = factory.createEntityManager();
		Employee employee = manager.find(Employee.class, employeeId);
		if (employee != null) {
			manager.getTransaction().begin();
			manager.remove(employee);
			manager.getTransaction().commit();
			return employee;
		} else {
			return null;
		}

	}

	@Override
	public Role addRole(Role role) {

		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(role);
		manager.getTransaction().commit();
		return role;
	}

	@Override
	public Role updateRole(Role role) {
		EntityManager manager = factory.createEntityManager();
		Role role1 = manager.find(Role.class, role.getRoleId());
		if (role1 != null) {
			manager.getTransaction().begin();
			BeanUtils.copyProperties(role, role1);
			return role1;
		} else {
			return null;
		}

	}

	@Override
	public Role getRole(int roleId) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Role> query = manager.createQuery("FROM Role where roleId = : rid", Role.class);
		List<Role> roleList = query.getResultList();
		if (roleList.isEmpty()) {
			manager.close();
			return null;
		} else {
			manager.close();
			return roleList.get(0);
		}
	}

}
