package com.andre.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.andre.cursomc.domain.enums.StatePayment;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PaymentWithTicket extends Payment // Pagamento com boleto
{
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateExpired;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date datePayment;
	
	public PaymentWithTicket() 
	{
		
	}
	
	public PaymentWithTicket(Integer id, StatePayment state, Request request, Date dateExpired, Date datePayment) 
	{
		super(id, state, request);
		this.datePayment = datePayment;
		this.dateExpired = dateExpired;
		
	}
	
	public Date getDateExpired() 
	{
		return dateExpired;
	}

	public void setDateExpired(Date dateExpired) 
	{
		this.dateExpired = dateExpired;
	}

	public Date getDatePayment() 
	{
		return datePayment;
	}

	public void setDatePayment(Date datePayment)
	{
		this.datePayment = datePayment;
	}
	

}
