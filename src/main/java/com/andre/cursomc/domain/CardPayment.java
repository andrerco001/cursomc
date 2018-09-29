package com.andre.cursomc.domain;

import javax.persistence.Entity;

import com.andre.cursomc.domain.enums.StatePayment;

@Entity
public class CardPayment extends Payment
{
	private static final long serialVersionUID = 1L;
	
	private Integer numberOfParcels;
	
	public CardPayment() 
	{

	}
	
	public CardPayment(Integer id, StatePayment state, Order order, Integer numberOfParcels) 
	{
		super(id, state, order);
		this.numberOfParcels = numberOfParcels;
	}

	public Integer getNumberOfParcels() 
	{
		return numberOfParcels;
	}

	public void setNumberOfParcels(Integer numberOfParcels) 
	{
		this.numberOfParcels = numberOfParcels;
	}

}
