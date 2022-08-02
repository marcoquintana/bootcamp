package com.nttdata.customerservice.api;

import com.nttdata.customerservice.model.document.Customer;
import com.nttdata.customerservice.model.service.CustomerService;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public Flux<Customer> getAll() {
		return customerService.getAll();
	}
	
	@GetMapping("/{id}")
	public Mono<ResponseEntity<Customer>> findById(@PathVariable String id) {
		return customerService.findById(id).map(c -> ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(c))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Mono<Customer> register(@RequestBody Customer customer) {
		return customerService.save(customer);
	}
}
