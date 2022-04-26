package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject the customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")   //Jab hum /customer/list pe honge toh, list-customers.jsp page open hoga.
	public String listCustomers(Model theModel) {
		
		//get customers from the dao
		List<Customer> theCustomers = customerDAO.getCustomers(); //Hey customerDAO give me Customers
		
		//add the customers to the model
		theModel.addAttribute("customers", theCustomers);  //Hey theModel I will add Attribute intoyou.
		                      //"name"  , value
		
		return "list-customers";   //list-customers.jsp page
	}
}
