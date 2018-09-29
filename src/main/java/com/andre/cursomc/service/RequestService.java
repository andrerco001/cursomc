package com.andre.cursomc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.cursomc.domain.Request;
import com.andre.cursomc.repositories.RequestRepository;
import com.andre.cursomc.service.exceptions.ObjectNotFoundException;

import java.lang.Integer;

@Service
public class RequestService 
{
	@Autowired
	private RequestRepository repository;
	
	public Request search(Integer id) 
	{
		Request obj = repository.findOne(id);
		
		if(obj == null) 
		{
			throw new ObjectNotFoundException("Object not found! Id: " + id
					+ ", type: " + Request.class.getName());
		}
		
		return obj;
	}
}
