package com.andre.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.andre.cursomc.domain.enums.TypeCustomer;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Customer implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String spfOrCnpf;
	private Integer type;
	
	@JsonManagedReference
	@OneToMany(mappedBy="customer")
	private List<Adress> adresses = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name="phones")
	private Set<String> phones = new HashSet<>();
	
	public Customer() 
	{
		
	}

	public Customer(Integer id, String name, String email, String spfOrCnpf, TypeCustomer type) 
	{
		this.id = id;
		this.name = name;
		this.email = email;
		this.spfOrCnpf = spfOrCnpf;
		this.type = type.getCod();
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getSpfOrCnpf() 
	{
		return spfOrCnpf;
	}

	public void setSpfOrCnpf(String spfOrCnpf) 
	{
		this.spfOrCnpf = spfOrCnpf;
	}

	public TypeCustomer getType()
	{
		return TypeCustomer.toEnum(type);
	}

	public void setType(TypeCustomer type)
	{
		this.type = type.getCod();
	}

	public List<Adress> getAdresses() 
	{
		return adresses;
	}

	public void setAdresses(List<Adress> adresses) 
	{
		this.adresses = adresses;
	}

	public Set<String> getPhones() 
	{
		return phones;
	}

	public void setPhones(Set<String> phones) 
	{
		this.phones = phones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id == null) 
		{
			if (other.id != null)
				return false;
		} 
		else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
