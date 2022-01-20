package com.springboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.springboot.Entity.Customer;
import com.springboot.Repository.CustomerRepository;
import com.springboot.Service.CustomerService;
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootRestapiApplicationTests {

	@BeforeAll
	//To use before all the function should be static 
	public static void hai()
	{
		System.out.println("Hello");
	}
	
	public static Logger logger = LoggerFactory.getLogger(SpringbootRestapiApplicationTests .class);
	
	@Autowired
	private CustomerService customerService=mock(CustomerService.class);
	
	@MockBean
	private CustomerRepository customerRepository;
	
	
	@Test
	public void saveCustomerTest() {
		logger.info("save Customer test executing");
		Customer customer = new Customer(1, "Manu", "male",25,"veg");
		
		when(customerRepository.save(customer)).thenReturn(customer);
		assertThat(customer.getId()).isGreaterThan(0);
		assertEquals(customer,customerService.saveUser(customer));
	}
	
	@Test
	public void getCustomerByIdTest()
	{
		logger.info("Get Customer by Id test executing");
		int id=1;
		Optional<Customer> customer = Optional.ofNullable(new Customer(1, "Manu", "male",25,"veg"));
		when(customerRepository.findById(id)).thenReturn(customer);
		assertEquals(customer,customerService.getCustomerById(id));
	}
	
	@Test
	public void getAllCustomersTest() {
		logger.info("Get All Customers test executing");
		when(customerRepository.findAll()).thenReturn(Stream
				.of(new Customer(2, "tejas", "male",26,"veg"), 
						new Customer(3, "Darshan", "male",23,"non-veg"))
				.collect(Collectors.toList()));
		Assertions.assertFalse(customerService.getAllCustomers().isEmpty());
		assertEquals(2, customerService.getAllCustomers().size());
	}
	
	@Test
	public void deleteUserTest() {
		logger.info("Delete Customers test executing");
		//Customer customer = new Customer(1, "Manu", "male",25,"veg");
		int id=3;
		customerService.deleteCustomerById(id);;
		verify(customerRepository, times(1)).deleteById(id);
	}
	
	@AfterEach
    public void tearDown() {
        System.out.println("Should Execute After Each Test");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("Should be executed at the end of the Test");
    }
}
