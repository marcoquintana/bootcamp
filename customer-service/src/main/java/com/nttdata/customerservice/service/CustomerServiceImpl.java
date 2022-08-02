package com.nttdata.customerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.customerservice.model.document.Company;
import com.nttdata.customerservice.model.document.Customer;
import com.nttdata.customerservice.model.repository.CompanyRepository;
import com.nttdata.customerservice.model.repository.CustomerRepository;
import com.nttdata.customerservice.model.service.CustomerService;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public Flux<Customer> getAll() {
		return this.customerRepository.findAll();
	}

	@Override
	public Mono<Customer> save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Mono<Customer> findById(String id) {
		return this.customerRepository.findById(id);
	}

	@Override
	public Mono<Boolean> existsById(String id) {
		return this.customerRepository.existsById(id);
	}

	@Override
	public Mono<Void> delete(Customer customer) {
		return this.customerRepository.delete(customer);
	}

	@Override
	public Flux<Company> getAllCompany() {
		return this.companyRepository.findAll();
	}

	@Override
	public Mono<Company> findCompanyById(String id) {
		return this.companyRepository.findById(id);
	}

	@Override
	public Mono<Company> saveCompany(Company company) {
		return this.companyRepository.save(company);
	}

}
