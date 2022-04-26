package com.luv2code.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject the customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")   //Jab hum /customer/list pe honge toh, list-customers.jsp page open hoga.
	public String listCustomers(Model theModel) {
		
		//get customers from the dao
		
		//add the customers to the model
		
		
		
		return "list-customers";   //list-customers.jsp page
	}
}
