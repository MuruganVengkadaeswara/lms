package com.mv.lms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.mv.lms.entities.LoanApplication;
import com.mv.lms.entities.LoanStatus;
import com.mv.lms.entities.LoanType;
import com.mv.lms.entities.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public LoanApplication applyLoan(LoanApplication application) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(application);
		manager.persist(application.getStatus());
		manager.getTransaction().commit();
		manager.close();
		return application;
	}

	@Override
	public User registerUser(User user) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
		manager.close();
		return user;
	}

	@Override
	public User getUser(String userEmail) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<User> query = manager.createQuery("FROM User u WHERE u.userEmail = :email", User.class);
		query.setParameter("email", userEmail);
		List<User> userList = query.getResultList();
		if (userList.isEmpty()) {
			return null;
		} else {
			return userList.get(0);
		}

	}

	@Override
	public User updateUser(User user) {
		EntityManager manager = factory.createEntityManager();
		User user1 = manager.find(User.class, user.getUserId());
		System.out.println(user.getUserId());
		if (user1 != null) {
			manager.getTransaction().begin();
			BeanUtils.copyProperties(user, user1, "userId","role","roleId");
			manager.getTransaction().commit();
			manager.close();
			return user1;
		} else {
			return null;
		}
	}

	@Override
	public LoanStatus getApplicationStatus(long applicationId) {
		EntityManager manager = factory.createEntityManager();
		LoanApplication app = manager.find(LoanApplication.class, applicationId);
		LoanStatus status = manager.find(LoanStatus.class, app.getStatus().getStatusId());
		manager.close();
		return status;
	}

	@Override
	public User authenticate(String email, String password) {

		EntityManager manager = factory.createEntityManager();
		TypedQuery<User> query = manager.createQuery("FROM User u WHERE u.userEmail = : email AND u.password = :pass",
				User.class);

		query.setParameter("email", email);
		query.setParameter("pass", password);
		List<User> userList = query.getResultList();
		if (!userList.isEmpty()) {
			return userList.get(0);
		} else {
			return null;
		}

	}

	@Override
	public List<LoanType> getloantypes() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<LoanType> query = manager.createQuery("FROM LoanType", LoanType.class);
		List<LoanType> list = query.getResultList();
		manager.close();
		return list;
	}

}
