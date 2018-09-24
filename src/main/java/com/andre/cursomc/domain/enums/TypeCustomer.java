package com.andre.cursomc.domain.enums;

public enum TypeCustomer 
{
	PHYSICAL_PERSON(1, "Physical Person"),
	LEGAL_PERSON(2, "Legal Person");
	
	private int cod;
	private String description;
	
	private TypeCustomer() 
	{
		
	}
	
	private TypeCustomer(int cod, String description) 
	{
		this.cod = cod;
		this.description = description;
	}

	public int getCod() 
	{
		return cod;
	}

	public String getDescription()
	{
		return description;
	}

	public static TypeCustomer toEnum(Integer cod) 
	{
		if(cod == null) 
		{
			return null;
		}
		
		for (TypeCustomer x : TypeCustomer.values()) 
		{
			if(cod.equals(x.getCod())) 
			{
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id invalid: " + cod);
	}
	
}
