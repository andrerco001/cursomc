package com.andre.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.cursomc.domain.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer>
{
	

}
