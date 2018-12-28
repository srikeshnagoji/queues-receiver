package com.nt.activemq.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.nt.activemq.jms.producer.JmsProducer;
import com.nt.activemq.model.Customer;
import com.nt.activemq.model.MessageStorage;

@RestController
public class RestAPIs {
	
//	@Autowired
//	JmsProducer jmsProducer;
	
	
	@Autowired
	private MessageStorage customerStorage;
	
//	@PostMapping(value="/api/customer")//SENDING
//	public Customer postCustomer(@RequestBody Customer customer){
//		jmsProducer.send(customer);
//		return customer;
//	}
	
	@GetMapping(value="/api/customers")//RECEIVING
	public List<Customer> getAll(){
		List<Customer> customers = customerStorage.getAll();
		return customers;
	}
	
	@DeleteMapping(value="/api/customers/clear")
	public String clearCustomerStorage() {
		customerStorage.clear();
		return "Clear All CustomerStorage!";
	}
}
