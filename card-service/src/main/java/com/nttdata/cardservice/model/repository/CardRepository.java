package com.nttdata.cardservice.model.repository;

import com.nttdata.cardservice.model.document.Card;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends ReactiveMongoRepository<Card, String> {

}
