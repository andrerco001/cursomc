package com.andre.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.cursomc.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>
{
	

}
