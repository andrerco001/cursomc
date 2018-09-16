package com.andre.cursomc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.cursomc.domain.Category;
import com.andre.cursomc.repositories.CategoryRepository;

import java.lang.Integer;

@Service
public class CategoryService 
{
	@Autowired
	private CategoryRepository repository;
	
	public Category search(Integer id) 
	{
		Category obj = repository.findOne(id);
		
		return obj;
	}

}
