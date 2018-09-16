package com.andre.cursomc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.cursomc.domain.Category;
import com.andre.cursomc.repositories.CategoryRepository;
import com.andre.cursomc.service.exceptions.ObjectNotFoundException;

import java.lang.Integer;

@Service
public class CategoryService 
{
	@Autowired
	private CategoryRepository repository;
	
	public Category search(Integer id) 
	{
		Category obj = repository.findOne(id);
		
		if(obj == null) 
		{
			throw new ObjectNotFoundException("Object not found! Id: " + id
					+ ", type: " + Category.class.getName());
		}
		
		return obj;
	}
}
