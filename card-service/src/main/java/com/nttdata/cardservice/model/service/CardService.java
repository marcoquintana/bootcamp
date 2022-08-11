package com.nttdata.cardservice.model.service;

import com.nttdata.cardservice.model.document.Card;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CardService {

  Flux<Card> getAll();

  Mono<Card> save(Card card);

  Mono<Card> findById(String id);

  Mono<Boolean> existsById(String id);
}
