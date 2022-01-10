package com.springboot.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Entity.Customer;
import com.springboot.Service.CustomerService;

@RestController
@RequestMapping("/customer")

public class CustomerController {
	@Autowired
    CustomerService customerService;

	@PostMapping("/saveCustomer")
	public Customer saveCustomer(@RequestBody Customer customer)
	{
		return customerService.saveUser(customer);
	}
	
	@GetMapping("/getCustomers")
	public List<Customer> getAllCustomers()
	{
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/getCustomerById/{id}")
	public Optional<Customer> getCustomerById(@RequestParam int id)
	{
		return customerService.getCustomerById(id);
	}
	

}

