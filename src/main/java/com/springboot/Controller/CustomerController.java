package com.springboot.Controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.Entity.Customer;
import com.springboot.Service.CustomerService;
@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
    CustomerService customerService;

	@PostMapping("/customer")
	public Customer saveCustomer(@RequestBody Customer customer)
	{
		return customerService.saveUser(customer);
	}
	@GetMapping("/customers")
	public List<Customer> getAllCustomers()
	{
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/customer/{id}")
	public Optional<Customer> getCustomerById(@PathVariable int id)
	{
		return customerService.getCustomerById(id);
	}
	@DeleteMapping("/deletecustomer/{id}")
	public void deleteCustomerById(@PathVariable int id) {
		customerService.deleteCustomerById(id);
	}
}