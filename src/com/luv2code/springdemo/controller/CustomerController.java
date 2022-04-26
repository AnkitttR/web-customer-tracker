package com.luv2code.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping("/list")   //Jab hum /customer/list pe honge toh, list-customers.jsp page open hoga.
	public String listCustomers(Model theModel) {
		
		return "list-customers";   //list-customers.jsp page
	}
}
