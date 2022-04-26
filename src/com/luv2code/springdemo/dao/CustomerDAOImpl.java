package com.luv2code.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.luv2code.springdemo.entity.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired   //Will look for sessionFactory in xml file & inject here.
	private SessionFactory sessionFactory;
	

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		
		//execute query and get result list
		
		//return the results
		
		return null;
	}

}
