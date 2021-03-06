package com.andre.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andre.cursomc.domain.Adress;
import com.andre.cursomc.domain.CardPayment;
import com.andre.cursomc.domain.Category;
import com.andre.cursomc.domain.City;
import com.andre.cursomc.domain.Customer;
import com.andre.cursomc.domain.ItemRequest;
import com.andre.cursomc.domain.Request;
import com.andre.cursomc.domain.Payment;
import com.andre.cursomc.domain.PaymentWithTicket;
import com.andre.cursomc.domain.Product;
import com.andre.cursomc.domain.State;
import com.andre.cursomc.domain.enums.StatePayment;
import com.andre.cursomc.domain.enums.TypeCustomer;
import com.andre.cursomc.repositories.AdressRepository;
import com.andre.cursomc.repositories.CategoryRepository;
import com.andre.cursomc.repositories.CityRepository;
import com.andre.cursomc.repositories.CustomerRepository;
import com.andre.cursomc.repositories.ItemRequestRepository;
import com.andre.cursomc.repositories.RequestRepository;
import com.andre.cursomc.repositories.PaymentRepository;
import com.andre.cursomc.repositories.ProductRepository;
import com.andre.cursomc.repositories.StateRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner 
{
	@Autowired // automatically create dependency
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

	@Autowired
	private RequestRepository requestRepository;

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private ItemRequestRepository itemRequestRepository;

	public static void main(String[] args) 
	{
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		// Category
		Category category1 = new Category(null, "Computing");
		Category category2 = new Category(null, "Office");

		// Product
		Product product1 = new Product(null, "Computer", 2000.00);
		Product product2 = new Product(null, "Printing", 800.00);
		Product product3 = new Product(null, "Mouse", 80.00);

		category1.getProducts().addAll(Arrays.asList(product1, product2, product3));
		category2.getProducts().addAll(Arrays.asList(product2));

		product1.getCategories().addAll(Arrays.asList(category1));
		product2.getCategories().addAll(Arrays.asList(category1, category2));
		product3.getCategories().addAll(Arrays.asList(category1));

		categoryRepository.save(Arrays.asList(category1, category2));
		productRepository.save(Arrays.asList(product1, product2, product3));

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

		// Order
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Request request1 = new Request(null, sdf.parse("30/09/2017 10:32"), customer1, adress1);
		Request request2 = new Request(null, sdf.parse("10/10/2017 19:35"), customer1, adress2);

		Payment payment1 = new CardPayment(null, StatePayment.SETTLED, request1, 6);
		request1.setPayment(payment1);

		Payment payment2 = new PaymentWithTicket(null, StatePayment.PENDING, request2, sdf.parse("20/10/2017 00:00"), null);
		request2.setPayment(payment2);
		
		customer1.getRequests().addAll(Arrays.asList(request1, request2));

		requestRepository.save(Arrays.asList(request1, request2));
		paymentRepository.save(Arrays.asList(payment1, payment2));
		
		// Itens of requests
		ItemRequest itemRequest1 = new ItemRequest(request1, product1, 0.00, 1, 2000.00);
		ItemRequest itemRequest2 = new ItemRequest(request1, product3, 0.00, 2, 80.00);
		ItemRequest itemRequest3 = new ItemRequest(request2, product2, 100.00, 1, 800.00);
		
		request1.getItens().addAll(Arrays.asList(itemRequest1, itemRequest2));
		request2.getItens().addAll(Arrays.asList(itemRequest3));
		
		product1.getItens().addAll(Arrays.asList(itemRequest1));
		product2.getItens().addAll(Arrays.asList(itemRequest3));
		product3.getItens().addAll(Arrays.asList(itemRequest2));
		
		itemRequestRepository.save(Arrays.asList(itemRequest1, itemRequest2, itemRequest3));

	}
}
