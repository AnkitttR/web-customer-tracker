package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject our customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")   //Jab hum /customer/list pe honge toh, list-customers.jsp page open hoga.
	public String listCustomers(Model theModel) {
		
		//get customers from the service
		List<Customer> theCustomers = customerService.getCustomers(); //Hey customerDAO give me Customers
		
		//add the customers to the model
		theModel.addAttribute("customers", theCustomers);  //Hey theModel I will add Attribute intoyou.
		                      //"name"  , value
		
		return "list-customers";   //list-customers.jsp page
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//save the customer using our service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	//Jab update per click hoga toh, last mein ek Id hoga, wo Id @RequestParam ki help se catch karenge, aur wo "theId" variable mein store karenge. 
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		//get the customer from our service
		Customer theCustomer = customerService.getCustomer(theId);
		
		//set customer as a model attribute to pre-populate the form
		//Model ke attribute ke rup mein customer ko set karenge
		theModel.addAttribute("customer",theCustomer);
		
		//send over to our form
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		//delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
}






