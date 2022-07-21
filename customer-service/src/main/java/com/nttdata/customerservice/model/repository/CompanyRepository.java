package com.nttdata.customerservice.model.repository;

import com.nttdata.customerservice.model.document.Company;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends ReactiveMongoRepository<Company, String> {

}
