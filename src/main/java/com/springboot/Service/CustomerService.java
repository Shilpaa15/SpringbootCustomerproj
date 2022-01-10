package com.springboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Entity.Customer;
import com.springboot.Repository.CustomerRepository;
@Service
public class CustomerService {
	@Autowired
CustomerRepository customerRepository;
	public Customer createCustomer() {
		Customer customer=new Customer();
		customer.setAge(20);
		customer.setGender("Female");
		customer.setName("Pushpa");
		customer.setPreferredFood("Non-veg");
        customerRepository.save(customer);
		return customer;
	}
	public Customer saveUser(Customer customer)
	{
		return customerRepository.save(customer);
	}
	
	public Optional<Customer> getCustomerById(int id)
	{
		return customerRepository.findById(id);
		
	}
	
	public List<Customer> getAllCustomers()
	{
		return customerRepository.findAll();
		
	}
	
	public void deleteCustomer(Customer customer)
	{
		customerRepository.delete(customer);
	}
}
