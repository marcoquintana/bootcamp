package com.nttdata.customerservice.model.service;

import com.nttdata.customerservice.model.document.Customer;
import com.nttdata.customerservice.model.document.Company;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

	Flux<Customer> getAll();
	
	Mono<Customer> save(Customer customer);
	
	Mono<Customer> findById(String Id);
	
	Mono<Boolean> existsById(String Id);
	
	Mono<Void> delete(Customer customer);
	
	Flux<Company> getAllCompany();
	
	Mono<Company> findCompanyById(String Id);
	
	Mono<Company> saveCompany(Company company);
	
}
