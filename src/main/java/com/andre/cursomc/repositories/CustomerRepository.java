package com.andre.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.cursomc.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
	

}
