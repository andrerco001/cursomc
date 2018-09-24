package com.andre.cursomc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.cursomc.domain.Customer;
import com.andre.cursomc.repositories.CustomerRepository;
import com.andre.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class CustomerService 
{
	@Autowired
	private CustomerRepository repository;
	
	public Customer search(Integer id) 
	{
		Customer obj = repository.findOne(id);
		
		if(obj == null) 
		{
			throw new ObjectNotFoundException("Object not found! Id: " + id
					+ ", type: " + Customer.class.getName());
		}
		
		return obj;
	}
}
