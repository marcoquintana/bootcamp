package com.nttdata.cardservice.service;

import com.nttdata.cardservice.model.document.Card;
import com.nttdata.cardservice.model.repository.CardRepository;
import com.nttdata.cardservice.model.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CardServiceImpl implements CardService {

  @Autowired
  private CardRepository cardRepository;

  /**
   * @return
   */
  @Override
  public Flux<Card> getAll() {
    return this.cardRepository.findAll();
  }

  /**
   * @param card
   * @return
   */
  @Override
  public Mono<Card> save(Card card) {
    return this.cardRepository.save(card);
  }

  /**
   * @param id
   * @return
   */
  @Override
  public Mono<Card> findById(String id) {
    return this.cardRepository.findById(id);
  }

  /**
   * @param id
   * @return
   */
  @Override
  public Mono<Boolean> existsById(String id) {
    return this.cardRepository.existsById(id);
  }
}
