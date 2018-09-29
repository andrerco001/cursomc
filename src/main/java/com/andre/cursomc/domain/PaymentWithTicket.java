package com.andre.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.andre.cursomc.domain.enums.StatePayment;

@Entity
public class PaymentWithTicket extends Payment // Pagamento com boleto
{
	private static final long serialVersionUID = 1L;
	
	private Date dateExpired;
	
	private Date datePayment;
	
	public PaymentWithTicket() 
	{
		
	}
	
	public PaymentWithTicket(Integer id, StatePayment state, Order order, Date dateExpired, Date datePayment) 
	{
		super(id, state, order);
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
