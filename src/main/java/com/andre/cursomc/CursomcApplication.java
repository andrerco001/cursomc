package com.andre.cursomc;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andre.cursomc.domain.Adress;
import com.andre.cursomc.domain.Category;
import com.andre.cursomc.domain.City;
import com.andre.cursomc.domain.Customer;
import com.andre.cursomc.domain.Product;
import com.andre.cursomc.domain.State;
import com.andre.cursomc.domain.enums.TypeCustomer;
import com.andre.cursomc.repositories.AdressRepository;
import com.andre.cursomc.repositories.CategoryRepository;
import com.andre.cursomc.repositories.CityRepository;
import com.andre.cursomc.repositories.CustomerRepository;
import com.andre.cursomc.repositories.ProductRepository;
import com.andre.cursomc.repositories.StateRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner 
{
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AdressRepository adressRepository;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		// Category
		Category cat1 = new Category(null, "Computing");
		Category cat2 = new Category(null, "Office");
		
		// Product
		Product p1 = new Product(null, "Computer", 2000.00);
		Product p2 = new Product(null, "Printing", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.save(Arrays.asList(cat1, cat2));
		productRepository.save(Arrays.asList(p1, p2, p3));
		
		// State
		State state1 = new State(null, "Minas Gerais");
		State state2 = new State(null, "Sao Paulo");
		
		// City
		City city1 = new City(null, "Uberlandia", state1);
		City city2 = new City(null, "Sao Paulo", state2);
		City city3 = new City(null, "Campinas", state2);
		
		state1.getCities().addAll(Arrays.asList(city1));
		state2.getCities().addAll(Arrays.asList(city2, city3));
		
		stateRepository.save(Arrays.asList(state1, state2));
		cityRepository.save(Arrays.asList(city1, city2, city3));
		
		// Customer
		Customer customer1 = new Customer(null, "Maria Silva", "maria@gmail.com", "363.789.123-77", TypeCustomer.PHYSICAL_PERSON);
		customer1.getPhones().addAll(Arrays.asList("27363323", "93838393"));
		
		// Adresses
		Adress adress1 = new Adress(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", customer1, city1);
		Adress adress2 = new Adress(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", customer1, city2);
		
		customer1.getAdresses().addAll(Arrays.asList(adress1, adress2));
		
		customerRepository.save(Arrays.asList(customer1));
		adressRepository.save(Arrays.asList(adress1, adress2));
		
	}
}
